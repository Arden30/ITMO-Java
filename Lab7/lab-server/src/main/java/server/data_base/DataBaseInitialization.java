package server.data_base;

import common.data.Coordinates;
import common.data.Difficulty;
import common.data.Discipline;
import common.data.LabWork;
import server.util_server.CollectionManager;

import java.sql.*;
import java.util.ArrayDeque;

public class DataBaseInitialization {
    private final Connection connection;
    private final Statement statement;

    public DataBaseInitialization(Connection connection) throws SQLException {
        this.connection = connection;
        this.statement = connection.createStatement();
    }

    public void initializeDB() throws SQLException{
        statement.executeUpdate("CREATE SEQUENCE IF NOT EXISTS ids START 1;");
        createUsersTable();
        createLabTable();
    }

    public void createLabTable() throws SQLException{
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS s367058Labs (" +
                "id bigint PRIMARY KEY DEFAULT (nextval('ids'))," +
                "nameOfLab TEXT NOT NULL," +
                "x NUMERIC NOT NULL CHECK(x <= 54)," +
                "y NUMERIC NOT NULL CHECK(y <= 101)," +
                "creationDate DATE DEFAULT (current_date)," +
                "minimalPoints NUMERIC CHECK(minimalPoints > 0)," +
                "maximumPoints NUMERIC CHECK(maximumPoints > 0)," +
                "personalQualitiesMinimumPoints NUMERIC," +
                "difficulty text CHECK(difficulty = 'EASY'" +
                "OR difficulty = 'VERY_HARD'" +
                "OR difficulty = 'HOPELESS'" +
                "OR difficulty = 'TERRIBLE' OR difficulty = null)," +
                "nameOfDiscipline TEXT NOT NULL," +
                "lectureHours NUMERIC NOT NULL CHECK(lectureHours > 0)," +
                "practiceHours NUMERIC NOT NULL CHECK(practiceHours > 0)," +
                "owner_name TEXT NOT NULL REFERENCES s367058Users(name));");
    }

    private void createUsersTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS s367058Users (" +
                "name VARCHAR(70) PRIMARY KEY NOT NULL," +
                "password VARCHAR(255) NOT NULL);");
    }

    public ArrayDeque<LabWork> fillCollection(Connection connection) throws SQLException{
        PreparedStatement statementCollection = connection.prepareStatement(Statements.getAll.getStatement());
        ResultSet resultSet = statementCollection.executeQuery();
        ArrayDeque<LabWork> collection = new ArrayDeque<>();
        while (resultSet.next()) {
            LabWork labWork = new LabWork();
            Coordinates coordinates = new Coordinates();
            coordinates.setX(resultSet.getLong("x"));
            coordinates.setY(resultSet.getDouble("y"));
            labWork.setId(resultSet.getLong("id"));
            labWork.setName(resultSet.getString("nameOfLab"));
            labWork.setCoordinates(coordinates);
            labWork.setCreationDate(resultSet.getTimestamp(5).toLocalDateTime());
            labWork.setMinimalPoint(resultSet.getLong("minimalPoints") > 0 ? resultSet.getLong("minimalPoints") : null);
            labWork.setMaximumPoint(resultSet.getInt("maximumPoints") > 0 ? resultSet.getInt("maximumPoints") : null);
            labWork.setPersonalQualitiesMinimum(resultSet.getLong("personalQualitiesMinimumPoints") > 0 ? resultSet.getLong("personalQualitiesMinimumPoints") : null);
            labWork.setDifficulty(resultSet.getString("difficulty") != null ? Difficulty.valueOf(resultSet.getString("difficulty")) : null);
            Discipline discipline = new Discipline();
            discipline.setName(resultSet.getString("nameOfDiscipline"));
            discipline.setLectureHours(resultSet.getLong("lectureHours"));
            discipline.setPracticeHours(resultSet.getLong("practiceHours"));
            labWork.setDiscipline(discipline);
            labWork.setUsername(resultSet.getString("owner_name"));
            collection.add(labWork);
        }
        return collection;
    }
}
