package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentification1 extends AppCompatActivity {

    EditText mdp;
    EditText login;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification1);

        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoA");



        btn = (Button)findViewById(R.id.test1);
        login=findViewById(R.id.Login1);
        mdp=findViewById(R.id.Password1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motdepasse = mdp.getText().toString();
                String identifiant= login.getText().toString();


                if (identifiant.equals("X") && motdepasse.equals("Y")) {
                    ouvrirSupprimerEtudiant(nomAsso);
                }
                else
                {
                    Toast.makeText(Authentification1.this, "mdp ou identifiant erroné! " , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void ouvrirSupprimerEtudiant(String nom_asso)
    {

        Intent intent = new Intent(Authentification1.this, AjoutEtudiant.class);
        intent.putExtra("nomAssoA",nom_asso);
        startActivity(intent);

    }
}
