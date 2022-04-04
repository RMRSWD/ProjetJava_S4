package jeuPuissance4.Modele;

import coup.Coup;
import plateau.Plateau;

import java.util.Arrays;

public class Grille extends Plateau {
    private static int Colonne = 7;
    private static int Ligne = 7;
    private int N = 4;
    private char[][] grille;
    private int[] posLibre = new int[]{7,7,7,7,7,7,7};

    public Grille() {

        this.grille = new char[Colonne][Ligne];

    }

    public int getColonne() {
        return Colonne;
    }

    public int getLigne() {
        return Ligne;
    }

    public int getN() {
        return N;
    }



public   boolean verifierColonne () {
        return (grille[Colonne - 1][Ligne-1] == 'j') || (grille[Colonne - 1][Ligne-1] == 'r');
}





    public char[][] getGrille() {
        return grille;
    }

    public void initialiser() {
        for (int i = 0; i < Ligne; i++) {
            for (int j = 0; j < Colonne; j++) {
                grille[i][j] = '|';
            }
        }
    }
    public boolean partieTerminer() {
        return alignement()==true;
    }

    /**
     * permet de tester s'il y'a  des alignement
     * @return
     */

    public boolean alignement() {

        //permet de verifier les horizontales
        for (int ligne = 0; ligne < 8; ligne++) {
            if (cherche4alignes(0, ligne, 1, 0)) {
                return true;
            }
        }

        // permet de verifier la vertical
        for (int col = 0; col < 8; col++) {
            if (cherche4alignes(col, 0, 0, 1)) {
                return true;
            }
        }


        for (int col = 0; col < 8; col++) {
            /**
             * Diagonales (cherche depuis la ligne du bas)
             *  Première diagonale
             *
             *   |              *
             *   |           *
             *   |       *
             *   |     *
             y |  *
             *   x__________/**
             *
             * */
            if (cherche4alignes(col, 0, 1, 1)) {
                return true;
            }



            /**
             * Deuxième diagonale
             *
             *                                                              *               | y
             *                                                                 *            |
             *                                                                    *         |
             *                                                                       *      |
             *                                                                          *   |
             *                                                                     __________x
             */


            if (cherche4alignes(col, 0, -1, 1)) {
                return true;
            }
        }


        // Diagonales (cherche depuis les colonnes gauches et droites)
        for (int ligne = 0; ligne < 8; ligne++) {
            //  ( / )

            /**
             *
             *
             * permet de verifier pour la Première diagonale c'est à dire
             *                           x __________
             *                                    * |
             *                                 *    |
             *                               *      |
             *                            *         |
             *                                      | y
             */


            if (cherche4alignes(0, ligne, 1, 1)) {
                return true;
            }
            /**
             * permet de verifier pour la  Deuxième diagonale c'est à dire  |__________x
             | *
             |   *
             |     *
             |       *
             y |         *
             */
            if (cherche4alignes(8 - 1, ligne, -1, 1)) {
                return true;
            }
        }

        // On n'a rien trouvé
        return false;


    }


    private boolean cherche4alignes(int origineCol, int oLigne, int dCol, int dLigne) {
        char jeton='|' ;
        int compteur = 0;

        int Col = origineCol;
        int lig = oLigne;

        while ((Col >= 0) && (Col <7) && (lig >= 0) && (lig <7)) {
            if (grille[lig][Col] != jeton) {
                // Si la jeton change, on réinitialise le compteur
                jeton = grille[lig][Col];
                compteur = 1;
            } else {
                // Sinon on l'incrémente
                compteur++;
            }

            // On sort lorsque le compteur atteint 4
            if ((jeton != '|') && (compteur == 4)) {
                return true;
            }

            // On passe à l'itération suivante
            Col += dCol;
            lig += dLigne;
        }

        // Aucun alignement n'a été trouvé
        return false;
    }

    /**
     * teste si la colonne est pleine
     * @return
     */
    public boolean ColonnePlein() {
        return Arrays.equals(posLibre, new int[]{0, 0, 0, 0, 0, 0, 0});
    }



    public String toString() {
        String s = "";
        for (int i = 0; i < Ligne; i++) {
            for (int j = 0; j < Colonne; j++) {
                s+= grille[i][j] + " ";
            }
            s+= "\n";
        }
        return s;
    }



    public void gererCoup(Coup coup) throws CoupInvalideException {
        int numeroCol = ((CoupPuissance) coup).getNumeroCol();
        char couleur = ((CoupPuissance) coup).getCouleur();

        if (numeroCol >= 1 && numeroCol <= 7 && posLibre[numeroCol-1]>0 ) {
            grille[posLibre[numeroCol-1]-1][numeroCol - 1] = couleur ;
            posLibre[numeroCol-1]--;

        } else {
            throw new CoupInvalideException("Le coup est invalide");
        }

    }

}