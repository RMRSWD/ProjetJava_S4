package modele;

import java.util.Objects;

/**
 * Created by kahlem .
 */
public class Joueur {
    private String nom;
    private int nbPartiesGagnees;
    private int tour;

    /**
     * @param nom du joueur à créer
     */
    public Joueur(String nom, int tour) {
        this.nom = nom;
        this.tour = tour;
        nbPartiesGagnees = 0;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the nbPartiesGagnees
     */
    public int getNbPartiesGagnees() {
        return nbPartiesGagnees;
    }

    /**
     * incrémente le nombre de parties gagnées par le joueur
     */
    public void gagnePartie() {
        nbPartiesGagnees++;
    }

    /**
     * retour le tour à jouer
     * @return
     */

    public int getTour() {
        return this.tour;
    }

    /**
     * Permet de changer le tour du joueur
     */
    public void tourDeRole() {
        if (tour == 1) {
            tour = 0;
        } else if (tour == 0) {
            tour = 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return nbPartiesGagnees == joueur.nbPartiesGagnees && Objects.equals(nom, joueur.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, nbPartiesGagnees);
    }
}

