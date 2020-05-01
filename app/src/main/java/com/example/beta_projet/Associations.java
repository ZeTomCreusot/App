package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;

public class Associations extends AppCompatActivity {

    private Button bouttonretour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);

        bouttonretour = (Button) findViewById(R.id.button_retour);
        //Activation du bouton retour permettant de retourner à l'accueil
        bouttonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retour_page_accueil();

            }
        });

        //Spinner des associations
        Spinner monSpinner = findViewById(R.id.spinner_Asso); //Déclaration du spinner et association à l'élément spinner du xml
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource(this, R.array.tab_assos, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);
        //Activation des items du spinner
        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner_Asso, View view, int position, long id) {

                String Asso = spinner_Asso.getSelectedItem().toString(); //on récupère la valeur de l'item choisi

                //comparaison de l'item choisi, et ouverture de l'activité page_accueil_asso
                //On souhaite qu'à l'ouverture de la nouvelle activité, on ait gardé en mémoire le choix de l'utilisateur, pour ensuite accéder
                // aux bonne informations, concernant bien l'association choisie
                if(Asso.equals("Choisissez votre association"))
                {

                }
                else
                {
                    afficher_page_Asso(Asso);
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }

    //méthode de retour à l'accueil
    private void retour_page_accueil()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //méthode d'ouverture de la page_accueil_asso
    private void afficher_page_Asso(String nom_assoA)
    {

        Intent intent = new Intent(this, page_accueil_asso.class);
        intent.putExtra("nomAssoA", nom_assoA); //on passe en argument de l'intent la valeur de l'item choisi
        startActivity(intent);
    }




}

