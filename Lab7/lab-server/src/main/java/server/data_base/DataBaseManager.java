package server.data_base;

import common.data.LabWork;
import server.util_server.PasswordEncryptor;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBaseManager {
    private final Connection connection;
    public DataBaseManager(Connection connection) {
        this.connection = connection;
    }
    public Long addLab(LabWork lab, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.addLab.getStatement(), Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, lab.getName());
            statement.setLong(2, lab.getCoordinates().getX());
            statement.setDouble(3, lab.getCoordinates().getY());
            statement.setDate(4, Date.valueOf(LocalDate.now()));
            if (lab.getMinimalPoint() != null) {
                statement.setLong(5, lab.getMinimalPoint());
            } else {
                statement.setNull(5, Types.NUMERIC);
            }
            if (lab.getMaximumPoint() != null) {
                statement.setLong(6, lab.getMaximumPoint());
            } else {
                statement.setNull(6, Types.NUMERIC);
            }
            if (lab.getPersonalQualitiesMinimum() != null) {
                statement.setLong(7, lab.getPersonalQualitiesMinimum());
            } else {
                statement.setNull(7, Types.NUMERIC);
            }
            statement.setString(8, lab.getDifficulty() != null ? lab.getDifficulty().toString() : null);
            statement.setString(9, lab.getDiscipline().getName());
            statement.setLong(10, lab.getDiscipline().getLectureHours());
            statement.setLong(11, lab.getDiscipline().getPracticeHours());
            statement.setString(12, username);
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            return result.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Long> clear(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.clear.getStatement());
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            List<Long> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getLong("id"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean removeLabByID(Long id, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.deleteLab.getStatement());
            statement.setLong(1, id);
            statement.setString(2, username);
            int deletedBands = statement.executeUpdate();
            return deletedBands > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkID(Long id, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.checkID.getStatement());
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count") > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLab(LabWork lab, Long id, String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.updateLab.getStatement());
            statement.setString(1, lab.getName());
            statement.setLong(2, lab.getCoordinates().getX());
            statement.setDouble(3, lab.getCoordinates().getY());
            if (lab.getMinimalPoint() != null) {
                statement.setLong(4, lab.getMinimalPoint());
            } else {
                statement.setNull(4, Types.NUMERIC);
            }
            if (lab.getMaximumPoint() != null) {
                statement.setLong(5, lab.getMaximumPoint());
            } else {
                statement.setNull(5, Types.NUMERIC);
            }
            if (lab.getPersonalQualitiesMinimum() != null) {
                statement.setLong(6, lab.getPersonalQualitiesMinimum());
            } else {
                statement.setNull(6, Types.NUMERIC);
            }
            statement.setString(7, lab.getDifficulty() != null ? lab.getDifficulty().toString() : null);
            statement.setString(8, lab.getDiscipline().getName());
            statement.setLong(9, lab.getDiscipline().getLectureHours());
            statement.setLong(10, lab.getDiscipline().getPracticeHours());
            statement.setLong(11, id);
            statement.setString(12, username);
            int update = statement.executeUpdate();
            return update > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void addUser(String username, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.addUser.getStatement());
            statement.setString(1, username);
            statement.setString(2, PasswordEncryptor.encryptPassword(password));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPassword(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.getPass.getStatement());
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("password");
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkUserExist(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.checkUser.getStatement());
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("count") > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Long> getUsersLabsIDs(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement(Statements.getPass.getStatement());
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            List<Long> list = new ArrayList<>();
            while (resultSet.next()) {
                list.add(resultSet.getLong("id"));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean validateUser(String username, String password) {
        return PasswordEncryptor.encryptPassword(password).equals(getPassword(username));
    }
}
