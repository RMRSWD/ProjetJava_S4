package Nim.controleur;
import Joueur.Joueur;
import Nim.modele.Tas;
import controleurJeux.ControleurJeux;
import vue.Ihm;

public class ControleurJeuNim extends ControleurJeux {
    private Ihm ihm;
    private Tas lesTas;



    public ControleurJeuNim(Ihm ihm) {
        super(ihm);
        this.ihm= ihm;
        ihm.setControleurJeux(this);//je change ici
ihm.setControleurJeuNim(this);
    }


    /**
     * return les allumettes qui sera afficher dans l'Ihm
     * @return
     */

    public String afficherTas() {
        return lesTas.toString();
    }






    /**
     * Creer l'objet tas
     * @param a
     */
    public void gerer_nbTas(int a) {
        lesTas = new Tas(a);
    }

    

    /**
     * permet de renvoyer le joueur courant
     * @return
     */
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


   /* public int NbPartiGagnerJoueur1( ) {
        return super.getJ1().getNbPartiesGagnees();
    }
    public int NbPartiGagnerJoueur2() {
        return super.getJ2().getNbPartiesGagnees();
    }

*/

    /**
     * change le tour des joueurs
     */
    /*public void changerTourJoueur() {Duc::
        super.getJ1().tourDeRole();
        super.getJ2().tourDeRole();
    }*/

    /**
     * Methode principale qui permet de faire tourner le jeu
     */
    @Override
    public void jouer() {
        ihm.saisie_nbre_tas();
        ihm.inputMaxAlu();
        ihm.demanderNomJoueur();
        lesTas.initialiser();
        ihm.afficherTas();
        Joueur j;
        do {
            j = super.traitementTourJoueur();
            ihm.demanderCoup(j,this.lesTas);
           super.changerTourJoueur();
            ihm.afficherTas();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();
    }
    public void versionContinuer(){
        lesTas.initialiser();
        ihm.inputMaxAlu();
        ihm.afficherTas();
        Joueur j;
        do {
            j = super.traitementTourJoueur();
            ihm.demanderCoup(j,this.lesTas);
            changerTourJoueur();
            ihm.afficherTas();
        } while(!this.lesTas.partieTerminee());
        j.gagnePartie();
        ihm.afficherGagnant(j);
       ihm.re_jouer();

    }


}