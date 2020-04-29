package com.example.beta_projet;

public class Etudiant {


    // attributs personnalisés pour la classe Etudiant
    public String nom;
    public String prenom;
    public String annee;

    //Constructeur avec  3 paramètres
     public Etudiant (String p_nom,  String p_prenom, String p_annee ) {
        nom = p_nom;
        prenom = p_prenom;
        annee = p_annee;
    }

    @Override
    public String toString() {
        return "Hello : "+ prenom + " "+ nom + ", enchanté!\n";
    }
}
