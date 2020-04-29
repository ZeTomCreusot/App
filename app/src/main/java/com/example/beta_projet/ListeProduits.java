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

public class ListeProduits extends AppCompatActivity {

    Button boutonRetour;
    ArrayList<Produit> listeProduits;
    public int itemIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

        //Affichage et récupération du choix du spinner
        Intent in=getIntent();
        Bundle b=in.getExtras();
        final String nomAsso = (String) b.get("nomAssoP");
        TextView t_nom=(TextView) findViewById(R.id.textView);
        t_nom.setText(nomAsso);


        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson(); // on crée un gestionnaire de format json
        // on extrait la liste referencée par le mot cle_listeEtudiants qu'on avait stocké dans les
        // préférences partagées
        String listeProduitTxtJson=null;

        if (nomAsso.equals("BDE"))
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



        // desormais dans listeEtudiantsTxtJson on a tous nos etudiants stockés dans un format json
        // on reconstruit un tableau d'objets de type étudiants grace à al liste au format json
        Produit[] tableauProduitsTemporaire = gson.fromJson(listeProduitTxtJson, Produit[].class);
        // reconstitution d'une arrayList a partir du tableau tableauProduitsTemporaire
        listeProduits = new ArrayList<Produit>(Arrays.asList(tableauProduitsTemporaire));
        //  listestudiants_2 = new ArrayList<Etudiant>(Arrays.asList(tableauProduitsTemporaire));


        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            // a la question "combien d'éléments as-tu ?" on va fournir comme réponse la taille de la listeEtudiants.
            public int getCount() {
                return listeProduits.size();
            }


            @Override
            public Object getItem(int i) {
                // getItem doit renvoyer l'item qui est associé à l'éléméent de liste d'indice i
                // on renvoie simplement le i^eme elemnt de listeEtudiant, car la listview doit etre
                // etre synchronisée avec listeEtudiants
                return listeProduits.get(i);
            }

            @Override
            public long getItemId(int i) {
                itemIndex=i;
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
                    itemView = LayoutInflater.from(ListeProduits.this).inflate(R.layout.cadre_item_2_liste, null);
                }

                // On récupere les 3 cases (image + zone identite + zone age de ce modele)
                // on va les remplir par la suite avec les valeurs à affcher pour cette ligne
                // ImageView imageView = (ImageView) itemView.findViewById(R.id.baseUserImage);
                TextView txt_produit_nomProduit  = (TextView) itemView.findViewById(R.id.txt_nom_prenom);
                TextView txt_produit_peremption  = (TextView) itemView.findViewById(R.id.txt_annee);

                // on alterne la couleur du fond
                int colorPos = itemIndex % 2;
                if (colorPos == 0) {
                    itemView.setBackgroundColor(Color.parseColor("#FFEEEE"));
                } else {
                    itemView.setBackgroundColor(Color.parseColor("#DDBBBB"));
                }

                // on lit les valeur des ressources par rapport à listeetudiants
                Produit produitAafficher = (Produit) listeProduits.get(itemIndex);
                //imageView.setImageResource(R.mipmap.ic_launcher);
                final String nom = produitAafficher.nomProduit;
                final String provenance = produitAafficher.provenanceProduit;
                final String datePeremption = produitAafficher.datePeremptionProduit;

                // on les insère dans les champs correspondants
                txt_produit_nomProduit.setText( nom);
                txt_produit_peremption.setText("Date de peremption: "+ datePeremption);

                /** que se passe-t'il si on click sur l'item en entier (itemView)?
                 * on va simplement lancer l'activité Voiretudiant en lui passant un parametre :
                 * l'index de l'étudiant cliqué
                 * */
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // on affiche un petit message de type Toast, qui arrivera aussi sur l'autre activite
                        Toast.makeText(ListeProduits.this, "vous avez cliqué sur "  + nom, Toast.LENGTH_SHORT).show();
                        // on crée la nouvelle activite
                        Intent intent = new Intent(ListeProduits.this, VoirProduit.class);
                        // on lui passe un parametre : indexEtudiantClique, qui sera l'index de l'item cliqué
                        intent.putExtra("indexProduit", itemIndex);

                        intent.putExtra("nomAssoP",nomAsso);
                        startActivity(intent); // lancement de l'activité
                    }
                });
                // on termine la méthode surchargée en renvoyant la view créée
                return itemView;
            }
        };

        // de retour dans la methode onCreate :  on récupere enfin la listView pour affichage
        ListView lv_Produits  = (ListView)findViewById(R.id.listView_etudiants);
        // on l'associe au customAdapter. et voila
        lv_Produits.setAdapter(customBaseAdapter);

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
