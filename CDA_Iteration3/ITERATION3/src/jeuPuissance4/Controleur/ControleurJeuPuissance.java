package jeuPuissance4.Controleur;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuPuissance4.Modele.Grille;
import jeuPuissance4.Modele.Joueur;
import joueur.JoueurGeneral;
import vue.*;
import interfaceStrategy.StrategieJeu;

public class ControleurJeuPuissance implements StrategieJeu{
    private Ihm ihm;
    private JoueurGeneral j1;
    private JoueurGeneral j2;
   private Grille grille;



    public ControleurJeuPuissance(Ihm ihm) {
        this.ihm= ihm;
        ihm.setStrategieJeu(this);
       this.grille = new Grille();
    }

    public String plateauInitial() {
        return grille.toString();
    }

    @Override
    public JoueurGeneral traitementTourJoueur() {
        if (this.j1.getTour() == 1) {
            return this.j1;
        } else if (this.j2.getTour() == 1) {
            return this.j2;
        }
        return this.j1;
    }

    public char traitementJeton() {
        if (this.j1.getTour() == 1) {
            return this.j1.getX();

        }
        else if (this.j2.getTour()==1) {
            return this.j2.getY();
        }

        return this.j1.getX();
    }

    @Override
    public int NbPartiGagnerJoueur2() {

            return j2.getNbPartiesGagnees();
    }

        public int NbPartiGagnerJoueur1() {

            return j1.getNbPartiesGagnees();
    }




    public void changerTourJoueur() {
        j1.tourDeRole();
        j2.tourDeRole();
    }

    public void nom_joueur(String nomJ1, String nomJ2){
        String nomJoueur1 = nomJ1;
        String nomJoueur2 = nomJ2;
        this.j1 = new Joueur(nomJoueur1, 1);
        this.j2 = new Joueur(nomJoueur2, 0);
    }

    @Override
    public void gerer_nbTas(int nbre_tas) {

    }


    public void jouer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        ihm.demanderNomJoueur();
        grille.initialiser();
        ihm.afficherPlateau();
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            ihm.demandeCoup(j,this.grille);
            changerTourJoueur();
            ihm.afficherPlateau();
        } while(!this.grille.partieTerminer());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();
    }

    @Override
    public void versionContinuer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        grille.initialiser();
        ihm.afficherPlateau();
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            ihm.demanderCoup(j,this.grille);
            changerTourJoueur();
            ihm.afficherPlateau();
        } while(!this.grille.partieTerminer());
        j.gagnePartie();
        ihm.afficherGagnant(j);
        ihm.re_jouer();


    }


}
