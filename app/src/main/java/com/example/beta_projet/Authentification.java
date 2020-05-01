package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Authentification extends AppCompatActivity {

    private Button btn;
    EditText login;
    EditText mdp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        Intent in=getIntent();
            Bundle b=in.getExtras();
            final String nomAsso = (String) b.get("nomAssoA");

        TextView test=(TextView) findViewById(R.id.textView8);
        test.setText(nomAsso);

        btn = (Button)findViewById(R.id.test);
        login=findViewById(R.id.Login);
        mdp=findViewById(R.id.Password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motdepasse = mdp.getText().toString();
                String identifiant= login.getText().toString();


                    //Si l'utilisateur entre le bon identifiant et le bon mdp, il est redirigé vers la page de suppression des étudiants
                    if (identifiant.equals("X") && motdepasse.equals("Y")) {
                        ouvrirSupprimerEtudiant(nomAsso); //méthode d'ouverture de l'activité SupprimerEtudiant, avec le nom de l'association en argument
                    }
                    else
                    {
                        //affichage provisoire d'un message d'erreur
                        Toast.makeText(Authentification.this, "mdp ou identifiant erroné! " , Toast.LENGTH_SHORT).show();
                    }

            }
        });

    }

    private void ouvrirSupprimerEtudiant(String nom_asso)
    {

        Intent intent = new Intent(Authentification.this, SupprimerEtudiant.class);
        intent.putExtra("nomAssoA",nom_asso); //nom de l'association en argument
        startActivity(intent);

    }
}
