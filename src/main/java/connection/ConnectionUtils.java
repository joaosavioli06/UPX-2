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
    private static final String PASSWORD = ""; // You thought I was gonna leave the password here?

    // Método para obter uma nova conexão sempre que for chamado
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o Banco de Dados");
            e.printStackTrace();
        }
        return connection;
    }

    // Método para fechar a conexão passada como parâmetro
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

