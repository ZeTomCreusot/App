package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page_accueil_asso extends AppCompatActivity {

    Button boutonAjouteEtudiant;
    Button boutonListeEtudiants;
    Button boutonEnleveEtudiant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil_asso);

        //Récupération et affichage du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAsso");
        TextView t_nom=(TextView) findViewById(R.id.texte_nom);
        t_nom.setText(nomAsso);



        // association de nos references avec les objets du layout
        boutonAjouteEtudiant = (Button) findViewById(R.id.btn_ajout_element);
        boutonListeEtudiants = (Button) findViewById(R.id.btn_voir_liste);
        boutonEnleveEtudiant = (Button) findViewById(R.id.btn_supprimer_element);

        // ajout des écouuteurs : quand on va cliqueur sur un bounton on va charger l'activité associée
        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonAjouteEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                ouvrirAjoutEtudiant(nomAsso);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirListeEtudiant(nomAsso);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant

        boutonEnleveEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                ouvrirSupprimerEtudiant(nomAsso);
            }
        });




    }
    private void ouvrirAjoutEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, AjoutEtudiant.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
    private void ouvrirListeEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, ListeEtudiants.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
    private void ouvrirSupprimerEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, SupprimerEtudiant.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
}
