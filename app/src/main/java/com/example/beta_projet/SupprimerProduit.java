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

public class SupprimerProduit extends AppCompatActivity {

    Button boutonRetour;
    ArrayList<Produit> listesProduits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_produit);

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
        listesProduits = new ArrayList<Produit>(Arrays.asList(tableauProduitsTemporaire));


        BaseAdapter customBaseAdapter = new BaseAdapter() {
            // Return list view item count.
            @Override
            // a la question "combien d'éléments as-tu ?" on va fournir comme réponse la taille de la listeEtudiants.
            public int getCount() {
                return listesProduits.size();
            }

            @Override
            public Object getItem(int i) {
                // getItem doit renvoyer l'item qui est associé à l'éléméent de liste d'indice i
                // on renvoie simplement le i^eme elemnt de listeEtudiant, car la listview doit etre
                // etre synchronisée avec listeEtudiants
                return listesProduits.get(i);
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
                    itemView = LayoutInflater.from(SupprimerProduit.this).inflate(R.layout.cadre_item_2_liste, null);
                }

                // On récupere les 3 cases (image + zone identite + zone age de ce modele)
                // on va les remplir par la suite avec les valeurs à affcher pour cette ligne
                // ImageView imageView = (ImageView) itemView.findViewById(R.id.baseUserImage);
                TextView txt_nomProduit = (TextView) itemView.findViewById(R.id.txt_nom_prenom);
                TextView txt_peremptionProduit = (TextView) itemView.findViewById(R.id.txt_annee);

                // on alterne la couleur du fond
                int colorPos = itemIndex % 2;
                if (colorPos == 0) {
                    itemView.setBackgroundColor(Color.parseColor("#FFEEEE"));
                } else {
                    itemView.setBackgroundColor(Color.parseColor("#DDBBBB"));
                }

                // on lit les valeur des ressources par rapport à listeetudiants
                Produit produitAafficher = (Produit) listesProduits.get(itemIndex);
                final String nom_Produit = produitAafficher.nomProduit;
                final String prenom = produitAafficher.provenanceProduit;
                final String datePeremption = produitAafficher.datePeremptionProduit;

                // on les insère dans les champs correspondants
                txt_nomProduit.setText(nom_Produit);
                txt_peremptionProduit.setText("Date de peremption : " + datePeremption);

                /** que se passe-t'il si on click sur l'item en entier (itemView)?
                 * on va simplement supprimer cet item de la liste des étudiants
                 * */
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // on récupere l'étudiant cliqué
                        Produit produitSupprime = (Produit) getItem(itemIndex);
                        // on affiche un petit message de type Toast, qui annonce l'étudaint supprimé
                        Toast.makeText(SupprimerProduit.this, "vous avez supprimé " + produitSupprime.nomProduit, Toast.LENGTH_SHORT).show();
                        // on enleve l'étudiant de la liste;
                        listesProduits.remove(produitSupprime);
                        /* important : on annonce a la listview que la liste d'étudiants a partir de laquelle
                        elle avait été construire a changé. ca va permettre de raffraichir l'affichage */
                        notifyDataSetChanged();
                    }
                });
                // on termine la méthode surchargée en renvoyant la view créée
                return itemView;
            }
        };

        // de retour dans la methode onCreate :  on récupere enfin la listView pour affichage
        ListView lv_Produits = (ListView) findViewById(R.id.listView_etudiants);
        // on l'associe au customAdapter. et voila
        lv_Produits.setAdapter(customBaseAdapter);

        /*********************************/
        /*** GESTION DU BOUTON  RETOUR ***/
        /*********************************/
        /** IMPORTANT  :  contriarement aux autres activites : ici quand on quitte l'activite il ne faut pas
         * oublier de sauvegarder la liste listeEtudiants car elle a ete modifiée **/
        // recherche du bouton retour dans le layout
        boutonRetour = findViewById(R.id.bouton_retour);
        // ajout de l'écouteur sur boutonAjouterEtudiant
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
                String ListeProduitsEnJson = gson.toJson(listesProduits);
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
                finish();
            }
        });


    }
}

