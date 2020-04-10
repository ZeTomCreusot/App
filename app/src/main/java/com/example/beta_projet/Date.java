package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Date extends AppCompatActivity {
    private Button bouttonretour;
    //private EditText produit;
    //private Button bouttonsuivant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

       // produit = (EditText)findViewById(R.id.produit2);

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
                //System.out.println("Vous avez selectionné");
                String ASSO = spinner2.getSelectedItem().toString();
                //System.out.println("Vous avez selectionné : "+ASSO);
                if(ASSO.equals("BDE"))
                {
                    visualiser_la_suiteBDE();
                }
                if(ASSO.equals("BDS"))
                {
                    visualiser_la_suiteBDS();
                }
                if(ASSO.equals("BDJ"))
                {
                    visualiser_la_suiteBDJ();
                }
                if(ASSO.equals("BDO"))
                {
                    visualiser_la_suiteBDO();
                }
                if(ASSO.equals("BDA"))
                {
                    visualiser_la_suiteBDA();
                }
                if(ASSO.equals("1 pour Tous"))
                {
                    visualiser_la_suiteUPT();
                }
                if(ASSO.equals("Tyrans"))
                {
                    visualiser_la_suiteTyrans();
                }
                if(ASSO.equals("EPF Sud Conseil"))
                {
                    visualiser_la_suiteESC();
                }
                if(ASSO.equals("Helphi"))
                {
                    visualiser_la_suiteHelphi();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // on met ici ce qu’il faut faire lorsqu’aucun item n’est selectionne
                System.out.println("aucun item n’est selectionné");
            }



        });



        bouttonretour = (Button) findViewById(R.id.button_retour);
        //bouttonsuivant = (Button) findViewById(R.id.boutton_suivant);

        /*bouttonsuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suiteBDE();

            }
        });*/

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

    private void visualiser_la_suiteBDE()
    {
        Intent intent = new Intent(this, BDE_P.class);
        startActivity(intent);
    }

    private void visualiser_la_suiteBDS()
    {
        Intent intent = new Intent(this, BDS_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteBDJ()
    {
        Intent intent = new Intent(this, BDJ_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteBDO()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteBDA()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteUPT()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteTyrans()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteESC()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }
    private void visualiser_la_suiteHelphi()
    {
        Intent intent = new Intent(this, BDO_P.class);
        startActivity(intent);
    }

}