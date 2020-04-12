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

public class AjoutEtudiant extends AppCompatActivity {
    Button boutonRetour;
    Button boutonAjouter;
    EditText texteNomSaisi;
    EditText textePrenomSaisi;
    EditText texteAnneeSaisie;
    ArrayList<Etudiant> listestudiants;


        // creation des references boutons et EditText que je vais trouver dans le layout
        // déclaration, sans initialisation
        // listeEtudiants est l'arrayList dans laquelle on charge les objets étudiants de notre appli
        // la reference est déclarée ici, mais sera initialisée plus tard


        @Override
        protected void onCreate (Bundle savedInstanceState){
        /* les instructions "classiques" : a la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ajout_etudiant);

            //Affichage et récupération du choix du spinner
            Intent in=getIntent();
            Bundle b=in.getExtras();
            final String nomAsso = (String) b.get("nomAssoA");
            TextView t_nom=(TextView) findViewById(R.id.textView4);
            t_nom.setText(nomAsso);

            /*********************************/
            /*** REFERENCES VERS LE CALQUE ***/
            /*********************************/
            // association de nos references avec les objets du layout
            // les boutons permettent d'ajouter ou de revenir en arriere
            boutonAjouter = findViewById(R.id.bouton_ajout);
            // les editText permettent la saisie des informations d'ajout de l'étudiant
            texteNomSaisi = findViewById(R.id.input_nom);
            textePrenomSaisi = findViewById(R.id.input_prenom);
            texteAnneeSaisie = findViewById(R.id.input_Annee);

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

                    String listeEtudiantTxtJson=null;
                    if(nomAsso.equals("BDE"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_BDE", "");
                    }
                    if(nomAsso.equals("BDS"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_BDS", "");
                    }
                    if(nomAsso.equals("BDJ"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_BDJ", "");
                    }
                    if(nomAsso.equals("BDA"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_BDA", "");
                    }
                    if(nomAsso.equals("1 pour Tous"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_UPT", "");
                    }
                    if(nomAsso.equals("BDO"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_BDO", "");
                    }
                    if(nomAsso.equals("Tyrans"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_Tyrans", "");
                    }
                    if(nomAsso.equals("EPF Sud Conseil"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_ESC", "");
                    }
                    if(nomAsso.equals("Helphi"))
                    {
                        listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiants_Helphi", "");
                    }

                    Etudiant[] tableauEtudiantsTemporaire = gson.fromJson(listeEtudiantTxtJson, Etudiant[].class);


                    if (tableauEtudiantsTemporaire != null) {
                        // reconstitution d'une arrayList a partir du tableau tableauEtudiantsTemporaire
                        listestudiants = new ArrayList<Etudiant>(Arrays.asList(tableauEtudiantsTemporaire));

                    } else {
                        listestudiants = new ArrayList<Etudiant>();
                    }
                    /** creation d'un nouvel étudiant **/
                    String nom = texteNomSaisi.getText().toString();
                    String prenom = textePrenomSaisi.getText().toString();
                    String annee = texteAnneeSaisie.getText().toString();
                    Etudiant etudiantAjout = new Etudiant(nom, prenom, annee);

                    /** ajout de l'étudiant à l'arrayList contenant les étudiants */
                    listestudiants.add(etudiantAjout);

                    /** enregistrement de la liste dans "SharedPreferences" */
                    // on cree un éditeur de préferences, pour mettre à jour "mesPrefs" :
                    SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                    // on transforme la liste d'étudiant en format json :
                    String ListeEtudiantsEnJson = gson.toJson(listestudiants);

                    // on envoie la liste (json) dans la clé cle_listeEtudiants de mesPrefs :

                    if(nomAsso.equals("BDE"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_BDE", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("BDS"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_BDS", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("BDJ"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_BDJ", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("BDA"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_BDA", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("1 pour Tous"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_UPT", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("BDO"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_BDO", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("Tyrans"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_Tyrans", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("EPF Sud Conseil"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_ESC", ListeEtudiantsEnJson);
                    }
                    if(nomAsso.equals("Helphi"))
                    {
                        prefsEditor.putString("cle_listeEtudiants_Helphi", ListeEtudiantsEnJson);
                    }


                    prefsEditor.commit(); // on enregistre les préférences

                    /** fin de l'activite, mais en renvoyant un message de type Toast */
                    Toast.makeText(AjoutEtudiant.this, "vous avez ajouté " + prenom + " " + nom, Toast.LENGTH_SHORT).show();
                    finish(); // on ferme l'activite et on revient à l'activite precedente
                }



            });

        }
    }
