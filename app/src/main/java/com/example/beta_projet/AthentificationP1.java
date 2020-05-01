package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AthentificationP1 extends AppCompatActivity {

    Button btn;
    EditText mdp;
    EditText login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athentification_p1);
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoP");



        btn = (Button)findViewById(R.id.testp1);
        login=findViewById(R.id.Loginp1);
        mdp=findViewById(R.id.Passwordp1);

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
                    Toast.makeText(AthentificationP1.this, "mdp ou identifiant erroné! " , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void ouvrirSupprimerEtudiant(String nom_asso)
    {

        Intent intent = new Intent(AthentificationP1.this, SupprimerProduit.class);
        intent.putExtra("nomAssoP",nom_asso);
        startActivity(intent);

    }
}
