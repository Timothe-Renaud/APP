package com.example.adminlocal.productivit.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.adminlocal.productivit.outils.MySQLiteOpenHelper;

import java.util.Date;

/**
 * Created by kakas on 13/03/2018.
 *
 */

public class AccesLocal {

    // propriétés
    private String nomBase = "bdCoach.sqlite";
    private Integer versionBase = 1;
    private MySQLiteOpenHelper accesBD;
    private SQLiteDatabase bd;

    public AccesLocal(Context contexte){
        accesBD = new MySQLiteOpenHelper(contexte,nomBase,null,versionBase);
    }

    /**
     * ajout d'une tache dans la BD
     * @param tache
     */
    public void ajout(Tache tache) {
        bd = accesBD.getWritableDatabase();
        String req = "insert into tache (message) values";
        req += "("+tache.getMessage()+")";
        bd.execSQL(req);
    }

    /**
     * Récupératio des taches de la BD
     * @return tache
     */
    public Tache recupTache(){
        bd = accesBD.getReadableDatabase();
        Tache tache = null;
        String req = "select * from profil";
        Cursor curseur = bd.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
 //           Integer numero = curseur.getInt(0);
            String message = curseur.getString(1);
            tache = new Tache(message);
        }
        curseur.close();
        return tache;
    }

}
