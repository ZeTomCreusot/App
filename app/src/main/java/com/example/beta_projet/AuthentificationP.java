package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AuthentificationP extends AppCompatActivity {

    Button btn;
    EditText login;
    EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification_p);
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoP");



        btn = (Button)findViewById(R.id.test2);
        login=findViewById(R.id.Login2);
        mdp=findViewById(R.id.Password2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motdepasse = mdp.getText().toString();
                String identifiant= login.getText().toString();


                if (identifiant.equals("X") && motdepasse.equals("Y")) {
                    ouvrirAjouterProduit(nomAsso);
                }
                else
                {
                    Toast.makeText(AuthentificationP.this, "mdp ou identifiant erroné! " , Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void ouvrirAjouterProduit(String nom_asso)
    {

        Intent intent = new Intent(AuthentificationP.this, AjoutProduit.class);
        intent.putExtra("nomAssoP",nom_asso);
        startActivity(intent);

    }
}

