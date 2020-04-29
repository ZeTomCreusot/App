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




    private Button btn;
    private Button valider2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/************************/
/****NOTIFS**************/
/***********************/

//* Récupération de l'évènement quand l'app reçoit un message de firebase
// Le but du jeu est d'intercepter les notifications envoyées depuis firebase sur le cloud





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

    
