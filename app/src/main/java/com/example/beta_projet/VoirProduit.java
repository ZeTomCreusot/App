package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

public class VoirProduit extends AppCompatActivity {

    Button boutonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voir_produit);

        // on récupere la session d'acitivte
        // on recupere ensuite l'indice passé
        Intent in=getIntent();
        Bundle bu=in.getExtras();
        String nomAsso = (String) bu.get("nomAssoP");

        Intent intent = getIntent();  // on récupere la session d'acitivte
        // on recupere ensuite l'indice passé
        int indiceEtudiant = intent.getIntExtra("indexProduit", -1);

        // on récupère les préférences stockées sous la clé mesPrefs :
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson(); // on crée un gestionaire de format json
        // on extrait la liste referencée par le mot clen_listeEtudiants qu'on avait stocké dans les
        // préférences partagées

         String listeProduitTxtJson = null;
            if(nomAsso.equals("BDE"))
            {
                listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDE", "");
            }
            if(nomAsso.equals("BDS"))
            {
                listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDS", "");
            }
        if(nomAsso.equals("BDJ"))
        {
             listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDJ", "");
        }
        if(nomAsso.equals("BDO"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDO", "");
        }
        if(nomAsso.equals("BDA"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDA", "");
        }
        if(nomAsso.equals("1 pour Tous"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_UPT", "");
        }
        if(nomAsso.equals("Tyrans"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_Tyrans", "");
        }
        if(nomAsso.equals("EPF Sud Conseil"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_ESC", "");
        }
        if(nomAsso.equals("Helphi"))
        {
            listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_Helphi", "");
        }


            // desormais dans listeEtudiantsTxtJson on a tous nos etudiants stockés dans un format json
            // on reconstruit un tableau d'objets de type étudiants grace à al liste au format json
            Etudiant[] tableauEtudiantsTemporaire = gson.fromJson(listeProduitTxtJson, Etudiant[].class);
            // on identifie l'étudiant de la liste qui a l'id qu'on devait afficher.
            // on le stocke dans une reference etudiantVisualite
            Etudiant etudiantVisualise = tableauEtudiantsTemporaire[indiceEtudiant];

            /********************************/
        /*** AFFICHAGE DE L'ETUDIANT  ***/
        /********************************/

     /*   // on a désormais l'objet Etudiant à afficher. le reste est facile :
        // on associe chaque référence au widget qui nous permettra d'afficher l'étudiant
        txt_nom_etudiant = findViewById(R.id.txt_nom);
        txt_prenom_etudiant = findViewById(R.id.txt_prenom);
        txt_annee_etudiant = findViewById(R.id.txt_annee);

            // on met enfin à jour le texte des widget avec les valeurs issues de etudiantVisualise
            txt_prenom_etudiant.setText(etudiantVisualise.prenom);
            txt_nom_etudiant.setText(etudiantVisualise.nom);
            txt_annee_etudiant.setText(etudiantVisualise.annee);


        /*********************************/
        /*** GESTION DU BOUTON  RETOUR ***/
        /*********************************/
        // recherche du bouton retour dans le layout
       boutonRetour = findViewById(R.id.bouton_retour);

        // ajout de l'écouteur sur le widget bouton_retour, pour revenir à l'activite précedente
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // on se contente de fermer l'activite. Pas de création d'une activité déja lancée avant
            }
        });
    }
}


