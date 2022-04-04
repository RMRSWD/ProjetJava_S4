package jeuPuissance4.Modele;

import coup.Coup;

public class CoupPuissance extends Coup {
    private char couleur;
    private int numero;
    public CoupPuissance(int numero, char couleur) {
    this.numero= numero;
       this.couleur=couleur;
    }

    public char getCouleur() {
        return couleur;
    }

    public int getNumeroCol(){
       return numero;
    }
}
