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
    private Button bouttonsuivant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        produit = (EditText)findViewById(R.id.produit2);

        Spinner monSpinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource (this,
                R.array.tab_assos, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);
//test
        // 5) Association de adapter au spinner
        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // View : Un objet de type view est associé au choix fait dans le spinner
            public void onItemSelected(AdapterView<?> spinner2, View view, int position, long
                    id) {
                // on met ici ce qu’il faut faire lorsqu’un item a ete selectionne
                System.out.println("Vous avez selectionné");
                String ASSO = spinner2.getSelectedItem().toString();
                System.out.println("Vous avez selectionné : "+ASSO);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // on met ici ce qu’il faut faire lorsqu’aucun item n’est selectionne
                System.out.println("aucun item n’est selectionné");
            }



        });



        bouttonretour = (Button) findViewById(R.id.button_retour);
        bouttonsuivant = (Button) findViewById(R.id.boutton_suivant);

        bouttonsuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();

            }
        });

        bouttonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();

            }
        });
    }
    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void visualiser_la_suite2()
    {
        Intent intent = new Intent(this, Date2.class);
        startActivity(intent);
    }

}