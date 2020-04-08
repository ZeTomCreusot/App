package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class Associations extends AppCompatActivity {

    private Button bouttonretour;
    public ListView listeMembresAsso;
    private Button bouttonsuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_associations);

        bouttonsuivant = (Button) findViewById(R.id.boutton_suivant);

        bouttonsuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite2();

            }
        });

        bouttonretour = (Button) findViewById(R.id.button_retour);
        bouttonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();

            }
        });

        Spinner monSpinner = findViewById(R.id.spinner_Asso);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource(this, R.array.tab_assos, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);
        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner_Asso, View view, int position, long id) {

                String text = spinner_Asso.getSelectedItem().toString();
                if(text.equals("BDS"))
                {
                    afficherListeMembres1(); }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
        Intent intent = new Intent(this, BDA_A.class);
        startActivity(intent);
    }

    private void afficherListeMembres1(){
        listeMembresAsso= findViewById(R.id.ListeMembresAsso);
        String[] listeMembres=new String[]
                {
                        "Jean-Louis",
                        "Jean-Erwan",
                        "Jean-Michel",
                };

        ArrayAdapter<String> arrayAdapteur= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listeMembres);
        listeMembresAsso.setAdapter(arrayAdapteur);
    }


}

