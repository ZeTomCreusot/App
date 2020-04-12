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

            /* les instructions "classiques" : a la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnProduit = (Button) findViewById(R.id.valider);
        btnAsso = (Button) findViewById(R.id.valider2);

        btnAsso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();

            }
        });


        // btn.setText("Validez");
        btnProduit.setOnClickListener(new View.OnClickListener() {

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

    
