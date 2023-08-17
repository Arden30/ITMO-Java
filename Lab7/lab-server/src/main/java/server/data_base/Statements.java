package server.data_base;

public enum Statements {

    addLab("INSERT INTO s367058Labs " +
            "(nameOfLab, x, y, creationDate, minimalPoints, maximumPoints, personalQualitiesMinimumPoints, difficulty, " +
            "nameOfDiscipline, lectureHours, practiceHours, owner_name)" +
            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"),
    getAll("SELECT * FROM s367058Labs;"),
    getNextId("SELECT nextval('ids');"),
    deleteLab("DELETE FROM s367058Labs USING s367058Users WHERE s367058Labs.id = ? AND " +
            "s367058Labs.owner_name = s367058Users.name AND s367058Users.name = ?;"),
    clear("DELETE FROM s367058Labs USING s367058Users WHERE s367058Labs.owner_name = s367058Users.name and s367058Users.name = ?" +
            "RETURNING s367058Labs.id;"),
    updateLab("UPDATE s367058Labs SET nameOfLab = ?, x = ?, y = ?, minimalPoints = ?, " +
            "maximumPoints = ?, personalQualitiesMinimumPoints = ?, difficulty = ?, " +
            "nameOfDiscipline = ?, lectureHours = ?, practiceHours = ? FROM s367058Users WHERE s367058Labs.id = ? " +
            "AND s367058Labs.owner_name = s367058Users.name AND s367058Users.name = ?;"),
    checkID("SELECT COUNT(*) FROM s367058Labs WHERE s367058Labs.id = ?;"),
    addUser("INSERT INTO s367058Users VALUES (?, ?);"),
    getPass("SELECT password FROM s367058Users WHERE s367058Users.name = ?;"),

    getUsers("SELECT s367058Labs.owner_name FROM s367058Labs, s367058Users" +
            "WHERE s367058Labs.owner_name = s367058Users.name"),
    checkUser("SELECT COUNT (*) FROM s367058Users WHERE s367058Users.name = ?;");
    private final String statement;

    Statements(String statement) {
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }
}
