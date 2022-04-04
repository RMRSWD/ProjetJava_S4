package modele;

public class CoupPuissance {

    private int numeroCol;
    private char couleur;

    /**
     * Constructeur permettant de creer un coup
     * @param numeroCol numero de la colonne
     * @param couleur jeton gerer automaitquement
     */

    public CoupPuissance(int numeroCol, char couleur) {
        this.numeroCol = numeroCol;
        this.couleur = couleur;
    }


    /**
     * @return the ligne
     */
    public int getNumeroCol() {
        return numeroCol;
    }

    /**
     * @return the nbAllumettes
     */
    public char getCouleur() {
        return couleur;
    }

}
