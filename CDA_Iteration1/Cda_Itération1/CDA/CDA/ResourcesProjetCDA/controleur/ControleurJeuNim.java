package controleur;

import modele.CoupInvalideException;
import modele.CoupNim;
import modele.Joueur;
import modele.Tas;
import vue.Ihm;


public class ControleurJeuNim {
    private Ihm ihm;
    private Tas lesTas;
    private Joueur j1;
    private Joueur j2;


    public ControleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
        ihm.setControleurJeuNim(this);

    }

    /**
     * Creer les objets joueurs
     * @param nomJ1
     * @param nomJ2
     */
    public void nom_joueur(String nomJ1, String nomJ2) {
        String nomJoueur1 = nomJ1;
        String nomJoueur2 = nomJ2;
        this.j1 = new Joueur(nomJoueur1, 1);
        this.j2 = new Joueur(nomJoueur2, 0);
    }



    /**
     * return les allumettes qui sera afficher dans l'Ihm
     * @return
     */

    public String TasInitial() {
        return lesTas.toString();
    }

    /**
     * Creer l'objet tas
     * @param a
     */
    public void gerer_nbTas(int a) {
        this.lesTas = new Tas(a);
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

public int NbPartiGagnerJoueur1( ) {
        return j1.getNbPartiesGagnees();
}
public int NbPartiGagnerJoueur2() {
        return j2.getNbPartiesGagnees();
}



    /**
     * change le tour des joueurs
     */
    public void changerTourJoueur() {
        j1.tourDeRole();
        j2.tourDeRole();
    }

    /**
     * Methode principale qui permet de faire tourner le jeu
     */
    public void jouer() {
        ihm.saisie_nbre_tas();
        ihm.demanderNomJoueur();
        lesTas.initialiser();
        ihm.afficherTas();
        Joueur j;
        do {
            j = traitementTourJoueur();
            /*ihm.demanderCoup(j,this.lesTas);*/
            ihm.demanderCoup(j);
            changerTourJoueur();
            ihm.afficherTas();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();
    }
    public void versionContinuer(){
        lesTas.initialiser();
        ihm.afficherTas();
        Joueur j;
        do {
            j = traitementTourJoueur();
           /*ihm.demanderCoup(j,this.lesTas);*/
            ihm.demanderCoup(j);
            changerTourJoueur();
            ihm.afficherTas();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();

    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }



    public void recupererCoup(int numTas, int nbMaxAllumettes) {
        CoupNim coup = new CoupNim(numTas, nbMaxAllumettes);

        try {
            this.lesTas.gererCoup(coup);
        } catch (CoupInvalideException e) {
            e.getMessage();
        }
    }




}