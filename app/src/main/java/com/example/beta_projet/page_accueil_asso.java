package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page_accueil_asso extends AppCompatActivity {

    Button boutonAjouteEtudiant;
    Button boutonListeEtudiants;
    Button boutonEnleveEtudiant;
    private Button boutton_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil_asso);
        boutton_retour = (Button) findViewById(R.id.bouton_retour);
        boutton_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visualiser_la_suite();

            }
        });

        //Récupération et affichage du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAsso");
        TextView t_nom=(TextView) findViewById(R.id.texte_nom);
        t_nom.setText(nomAsso);



        boutonAjouteEtudiant = (Button) findViewById(R.id.btn_ajout_element);
        boutonListeEtudiants = (Button) findViewById(R.id.btn_voir_liste);
        boutonEnleveEtudiant = (Button) findViewById(R.id.btn_supprimer_element);

        boutonAjouteEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // ouvrirAjoutEtudiant(nomAsso);
                mot_de_passe();
            }
        });

        boutonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirListeEtudiant(nomAsso);
            }
        });


        boutonEnleveEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ouvrirSupprimerEtudiant(nomAsso);
                mot_de_passe();
            }
        });




    }
    private void visualiser_la_suite()
    {
        Intent intent = new Intent(this, Associations.class);
        startActivity(intent);
    }
    private void ouvrirAjoutEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, AjoutEtudiant.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
    private void ouvrirListeEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, ListeEtudiants.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
    private void ouvrirSupprimerEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, SupprimerEtudiant.class);
        intent.putExtra("nomAsso",nom_asso);
        startActivity(intent);
    }
    private void mot_de_passe()
    {
        Intent intent = new Intent(this, Authentification.class);
        startActivity(intent);
    }
}
