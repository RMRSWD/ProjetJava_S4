package jeuPuissance4.Modele;

import joueur.JoueurGeneral;

import java.util.Objects;

public class Joueur extends JoueurGeneral {

    private char x='r';
    private char y= 'j';

    public  Joueur (String nom, int tour) {
       super(nom, tour);

    }


    public char getX() {
        return x;
    }

    public char getY() {
        return y;
    }

    public  void gagnePartie () {
        super.gagnePartie();
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return super.getNbPartiesGagnees() == super.getNbPartiesGagnees() && super.getTour() == joueur.getTour() && Objects.equals(super.getNom(), joueur.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getNom(), super.getNbPartiesGagnees(), super.getTour());
    }


}
