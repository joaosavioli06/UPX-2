/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author savio
 */

public class ConnectionUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/projectdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Jj081123";

    // Hold the connection as a singleton
    private static Connection connection = null;

    public static Connection getConnection() { // importar função para rodar
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection to MySQL established successfully.");
            } catch (SQLException e) {
                System.out.println("Failed to connect to MySQL.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() { // chamar para parar 
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
} 