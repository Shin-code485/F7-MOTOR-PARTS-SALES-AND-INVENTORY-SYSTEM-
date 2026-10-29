package f7motorparts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private static final String URL =
        "jdbc:mysql://localhost:3306/inventorysystem";

    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection connect() {

        try {

            Connection conn =
                DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully!");

            return conn;

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();

            return null;
        }
    }

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}