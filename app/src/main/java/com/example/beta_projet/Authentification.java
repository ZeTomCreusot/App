package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Authentification extends AppCompatActivity {

    private Button btn;
    EditText mdp;
   // private String motdepasse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        btn = (Button)findViewById(R.id.test);
        mdp=findViewById(R.id.Password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String motdepasse = mdp.getText().toString();
                if (motdepasse.equals("aaa")){
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
