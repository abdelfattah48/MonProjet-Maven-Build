package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_stock";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println(" Driver non trouvé : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println(" Erreur de connexion à la base de données : " + e.getMessage());
        }
        return null;
    }
}
