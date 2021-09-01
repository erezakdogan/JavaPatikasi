package app.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
    private Connection connect = null;
    public Connection connectDB(){

        try {
            this.connect = DriverManager.getConnection(Config.DB_URL,Config.DB_USER,Config.DB_PASS);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return this.connect;
    }
    public static Connection getInstance(){
        DBConnector dbConnector = new DBConnector();
        return dbConnector.connectDB();
    }
}
