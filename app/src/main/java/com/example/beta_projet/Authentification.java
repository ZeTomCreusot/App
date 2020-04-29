package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Authentification extends AppCompatActivity {

    private Button btn;
    EditText login;
    EditText mdp;
   // private String motdepasse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);
/*
        //Affichage et récupération du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAsso");
        TextView t_nom=(TextView) findViewById(R.id.textView7);
        t_nom.setText(nomAsso);
*/
        btn = (Button)findViewById(R.id.test);
        login=findViewById(R.id.Login);
        mdp=findViewById(R.id.Password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motdepasse = mdp.getText().toString();


                    if (login.equals("X") && motdepasse.equals("Y")) {
                        ouvrirAjoutEtudiant();
                    }

            }
        });

    }

    private void ouvrirAjoutEtudiant()
    {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
