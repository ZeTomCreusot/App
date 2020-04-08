package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    // creation des references boutons que je vais trouver dans le layout
    // déclaration, sans initialisation
    Button boutonAjouteEtudiant;
    Button boutonListeEtudiants;
    Button boutonEnleveEtudiant;


    private Button btn;
    private Button valider2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

            /* les instructions "classiques" : a la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = new Intent(MainActivity.this, AjoutEtudiant.class);
                startActivity(intent);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                Intent intent = new Intent(MainActivity.this, ListeEtudiants.class);
                startActivity(intent);
            }
        });

        // ajout de l'écouteur sur boutonAjouterEtudiant
        boutonEnleveEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ovuerture de l'activité AjoutEtudiant
                Intent intent = new Intent(MainActivity.this, SupprimerEtudiant.class);
                startActivity(intent);
            }
        });


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn = (Button) findViewById(R.id.valider);
        valider2 = (Button) findViewById(R.id.valider2);


        valider2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();

            }
        });


        // btn.setText("Validez");
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
             public void onClick(View view) {
                // System.out.println(produit.getText());
                visualiser_la_suite();

            }
             });
             }
             private void visualiser_la_suite()
             {
             Intent intent = new Intent(this, Date.class);
             startActivity(intent);
             }
    private void visualiser_la_suite2()
    {
        Intent intent = new Intent(this, Associations.class);
        startActivity(intent);
    }
        }

    
