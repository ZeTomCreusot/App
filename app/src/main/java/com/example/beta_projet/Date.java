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

public class Date extends AppCompatActivity {
    private Button bouttonretour;
    private EditText produit;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        btn1 = (Button) findViewById(R.id.valider3);



        btn1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                System.out.println(produit.getText());
                visualiser_la_suite();

            }
        });





        Spinner monSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource (this,
                R.array.tab_assos, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);
//test
        // 5) Association de adapter au spinner
        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // View : Un objet de type view est associé au choix fait dans le spinner
            public void onItemSelected(AdapterView<?> spinner_pokemon, View view, int position, long
                    id) {
                // on met ici ce qu’il faut faire lorsqu’un item a ete selectionne
                System.out.println("un item a été selectionné");
                String text = spinner_pokemon.getSelectedItem().toString();
                System.out.println("un item a été selectionné : "+text);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // on met ici ce qu’il faut faire lorsqu’aucun item n’est selectionne
                System.out.println("aucun item n’est selectionné");
            }



        });

        produit = (EditText)findViewById(R.id.produit);

        bouttonretour = (Button) findViewById(R.id.button_retour);
        bouttonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();

            }
        });


        btn1 = (Button) findViewById(R.id.valider3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite_suite();

            }
        });
    }
    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void visualiser_la_suite_suite()
    {
        Intent intent = new Intent(this, Membres.class);
        startActivity(intent);
    }


}