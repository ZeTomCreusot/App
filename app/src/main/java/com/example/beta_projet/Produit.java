package com.example.beta_projet;

public class Produit {

    // attributs personnalisés pour la classe Produit
    public String nomProduit;
    public String provenanceProduit;
    public String datePeremptionProduit;

    // constructeur classique (3 parametres affectant les attributs)
    public Produit (String p_nom,  String p_provenance, String p_peremption) {
        nomProduit = p_nom;
        provenanceProduit = p_provenance;
        datePeremptionProduit = p_peremption;
    }

    // la méthode toString. Classique mais inutilisée ici
    // employée seulement à des fins de debug
    @Override
    public String toString() {
        return "Produit : "+ nomProduit;
    }
}
