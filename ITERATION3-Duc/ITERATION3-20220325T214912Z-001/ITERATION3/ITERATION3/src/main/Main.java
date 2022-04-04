package main;
import Nim.controleur.ControleurJeuNim;
import Puissance4.controleur.ControleurPuissance4;
/*import jouer.jouer;*/
import controleurJeux.ControleurJeux;
import vue.*;
import controleur.Controleur;

public class Main {

    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        int jeu = ihm.choixJeu();
        System.out.println();
        ControleurJeux controleur;
        if (jeu == 1) {
            controleur = new ControleurJeuNim(ihm);
            controleur.jouer();
        }
            else{
                controleur = new ControleurPuissance4(ihm);
                controleur.jouer();
            }
        }
    }

