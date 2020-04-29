package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Produits extends AppCompatActivity {
    private Button bouttonretour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produits);

        Spinner monSpinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource (this,
                R.array.tab_assos2, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);

        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            // View : Un objet de type view est associé au choix fait dans le spinner
            public void onItemSelected(AdapterView<?> spinner2, View view, int position, long
                    id) {
                // on met ici ce qu’il faut faire lorsqu’un item a ete selectionne
                //System.out.println("Vous avez selectionné");
                String ASSO = spinner2.getSelectedItem().toString();
                //System.out.println("Vous avez selectionné : "+ASSO);
                if(ASSO.equals("Choisissez votre association"))
                {
                }
                else
                {
                    afficher_la_suite(ASSO);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // on met ici ce qu’il faut faire lorsqu’aucun item n’est selectionne
                System.out.println("aucun item n’est selectionné");
            }
        });
        bouttonretour = (Button) findViewById(R.id.button_retour);

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

    private void afficher_la_suite(String nom_assoP)
    {
        Intent intent = new Intent(this, page_accueil_produit.class);
        intent.putExtra("nomAssoP",nom_assoP);
        startActivity(intent);
    }



}