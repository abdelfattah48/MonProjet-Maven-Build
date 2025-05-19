package com.example.service;

import com.example.model.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestionStockService {

    private List<Produit> produits;

    public GestionStockService(){
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        System.out.println(" Produit ajouté avec succès.");
    }

    public boolean supprimerProduitParId(int id) {
        Optional<Produit> produitASupprimer = produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        if (produitASupprimer.isPresent()) {
            produits.remove(produitASupprimer.get());
            System.out.println(" Produit supprimé avec succès.");
            return true;
        } else {
            System.out.println(" Produit avec ID " + id + " non trouvé.");
            return false;
        }
    }

    public boolean mettreAJourProduit(int id, Produit nouveauProduit) {
        for (int i = 0; i < produits.size(); i++) {
            if (produits.get(i).getId() == id) {
                produits.set(i, nouveauProduit);
                System.out.println(" Produit mis à jour avec succès.");
                return true;
            }
        }
        System.out.println(" Produit avec ID " + id + " non trouvé.");
        return false;
    }

    public void afficherTousLesProduits() {
        if (produits.isEmpty()) {
            System.out.println(" Aucun produit en stock.");
        } else {
            produits.forEach(System.out::println);
        }
    }

    public Produit rechercherParId(int id) {
        return produits.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Produit> rechercherParNom(String nom) {
        List<Produit> resultats = new ArrayList<>();
        for (Produit p : produits) {
            if (p.getNom().toLowerCase().contains(nom.toLowerCase())) {
                resultats.add(p);
            }
        }
        return resultats;
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
