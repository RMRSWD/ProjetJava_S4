package jeuNim.modele;

import jeuPuissance4.Modele.Grille;
import joueur.JoueurGeneral;

import java.util.Objects;

/**
 * Created by kahlem .
 */
public class Joueur extends JoueurGeneral {



    /**
     * @param nom du joueur à créer
     */
    public  Joueur (String nom, int tour) {
        super(nom, tour);


    }


    /**
     * @return the nbPartiesGagnees
     */
    public  void gagnePartie () {
        super.gagnePartie();
    }

    @Override
    public char getY() {
        return 0;
    }

    @Override
    public char getX() {
        return 0;
    }

    @Override
    public void update(Grille grille) {

    }

    @Override
    public String getReponse(String c) {
        return null;
    }



    /**
     * retour le tour à jouer
     * @return
     */




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return super.getNbPartiesgagnees() == joueur.getNbPartiesGagnees() && Objects.equals(getNom(), joueur.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getNbPartiesGagnees());
    }
}

