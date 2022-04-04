package jeuNim.controleurJeuNim;

import interfaceStrategy.StrategieJeu;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.Joueur;
import jeuNim.modele.Tas;

import joueur.JoueurGeneral;

import vue.Ihm;


public class ControleurJeuNim implements StrategieJeu {
    private Ihm ihm;
    private Tas lesTas;
    private JoueurGeneral j1;
    private JoueurGeneral j2;


    public ControleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
        ihm.setStrategieJeu(this);

    }

    /**
     * Creer les objets joueurs
     * @param nomJ1
     * @param nomJ2
     */
    @Override
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

    public String plateauInitial() {
        return lesTas.toString();
    }

    /**
     * Creer l'objet tas
     * @param a
     */
    public  void gerer_nbTas(int a) {
        lesTas = new Tas(a);
    }

    @Override
    public char traitementJeton() {
        return 0;
    }


    /**
     * permet de renvoyer le joueur courant
     * @return
     */
    public JoueurGeneral traitementTourJoueur() {

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
    public void jouer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        ihm.saisie_nbre_tas();
        ihm.inputMaxAlu();
        ihm.demanderNomJoueur();
        lesTas.initialiser();
        ihm.afficherPlateau();
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            ihm.demanderCoup(j,this.lesTas);
            changerTourJoueur();
            ihm.afficherPlateau();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();
    }
    public void versionContinuer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        lesTas.initialiser();
        ihm.afficherPlateau();
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            ihm.demanderCoup(j,this.lesTas);
            changerTourJoueur();
            ihm.afficherPlateau();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();

    }



}