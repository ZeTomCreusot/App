package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class SupprimerEtudiant extends AppCompatActivity {
    // creation des references boutons  que je vais trouver dans le layout
    // déclaration, sans initialisation
    Button boutonRetour;
    ArrayList<Etudiant> listestudiants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* les instructions "classiques" : a la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_etudiant);

        //Affichage et récupération du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoA");
        TextView t_nom=(TextView) findViewById(R.id.textView);
        t_nom.setText(nomAsso);

        /**********************************************/
        /*** RECUPERATION DE LA LISTE DES ETUDIANTS ***/
        /**********************************************/
        /** ici on récupere la liste des étudiants qui est sauvegardée dans un endroit du telephone qui s'appelle
         * sharedpreference. c'est comme une base de données, mais propre au telephone.
         * cette zone est accessible n'importe ou dans les activités de l'application :) Le probleme de
         * cette zone ,c'est qu'on ne peut y enregistrer que des types simples : string, int, float etc
         * or on voudrait stocker une arrayList d'étudiants
         * on a donc comme solution alterrative de transformer notre arraylist en chaine json, puis la stocker
         * et apres on la récupere sous forme de chaine, on la retransforme en tableau fixe, puis en arraylist
         * Ca semble un peu tordu et compliqué, mais finalement ce n'est pas si long et ca marche plutot bien
         *
         * On a ci-dessous la portion de code pour charger une liste existante
         * il y aura ailleurs une autre portion de code pour sauvegarder la liste dans sharedpreference, qu'on
         * utilisera quand on aura modifié la liste
         */
        /** chargement de la liste d'étudiants **/
        // on récupère les préférences stockées sous la clé mesPrefs :
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson(); // on crée un gestionnaire de format json
        // on extrait la liste referencée par le mot cle_listeEtudiants qu'on avait stocké dans les
        // préférences partagées
        String listeEtudiantTxtJson = null;
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
        // reconstitution d'une arrayList a partir du tableau tableauEtudiantsTemporaire
        listestudiants = new ArrayList<Etudiant>(Arrays.asList(tableauEtudiantsTemporaire));

            //Affichage de la liste
        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            // a la question "combien d'éléments as-tu ?" on va fournir comme réponse la taille de la listeEtudiants.
            public int getCount() {
                return listestudiants.size();
            }

            @Override
            public Object getItem(int i) {
               //renvoi du i-ème élément de la liste d'étudiants
                return listestudiants.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(final int itemIndex, View itemView, ViewGroup viewGroup) {
                /** C'est ici que ca devient difficile : on va construire un affichage pour chaque item
                 * on a la fonction getView qui indique comment on doit constuire l'affichage de l'item
                 * numero 'itemIndex', en construisant la vue 'itemView'. Avec l'info du premier paramètre, on va
                 * construire le second. On considere donc ici qu'on ne construit l'affichage que pour 1 item
                 **/
                if (itemView == null) {   // on va creer une case réponse (une ligne du listview ) avec un modele défini dans le fichier
                    // xml main_activity_base_adapter
                    itemView = LayoutInflater.from(SupprimerEtudiant.this).inflate(R.layout.cadre_item_2_liste, null);
                }


                TextView txt_etudiant_nomprenom = (TextView) itemView.findViewById(R.id.txt_nom_prenom);
                TextView txt_etudiant_annee = (TextView) itemView.findViewById(R.id.txt_annee);

             //   Couleur d'arrière-plan'
                 int colorPos = itemIndex % 2;
                if (colorPos == 0) {
                    itemView.setBackgroundColor(Color.parseColor("#FFEEEE"));
                } else {
                    itemView.setBackgroundColor(Color.parseColor("#DDBBBB"));
                }

                Etudiant etudiantAafficher = (Etudiant) listestudiants.get(itemIndex);
                final String nom = etudiantAafficher.nom;
                final String prenom = etudiantAafficher.prenom;
                final String annee = etudiantAafficher.annee;

                //insertion des valeurs dans les champs correspondant
                txt_etudiant_nomprenom.setText(prenom + " " + nom);
                txt_etudiant_annee.setText("Annee : " + annee);


                //Suppression de l'item view si l'écouteur détecte qu'on clique dessus
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Récupération de l'étufdiant sur lequel on a cliqué
                         Etudiant etudiantSupprime = (Etudiant) getItem(itemIndex);
                        //Message prévenant que l'étudiant a bien été supprimé (de type toast)
                        Toast.makeText(SupprimerEtudiant.this, "vous avez supprimé " + etudiantSupprime.prenom + " " + etudiantSupprime.nom, Toast.LENGTH_SHORT).show();
                        // remove = enlever l'étudiant
                        listestudiants.remove(etudiantSupprime);

                        //Rafraîchissement de l'affichage
                        notifyDataSetChanged();
                    }
                });
                // on termine la méthode surchargée en renvoyant la view créée
                return itemView;
            }
        };

        ListView lv_Etudiants = (ListView) findViewById(R.id.listView_etudiants);
        lv_Etudiants.setAdapter(customBaseAdapter);


        //Enregistrement de la liste qui a été modifiée avant de quitter l'activité
        boutonRetour = findViewById(R.id.bouton_retour);
        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /** quand on clique sur le bouton retour :
                 * on se connecte aux preferences stockées sur le teléphone, et on les mets à jour
                 * avec la liste d'étudiants actuelle (dans laquelle on a oté des éléments)  */

                // on récupère les préférences stockées sous la clé mesPrefs
                SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
                // on cree un éditeur de préferences, pour mettre à jour "mesPrefs" :
                SharedPreferences.Editor prefsEditor = prefsStockees.edit();
                Gson gson = new Gson(); // on crée un gestionnaire de format json
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
                finish();
            }
        });


    }
    }
