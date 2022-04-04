package jeuNim.controleurJeuNim;

import coup.Coup;
import interfaceStrategy.StrategieJeu;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuNim.modele.Joueur;
import jeuNim.modele.Tas;

import joueur.JoueurGeneral;

import vue.Ihm;

import java.util.Scanner;


public class ControleurJeuNim implements StrategieJeu {
    private Ihm _ihm;
    private Tas _lesTas;
    private JoueurGeneral j1;
    private JoueurGeneral j2;


    /*public ControleurJeuNim(Ihm ihm) {
        this.ihm = ihm;
        ihm.setStrategieJeu(this);

    }*/
    public ControleurJeuNim(Ihm ihm) {
        _ihm = ihm;
        /*_lesTas = _lesTas;*/

        /*ihm.setStrategieJeu(this);*/

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
        return _lesTas.toString();
    }

    /**
     * Creer l'objet tas
     * @param a:nombreTas
     */
    public  void gerer_nbTas(int a) {
        _lesTas = new Tas(a);
    }


    /*public char traitementJeton() {
        return 0;
    }*/


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
        this.gerer_nbTas(this._ihm.saisie_nbre_tas());
        int g= _ihm.inputMaxAlu();
        _lesTas.setNbMaxAlu(g);
        String[] noms = this._ihm.demanderNomJoueur();
        this.nom_joueur(noms[0], noms[1]);
        _lesTas.initialiser();
        _ihm.afficherPlateau(_lesTas.toString());
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            _ihm.getCoupJoueurNim(j.getNom());
            this.demanderCoup();
            _lesTas.setNbMaxAlu(g);
            _ihm.afficherPlateau(_lesTas.toString());
            changerTourJoueur();
        } while(!this._lesTas.partieTerminee());
        j.gagnePartie();
        _ihm.afficherGagnant(j);
        boolean rejouer = this._ihm.re_jouer();
        if (rejouer ==true){
            versionContinuer();
        }
        else{
            return;
        }
    }


    private void demanderCoup() {
        do {
            int[] coup_ints = this._ihm.demanderCoupNim();
            CoupNim coup = new CoupNim(coup_ints[0], coup_ints[1]);
            try {
                this._lesTas.gererCoup(coup);
                return;
            } catch (CoupInvalideException e) {
                System.out.println("IpossibleDDD");;
            }
        }while (true);
    }


    public void versionContinuer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {

        _lesTas.initialiser();
        _ihm.afficherPlateau(_lesTas.toString());
        JoueurGeneral j ;
        do {
            j = traitementTourJoueur();
            _ihm.getCoupJoueurNim(j.getNom());
            _ihm.demanderCoupNim();
            _ihm.afficherPlateau(_lesTas.toString());
            changerTourJoueur();
        } while(!this._lesTas.partieTerminee());
        j.gagnePartie();
        _ihm.afficherGagnant(j);
        _ihm.re_jouer();

    }
    public void IA(){

    }

    @Override
    public char traitementJeton() {
        return 0;
    }
    // prendre des informations d'ultilisateur
    /*private String getmove(JoueurGeneral p){
        if(p.IA()){
            return p.getReponse(" ");
        }
        String txt = _ihm.getCoupJoueur(p.getNom());
        return txt;
    }*/



}






