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

public class ListeEtudiants extends AppCompatActivity {
    Button boutonRetour;
    ArrayList<Etudiant> listestudiants;
    public Button test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
                /* les instructions "classiques" : a la création d'une activité, on appelle le constructeur
        parent et on charge le calque associé */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiants);


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
        /*chargement de la liste d'étudiants **/
        // on récupère les préférences stockées sous la clé mesPrefs :
        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson(); // on crée un gestionnaire de format json
        // on extrait la liste referencée par le mot cle_listeEtudiants qu'on avait stocké dans les
        // préférences partagées
        String listeEtudiantTxtJson=null;

        if (nomAsso.equals("BDE")) {
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

        // Reconstruction d'un tableau d'objets étudiant jusqu'ici stockés sous format json
        Etudiant[] tableauEtudiantsTemporaire = gson.fromJson(listeEtudiantTxtJson, Etudiant[].class);
        //Reconstruction d'une Arraylist
        listestudiants = new ArrayList<Etudiant>(Arrays.asList(tableauEtudiantsTemporaire));

        //Affichage de la liste d'étudiants


        BaseAdapter customBaseAdapter = new BaseAdapter() {
            @Override
            // a la question "combien d'éléments as-tu ?" on va fournir comme réponse la taille de la listeEtudiants.
            public int getCount() {
                return listestudiants.size();
            }


            @Override
            public Object getItem(int i) {

                //renvoi du i-ème élément de la liste d'etudiants
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
                    itemView = LayoutInflater.from(ListeEtudiants.this).inflate(R.layout.cadre_item_2_liste, null);
                }

                // On récupere les 3 cases (image + zone identite + zone age de ce modele)
                // on va les remplir par la suite avec les valeurs à affcher pour cette ligne
                // ImageView imageView = (ImageView) itemView.findViewById(R.id.baseUserImage);
                TextView txt_etudiant_nomprenom  = (TextView) itemView.findViewById(R.id.txt_nom_prenom);
                TextView txt_etudiant_annee  = (TextView) itemView.findViewById(R.id.txt_annee);

                // on alterne la couleur du fond
                int colorPos = itemIndex % 2;
                if (colorPos == 0) {
                    itemView.setBackgroundColor(Color.parseColor("#FFEEEE"));
                } else {
                    itemView.setBackgroundColor(Color.parseColor("#DDBBBB"));
                }

                // on lit les valeur des ressources par rapport à listeetudiants
                Etudiant etudiantAafficher = (Etudiant) listestudiants.get(itemIndex);
                //imageView.setImageResource(R.mipmap.ic_launcher);
                final String nom = etudiantAafficher.nom;
                final String prenom = etudiantAafficher.prenom;
                final String annee = etudiantAafficher.annee;

                // on les insère dans les champs correspondants
                txt_etudiant_nomprenom.setText(prenom + " " + nom);
                txt_etudiant_annee.setText("Annee : "+ annee);

                /** que se passe-t'il si on click sur l'item en entier (itemView)?
                 * on va simplement lancer l'activité Voiretudiant en lui passant un parametre :
                 * l'index de l'étudiant cliqué
                 * */
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // on affiche un petit message de type Toast, qui arrivera aussi sur l'autre activite
                        Toast.makeText(ListeEtudiants.this, "vous avez cliqué sur " + prenom + " " + nom, Toast.LENGTH_SHORT).show();
                        // on crée la nouvelle activite
                        Intent intent = new Intent(ListeEtudiants.this, VoirEtudiant.class);
                        // on lui passe un parametre : indexEtudiantClique, qui sera l'index de l'item cliqué
                        intent.putExtra("indexEtudiant", itemIndex);
                        intent.putExtra("nomAssoAs",nomAsso);
                        startActivity(intent); // lancement de l'activité
                    }
                });
                // on termine la méthode surchargée en renvoyant la view créée
                return itemView;
            }
        };

        // de retour dans la methode onCreate :  on récupere enfin la listView pour affichage
        ListView lv_Etudiants  = (ListView)findViewById(R.id.listView_etudiants);
        // on l'associe au customAdapter. et voila
        lv_Etudiants.setAdapter(customBaseAdapter);

        /*test = (Button) findViewById(R.id.button);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeEtudiants.this, ClassVoirEtudiant.class);
                startActivity(intent);

            }
        });*/

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
