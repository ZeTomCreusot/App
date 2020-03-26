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
    private Button boutonProduits;
    private Button boutonAsso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        boutonProduits = (Button) findViewById(R.id.produit);
        boutonProduits.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View view) {
             visualiser_la_suite_Produits();
             }
             });

        boutonAsso = findViewById(R.id.asso);
        boutonAsso.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view){
                visualiser_la_suite_Asso();
            }
        });
    }

             private void visualiser_la_suite_Produits()
             {
             Intent intent = new Intent(this, Date.class);
             startActivity(intent);
             }

             private void visualiser_la_suite_Asso(){
             Intent intent = new Intent (this, Associations.class);
             startActivity(intent);
             }
        }

    
