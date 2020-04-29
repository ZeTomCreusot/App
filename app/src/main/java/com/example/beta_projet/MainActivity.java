package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



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

        btnAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();
            } //si l'utilisateur clique sur le bouton Association, il est redirigé vers l'activité concernant les association
        });

        // btn.setText("Validez");
        btnProduit.setOnClickListener(new View.OnClickListener() {

            @Override
             public void onClick(View view) {
                // System.out.println(produit.getText());
                visualiser_la_suite();
            } //Utilisateur redirigé vers l'activité concernant les produits
             });
             }

             private void visualiser_la_suite()
             {
             Intent intent = new Intent(this, Produits.class);
             startActivity(intent);
             }

             private void visualiser_la_suite2()

             {
                 Intent intent = new Intent(this, Associations.class);
                 startActivity(intent);
             }
        }

    
