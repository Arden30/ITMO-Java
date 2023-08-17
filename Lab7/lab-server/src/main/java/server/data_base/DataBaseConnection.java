package server.data_base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnection {
    public Connection connect() throws SQLException{
        Properties info = new Properties();
        try {
            info.load(new FileInputStream("lab-server/src/main/resources/db.cfg"));
            Class.forName("org.postgresql.Driver");
        } catch (IOException e) {
            System.out.println("Problems with config file!");
        } catch (ClassNotFoundException e) {
            System.out.println("No available DB driver found!");
        }
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/studs", info);
    }
}
