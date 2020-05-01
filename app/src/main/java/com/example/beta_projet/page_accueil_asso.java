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
    private Button bouton_retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_accueil_asso);

        bouton_retour = (Button) findViewById(R.id.bouton_retour);
        bouton_retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retour_page_asso();

            }
        });

        //Récupération et affichage du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoA");
        TextView t_nom=(TextView) findViewById(R.id.texte_nom);
        t_nom.setText(nomAsso);


        //Association des boutosn aux élements du xml
        boutonAjouteEtudiant = (Button) findViewById(R.id.btn_ajout_element);
        boutonListeEtudiants = (Button) findViewById(R.id.btn_voir_liste);
        boutonEnleveEtudiant = (Button) findViewById(R.id.btn_supprimer_element);

        //Si l'utilisateur clique sur le bouton pour ajouter un étudiant, il est redigiré vers une page d'authentification avant de pouvoir ajouter un membre
        boutonAjouteEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ouvrirAjoutEtudiant(nomAsso); //méthode de démarrage de l'activité authentification

            }
        });

        //Si l'utilisateur clique sur le bouton pour voir la liste il est redirigé vers l'activité d'affichage de la liste des étudiants
        boutonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirListeEtudiant(nomAsso); // méthode de démarrage de l'activité listeEtudiant
            }
        });


        boutonEnleveEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirSupprimerEtudiant(nomAsso); //méthode de démarrage de l'activité authentification1
            }
        });

    }
    private void retour_page_asso()
    {
        Intent intent = new Intent(this, Associations.class);
        startActivity(intent);
    }
    private void ouvrirAjoutEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, Authentification1.class);
        intent.putExtra("nomAssoA",nom_asso); //on passe le nom de l'asssociation en argument
        startActivity(intent);
    }
    private void ouvrirListeEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, ListeEtudiants.class);
        intent.putExtra("nomAssoA",nom_asso); //on passe le nom de l'asssociation en argument
        startActivity(intent);
    }
    private void ouvrirSupprimerEtudiant(String nom_asso)
    {
        Intent intent = new Intent(page_accueil_asso.this, Authentification.class);
        intent.putExtra("nomAssoA",nom_asso); //on passe le nom de l'asssociation en argument
        startActivity(intent);
    }

}
