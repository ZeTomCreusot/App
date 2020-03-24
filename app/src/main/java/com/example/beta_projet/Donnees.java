package com.example.beta_projet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

public class Donnees extends SQLiteOpenHelper {

    private static final String NOM = "base_donnees.db";
    private static final int version = 1;

    public Donnees( Context context){ // Constructeur
    super(context,NOM,null,version); // CTRL + P pour avoir les paramètres

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String creation = "create table Donnees_produit ( " // Définition des colonnes de la table
                        +  " A integer primary key autoincrement, "
                        + " B text not null, " // Il est obligatiore de rentrer du txt
                        + " C integer not null, "
                        + " D integer not null"
                        + ")"; // On ferme la parenthèse pour arrêter le définition des colonnes de la table
        db.execSQL(creation);
        Log.i("BASE_DONNEES", "onCreate invoked" ); // Sert à vérifier que la méthode est invoquéee 1 seule fois
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { //9:35 , déclenche la mise à jour de la base de données
/* Le onUpgrade est un outil de mise à jour de l'app, qui est appelé si oldVersion (version pratique) n'est pas égale à newVersion (version théorique)
        String creation = "alter table Donnees_produit add column ";
        Pour connaître le champ des possibles, taper "sqlite" sur google --> site sqlite --> documentation
        */
        String creation = "drop table Donnees_produit"; // Supprime les données
    db.execSQL(creation);
    this.onCreate( db ); //db est de type SQLiteDatabase |  Recrée le tableau
        Log.i("BASE_DONNEES", "onUpgrade invoked" ); // Sert à vérifier que la méthode est invoquéee 1 seule fois

    }
    public void insertData(String B, int C){
        B = B.replace ("'", "''"); // Les simples côtes sont remplacées par des doubles côtes
        String creation = "insert into Donnees_produit(B,C,D) values ('"
                        + B + " ', " + C  + " , " + new Date().getTime() + " ) ";
        this.getWritableDatabase().execSQL( creation );
        Log.i("BASE_DONNEES", "insertData invoked" );


    }
}
