package com.example.service;

import com.example.model.Produit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionStockServiceJdbc {

    private static final String URL = "jdbc:mysql://localhost:3306/gestion_stock";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void ajouterProduit(Produit produit) {
        String sql = "INSERT INTO produits (nom, quantite, prix) VALUES (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, produit.getNom());
                stmt.setInt(2, produit.getQuantite());
                stmt.setDouble(3, produit.getPrix());

                int lignes = stmt.executeUpdate();
                if (lignes > 0) {
                    System.out.println(" Produit ajouté avec succès !");
                }

            }
        } catch (ClassNotFoundException e) {
            System.out.println(" Driver JDBC introuvable : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur de connexion ou d'ajout : " + e.getMessage());
        }
    }
}
