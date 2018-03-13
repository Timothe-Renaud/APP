package com.example.adminlocal.productivit.modele;

/**
 * Created by kakas on 13/03/2018.
 */

public class Tache {

    //proprietes
//    Integer numero;
    String message = null;

    public Tache( String message){

   //     this.numero = numero;
        this.message = message;
    }

 // public Integer getNumero(){ return numero;}

public String getMessage(){ return message;}
}
