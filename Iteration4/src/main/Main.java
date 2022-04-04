package main;
import jeuNim.controleurJeuNim.*;
import interfaceStrategy.StrategieJeu;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.Tas;
import jeuPuissance4.Controleur.*;
import jeuPuissance4.Modele.Grille;
import vue.*;


public class Main {

    public static void main(String[] args) throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        Grille grille = new Grille();
        Ihm ihm = new Ihm();
        int jeu = ihm.choixJeu();
        int jeux = ihm.inputVersion();
        System.out.println();
        StrategieJeu strategieJeu;
       /* if(jeu == 1) {
            *//*strategieJeu = new ControleurJeuNim(ihm);*//*
            strategieJeu = new ControleurJeuNim(ihm);
            strategieJeu.jouer();
        }else {
            strategieJeu = new ControleurJeuPuissance(ihm);
            strategieJeu.jouer();
        }*/
        if(jeu == 1) {
            strategieJeu = new ControleurJeuNim(ihm);
            if (jeux==1){
            strategieJeu.jouer();}

        }else {
            strategieJeu = new ControleurJeuPuissance(ihm);
            strategieJeu.jouer();
        }
    }
}
