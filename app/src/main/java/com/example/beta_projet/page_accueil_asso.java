package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class page_accueil_asso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil_asso);

        Intent in=getIntent();
        Bundle b=in.getExtras();
        String nomAsso = (String) b.get("nomAsso");

        TextView t_nom=(TextView) findViewById(R.id.texte_nom);
        t_nom.setText(nomAsso);
    }
}
