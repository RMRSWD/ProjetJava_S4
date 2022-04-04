/*
package jouer;

import controleur.Controleur;

public class Jouer extends  {
    public static void jouer(){

//pas utiliser!!!!

    }
}
*/
package controleurJeux;

import Joueur.Joueur;
import controleur.Controleur;
import vue.Ihm;
import Nim.modele.Tas;

/*public abstract class ControleurJeux extends Controleur {*/
public class ControleurJeux implements Controleur {
    private Joueur j1;
    private Joueur j2;
    /*private Tas lesTas;*/

public ControleurJeux(Ihm ihm) {
        /*super(ihm);*/
    }

    @Override

    public int NbPartiGagnerJoueur1( ) {
        return getJ1().getNbPartiesGagnees();
    }

    @Override
    public int NbPartiGagnerJoueur2() {
        return getJ2().getNbPartiesGagnees();
    }

    @Override
    public void jouer() {

    }

    @Override
    public void versionContinuer() {

    }

    /*@Override*/
   /* public void jouer() {

    }*/

   /* @Override
    public void versionContinuer() {

    }*/


/*    public String BarreInitiale() {
        return lesTas.toString();
    }*/
    /*@Override*/
   /* public void jouer() {

    }*/

    /*public  void jouer();*/

   /* @Override
    public void versionContinuer() {

    }*/

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void nom_joueur(String nomJ1, String nomJ2) {
        String nomJoueur1 = nomJ1;
        String nomJoueur2 = nomJ2;
        this.j1 = new Joueur(nomJoueur1, 1);
        this.j2 = new Joueur(nomJoueur2, 0);
    }
@Override
    public void changerTourJoueur(){//DUC::Je change ici
        this.j1.tourDeRole();
        this.j2.tourDeRole();

    }
@Override
    public Joueur traitementTourJoueur() {
        if (getJ1().getTour() == 1) {
            return getJ1();
        } else if (getJ2().getTour() == 1) {
            return getJ2();
        }
        return getJ1();
    }


    



}
