package controleur;
import modele.*;
import vue.Ihm;

public class Controleur {
    private Ihm ihm;
    private Grille grille;
    private Joueur j1;
    private Joueur j2;

    public Controleur(Ihm ihm) {
        this.ihm = ihm;
        ihm.setControleur(this);
        grille = new Grille();
    }

    public String grilleInitial() {
        return grille.toString();
    }
    public void nom_joueur(String nomJ1, String nomJ2) {
        String nomJoueur1 = nomJ1;
        String nomJoueur2 = nomJ2;
        this.j1 = new Joueur(nomJoueur1, 1);
        this.j2 = new Joueur(nomJoueur2, 0);
    }
    /**
     * permet de renvoyer le joueur courant
     * @return
     */
    public Joueur traitementTourJoueur() {

        if (this.j1.getTour() == 1) {
            return this.j1;
        } else if (this.j2.getTour() == 1) {
            return this.j2;
        }
        return this.j1;
    }

    public Ihm getIhm() {
        return ihm;
    }



    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public int NbPartiGagnerJoueur1( ) {
        return j1.getNbPartiesGagnees();
    }
    public int NbPartiGagnerJoueur2() {
        return j2.getNbPartiesGagnees();
    }



public char traitementJeton() {
        if (this.j1.getTour() == 1) {
            return j1.getX();
        }
        else if (this.j2.getTour()==1) {
                return j2.getY();
        }

        return this.j1.getX();
}

    /**
     * changer le tour des joueurs
     */

    public void changerTourJoueur() {
        j1.tourDeRole();
        j2.tourDeRole();
    }

    /**
     * Methode principale qui permet de faire tourner le jeu
     */
    public  void jouer () {
        ihm.demanderNomJoueur();
        grille.initialiser();
        ihm.afficherGrille();
        Joueur joueur;
        do {
        joueur= traitementTourJoueur();
        ihm.demandeCoup(joueur,this.grille);
        changerTourJoueur();
        ihm.afficherGrille();
        } while (!grille.ColonnePlein() && !grille.partieTerminer());
        joueur.gagnePartie();
        joueur.gagnePartie();ihm.afficherGagnant(joueur);
        ihm.re_jouer();
    }

    /**
     * methode pour rejouer une partie
     */
    public void versionContinuer() {

        grille.initialiser();
        ihm.afficherGrille();
        Joueur joueur;
        do {
            joueur = traitementTourJoueur();
            ihm.demandeCoup(joueur,this.grille);
            changerTourJoueur();
            ihm.afficherGrille();
        } while(!grille.ColonnePlein() && !grille.partieTerminer());
        joueur.gagnePartie();
        ihm.afficherGagnant(joueur);
        ihm.re_jouer();


    }
}
