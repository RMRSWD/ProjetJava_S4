package jeuPuissance4.Modele;

import joueur.JoueurGeneral;

import java.util.Random;

public class IAPuissance4 extends JoueurGeneral {
    private Grille ia_grille;
    public IAPuissance4(String nom, int tour) {
        super(nom, tour);
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
        this.ia_grille = grille;//truyen ve thong tin hien tai thong tin cua grille

    }

    @Override
    public String getReponse(String c) {
        return null;
    }



    @Override
    public boolean IA(){
        return true;
    }
}
