package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page_accueil_produit extends AppCompatActivity {


    Button boutonAjouteProduit;
    Button boutonListeProduits;
    Button boutonEnleveProduit;
    private Button bouton_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil_produit);

        bouton_retour = (Button) findViewById(R.id.bouton_retour);
        bouton_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retour_page_produit();
            }
        });

        //Récupération et affichage du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAssoP = (String) b.get("nomAssoP");
        TextView t_nom=(TextView) findViewById(R.id.texte_nom);
        t_nom.setText(nomAssoP);



        // association de nos references avec les objets du layout
        boutonAjouteProduit = (Button) findViewById(R.id.btn_ajout_element);
        boutonListeProduits = (Button) findViewById(R.id.btn_voir_liste);
        boutonEnleveProduit = (Button) findViewById(R.id.btn_supprimer_element);

        // ajout des écouuteurs : quand on va cliqueur sur un bounton on va charger l'activité associée
        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonAjouteProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                ouvrirAjoutProduit(nomAssoP);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonListeProduits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirListeProduit(nomAssoP);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant

        boutonEnleveProduit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                ouvrirSupprimerProduit(nomAssoP);
            }
        });




    }
    private void retour_page_produit()
    {
        Intent intent = new Intent(this, Associations.class);
        startActivity(intent);
    }
    private void ouvrirAjoutProduit(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_produit.this, AjoutProduit.class);
        intent.putExtra("nomAssoP",nom_asso);
        startActivity(intent);
    }
    private void ouvrirListeProduit(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_produit.this, ListeProduits.class);
        intent.putExtra("nomAssoP",nom_asso);
        startActivity(intent);
    }
    private void ouvrirSupprimerProduit(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_produit.this, SupprimerProduit.class);
        intent.putExtra("nomAssoP",nom_asso);
        startActivity(intent);
    }
}

