package main;
import jeuNim.controleurJeuNim.*;
import interfaceStrategy.StrategieJeu;
import jeuNim.modele.CoupInvalideException;
import jeuPuissance4.Controleur.*;
import vue.*;


public class Main {

    public static void main(String[] args) throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        Ihm ihm = new Ihm();
        int jeu = ihm.choixJeu();
        System.out.println();
        StrategieJeu strategieJeu;
        if(jeu == 1) {
            strategieJeu = new ControleurJeuNim(ihm);
            strategieJeu.jouer();
        }else {
            strategieJeu = new ControleurJeuPuissance(ihm);
            strategieJeu.jouer();
        }
    }
}
