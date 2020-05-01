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


    private Button btnProduit;
    private Button btnAsso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            /* les instructions "classiques" et présentes dans toutes les activités : à la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Déclaration des boutons permettant d'aller sur les activités Produit/Association

        btnProduit = (Button) findViewById(R.id.produit);
        btnAsso = (Button) findViewById(R.id.association);

        //Méthode d'activation du bouton btnasso, permettant d'accéder à la page concernant les associations
        btnAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();
            } //si l'utilisateur clique sur le bouton Association, il est redirigé vers l'activité concernant les association
        });

        //Activation du bouton btnProduit
        btnProduit.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View view) { visualiser_la_suite(); } //Utilisateur redirigé vers l'activité concernant les produits
             });
             }


             //Démarrage de la page Produits
             private void visualiser_la_suite()
             {
             Intent intent = new Intent(this, Produits.class); //déclartion d'un objet intent pour démarrer l'activité
             startActivity(intent); //méthode de démarrage de l'activité
             }

             //Démarrage de la page Associations
             private void visualiser_la_suite2()

             {
                 Intent intent = new Intent(this, Associations.class);
                 startActivity(intent);
             }
        }

    
