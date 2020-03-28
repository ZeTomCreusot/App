package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class Date extends AppCompatActivity {
    private Button bouttonretour;
    private EditText produit;
    public ListView ListeProduits;
    public String nouveauProduit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);


        Spinner monSpinner = (Spinner) findViewById(R.id.ListeAsso);
        ArrayAdapter<CharSequence> monAdapter = ArrayAdapter.createFromResource (this,
                R.array.tab_assos, android.R.layout.simple_spinner_item);
        monAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monSpinner.setAdapter(monAdapter);
        monSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner_Asso, View view, int position, long
                    id) {
                String text = spinner_Asso.getSelectedItem().toString();
                if (text.equals("BDS")) {
                    afficherListeProduitsBDS();
                    produit = (EditText)findViewById(R.id.produitEntre);
                    nouveauProduit=produit.getText().toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
        bouttonretour = (Button) findViewById(R.id.button_retour);
        bouttonretour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite_PageA();
            }
        });
    }
    private void visualiser_la_suite_PageA()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void afficherListeProduitsBDS(){
        ListeProduits= findViewById(R.id.ListeProduits);
        String[] listeProduits=new String[]
                {
                        "Pain",
                        "Lait",
                        "Jus",
                };
        ArrayAdapter<String> arrayAdapteur= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listeProduits);
        ListeProduits.setAdapter(arrayAdapteur);
    }


}
