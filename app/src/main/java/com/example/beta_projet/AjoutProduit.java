package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class AjoutProduit extends AppCompatActivity {

    Button boutonRetour;
    Button boutonAjouter;
    EditText texteProduitSaisi;
    EditText texteProvenanceSaisie;
    EditText textePeremptionSaisie;
    ArrayList<Produit> listeProduits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_produit);
        //Affichage et récupération du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoP");
        TextView t_nom=(TextView) findViewById(R.id.textView4);
        t_nom.setText(nomAsso);

        /*********************************/
        /*** REFERENCES VERS LE CALQUE ***/
        /*********************************/
        // association de nos references avec les objets du layout
        // les boutons permettent d'ajouter ou de revenir en arriere
        boutonAjouter = findViewById(R.id.bouton_ajout);
        // les editText permettent la saisie des informations d'ajout de l'étudiant
        texteProduitSaisi = findViewById(R.id.input_nom);
        texteProvenanceSaisie = findViewById(R.id.input_prenom);
        textePeremptionSaisie = findViewById(R.id.input_Annee);

        /*********************************/
        /*** GESTION DU BOUTON  RETOUR ***/
        /*********************************/
        // recherche du bouton retour dans le layout
        boutonRetour = findViewById(R.id.bouton_retour);
        // ajout de l'écouteur sur le widget bouton_retour, pour revenir à l'activite précedente
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        /*********************************/
        /*** GESTION DU BOUTON AJOUTER ***/
        /*********************************/
        /** quand on clique sur le bouton ajouter, on considere que l'on a toutes les informatioons
         * pour creer un nouvel étudiant. on va charger la liste d'étudiants issus de SharedPreferences
         * puis on va lui ajouter le nouvel etudiant, ensuite on enregistre cette liste dans
         * sharedPreferences. Enfin on quitte l'activité pour revenir au menu principal
         **/
        boutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**************/
                /*Choix de la bonne liste*/
                /**************/


                /** chargement de la liste d'étudiants **/
                // on récupère les préférences stockées sous la clé mesPrefs :
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                Gson gson = new Gson(); // on crée un gestionnaire de format json
                // on extrait la liste referencée par le mot cle_listeEtudiants qu'on avait stocké dans les
                // préférences partagées

                String listeProduitTxtJson=null;
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
                if(nomAsso.equals("BDA"))
                {
                    listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDA", "");
                }
                if(nomAsso.equals("1 pour Tous"))
                {
                    listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_UPT", "");
                }
                if(nomAsso.equals("BDO"))
                {
                    listeProduitTxtJson = prefsStockees.getString("cle_listeProduits_BDO", "");
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

                Produit[] tableauProduitsTemporaire = gson.fromJson(listeProduitTxtJson, Produit[].class);


                if (tableauProduitsTemporaire != null) {
                    // reconstitution d'une arrayList a partir du tableau tableauProduitsTemporaire
                    listeProduits = new ArrayList<Produit>(Arrays.asList(tableauProduitsTemporaire));

                } else {
                    listeProduits = new ArrayList<Produit>();
                }
                /** creation d'un nouvel étudiant **/
                String nomProduit = texteProduitSaisi.getText().toString();
                String provenanceProduit = texteProvenanceSaisie.getText().toString();
                String peremption = textePeremptionSaisie.getText().toString();
                Produit produitAjout = new Produit(nomProduit, provenanceProduit, peremption);

                /** ajout de l'étudiant à l'arrayList contenant les étudiants */
                listeProduits.add(produitAjout);

                /** enregistrement de la liste dans "SharedPreferences" */
                // on cree un éditeur de préferences, pour mettre à jour "mesPrefs" :
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                // on transforme la liste d'étudiant en format json :
                String ListeProduitsEnJson = gson.toJson(listeProduits);

                // on envoie la liste (json) dans la clé cle_listeEtudiants de mesPrefs :

                if(nomAsso.equals("BDE"))
                {
                    prefsEditor.putString("cle_listeProduits_BDE", ListeProduitsEnJson);
                }
                if(nomAsso.equals("BDS"))
                {
                    prefsEditor.putString("cle_listeProduits_BDS", ListeProduitsEnJson);
                }
                if(nomAsso.equals("BDJ"))
                {
                    prefsEditor.putString("cle_listeProduits_BDJ", ListeProduitsEnJson);
                }
                if(nomAsso.equals("BDA"))
                {
                    prefsEditor.putString("cle_listeProduits_BDA", ListeProduitsEnJson);
                }
                if(nomAsso.equals("1 pour Tous"))
                {
                    prefsEditor.putString("cle_listeProduits_UPT", ListeProduitsEnJson);
                }
                if(nomAsso.equals("BDO"))
                {
                    prefsEditor.putString("cle_listeProduits_BDO", ListeProduitsEnJson);
                }
                if(nomAsso.equals("Tyrans"))
                {
                    prefsEditor.putString("cle_listeProduits_Tyrans", ListeProduitsEnJson);
                }
                if(nomAsso.equals("EPF Sud Conseil"))
                {
                    prefsEditor.putString("cle_listeProduits_ESC", ListeProduitsEnJson);
                }
                if(nomAsso.equals("Helphi"))
                {
                    prefsEditor.putString("cle_listeProduits_Helphi", ListeProduitsEnJson);
                }


                prefsEditor.commit(); // on enregistre les préférences

                /** fin de l'activite, mais en renvoyant un message de type Toast */
                Toast.makeText(AjoutProduit.this, "vous avez ajouté ce produit : " +  nomProduit, Toast.LENGTH_SHORT).show();

                retour(nomAsso);
            }



        });

    }
    private void retour(String nom_Asso)
    {
        Intent intent = new Intent(AjoutProduit.this, page_accueil_produit.class);
        intent.putExtra("nomAssoP", nom_Asso);
        startActivity(intent);
    }
}
