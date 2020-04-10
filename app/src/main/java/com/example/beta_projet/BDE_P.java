package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BDE_P extends AppCompatActivity {
    private Button button_retour2;

    // creation des references boutons présents dans le layout
    // déclaration, sans initialisation
    Button boutonAjouteEtudiant;
    Button boutonListeEtudiants;
    Button boutonEnleveEtudiant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date2);




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
                Intent intent = new Intent(BDE_P.this, AjoutEtudiant.class);
                startActivity(intent);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                Intent intent = new Intent(BDE_P.this, ListeEtudiants.class);
                startActivity(intent);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonEnleveEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                Intent intent = new Intent(BDE_P.this, SupprimerEtudiant.class);
                startActivity(intent);
            }
        });



        button_retour2 = (Button) findViewById(R.id.button_retour2);

        button_retour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();

            }
        });
    }

    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, Date.class);
        startActivity(intent);
    }


}
