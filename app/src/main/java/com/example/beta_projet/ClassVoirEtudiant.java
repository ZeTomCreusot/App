package com.example.beta_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

public class ClassVoirEtudiant extends AppCompatActivity {

    Button bouton_Retour;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_voir_etudiant);
        
        bouton_Retour= findViewById(R.id.boutonRetour);
        

        // ajout de l'écouteur sur le widget bouton_retour, pour revenir à l'activite précedente
        bouton_Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // on se contente de fermer l'activite. Pas de création d'une activité déja lancée avant
            }
        });


        Intent intent=getIntent();
        Bundle bu=intent.getExtras();
        String nom_Asso = (String) bu.get("nomAssoAs");

        Intent intent1 = getIntent();  // on récupere la session d'acitivte
        // on recupere ensuite l'indice passé
        int indice_Etudiant = intent1.getIntExtra("indexEtudiant", -1);

        SharedPreferences prefsStockees = getSharedPreferences("mesPrefs", MODE_PRIVATE);
        Gson gson = new Gson(); // on crée un gestionaire de format json
        // on extrait la liste referencée par le mot clen_listeEtudiants qu'on avait stocké dans les
        // préférences partagées

        String listeEtudiantTxtJson = null;
        if(nom_Asso.equals("BDE"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsBDE", "");
        }
        if(nom_Asso.equals("BDS"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsBDS", "");
        }
        if(nom_Asso.equals("BDJ"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsBDJ", "");
        }
        if(nom_Asso.equals("BDO"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsBDO", "");
        }
        if(nom_Asso.equals("BDA"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsBDA", "");
        }
        if(nom_Asso.equals("1 pour Tous"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsUPT", "");
        }
        if(nom_Asso.equals("Tyrans"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsTyrans", "");
        }
        if(nom_Asso.equals("EPF Sud Conseil"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsESC", "");
        }
        if(nom_Asso.equals("Helphi"))
        {
            listeEtudiantTxtJson = prefsStockees.getString("cle_listeEtudiantsHelphi", "");
        }

        Etudiant[] tableauEtudiantsTemporaire = gson.fromJson(listeEtudiantTxtJson, Etudiant[].class);
        // on identifie l'étudiant de la liste qui a l'id qu'on devait afficher.
        // on le stocke dans une reference etudiantVisualite
        Etudiant etudiantVisualise = tableauEtudiantsTemporaire[indice_Etudiant];

        TextView prenom_Etudiant=(TextView) findViewById(R.id.prenomEtudiant);
        TextView nom_Etudiant= (TextView)findViewById(R.id.nomEtudiant);
        TextView annee_Etudiant=(TextView)findViewById(R.id.anneeEtudiant);

        prenom_Etudiant.setText(etudiantVisualise.prenom);
        nom_Etudiant.setText(etudiantVisualise.nom);
        annee_Etudiant.setText(etudiantVisualise.annee);

    }
}
