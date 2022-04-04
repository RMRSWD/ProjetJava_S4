package Puissance4.controleur;
import controleurJeux.ControleurJeux;
import vue.Ihm;
import controleur.Controleur;
import Puissance4.modele.*;
import Joueur.Joueur;

public class ControleurPuissance4 extends ControleurJeux {
    private Ihm ihm;
    private Grille grille;


    public ControleurPuissance4(Ihm ihm) {
        super(ihm);
        this.ihm=ihm;
        ihm.setControleurJeux(this);//Duc::Je change ici
        ihm.setControleurPuissance4(this);
        grille = new Grille();
    }

    public String afficherGrille() {
        return grille.toString();
    } //DUC: je change ici





    /**
     * permet de renvoyer le joueur courant
     * @return
     */
    /*public Joueur traitementTourJoueur() {

        if (super.getJ1().getTour() == 1) {
            return super.getJ1();
        } else if (super.getJ2().getTour() == 1) {
            return super.getJ2();
        }
        return super.getJ1();
    }*/


    /*public int NbPartiGagnerJoueur1( ) {
        return super.getJ1().getNbPartiesGagnees();
    }
    public int NbPartiGagnerJoueur2() {
        return super.getJ2().getNbPartiesGagnees();
    }*/ //Duc::Je change ici



public char traitementJeton() {
        if (super.getJ1().getTour() == 1) {
            return super.getJ1().getX();
        }
        else if (super.getJ2().getTour()==1) {
                return super.getJ2().getY();
        }

        return super.getJ1().getX();
}

    /**
     * changer le tour des joueurs
     */

    /*public void changerTourJoueur() {
        super.getJ1().tourDeRole();
        super.getJ2().tourDeRole();
    }*/

    /**
     * Methode principale qui permet de faire tourner le jeu
     */

    public  void jouer () {
        ihm.demanderNomJoueur();
        grille.initialiser();
        ihm.afficherGrille();
        Joueur joueur;
        do {
        joueur= super.traitementTourJoueur();
        ihm.demandeCoupPuissance(joueur,this.grille);
        super.changerTourJoueur();
        ihm.afficherGrille();
        } while (!grille.ColonnePlein() && !grille.partieTerminer());
        joueur.gagnePartie();
        ihm.afficherGagnant(joueur);
        ihm.re_jouer();
    }

    /**
     * methode pour rejouer une partie
     */
    public void versionContinuer() {

        grille.initialiser();
        ihm.afficherTas();
        Joueur joueur;
        do {
            joueur = super.traitementTourJoueur();
            ihm.demandeCoupPuissance(joueur,this.grille);
            super.changerTourJoueur();
            ihm.afficherGrille();
        } while(!grille.ColonnePlein() && !grille.partieTerminer());
        joueur.gagnePartie();
        ihm.afficherGagnant(joueur);
        ihm.re_jouer();


    }
}
