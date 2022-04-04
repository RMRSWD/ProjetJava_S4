package jeuPuissance4.Controleur;
import jeuNim.controleurJeuNim.ControleurJeuNim;
import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuNim.modele.Joueur;
import jeuPuissance4.Modele.CoupPuissance;
import jeuPuissance4.Modele.Grille;
import jeuPuissance4.Modele.IAPuissance4;
import joueur.JoueurGeneral;
import vue.*;
import interfaceStrategy.StrategieJeu;

public class ControleurJeuPuissance implements StrategieJeu{
    private Ihm _ihm;
    private JoueurGeneral j1;
    private JoueurGeneral j2;
    private Grille _grille;
    private StrategieJeu strategieJeu;
    private ControleurJeuNim controleurJeuNim;
    private ControleurJeuPuissance controleurJeuPuissance;



    public ControleurJeuPuissance(Ihm _ihm) {
        this._ihm = _ihm;
       this._grille = new Grille();
    }

    public String plateauInitial() {
        return _grille.toString();
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

    @Override
    public void IA() {

    }

    private void demandeCoup() {
        do {
            int coup_ints = this._ihm.demanderCoupPuissance();
            char y = 'r';
            if (this.j2.getTour() == 1){
                y = 'j';
            }
            CoupPuissance coup = new CoupPuissance(coup_ints,y);
                try {
                    this._grille.gererCoup(coup);
                } catch (jeuPuissance4.Modele.CoupInvalideException e) {
                    e.printStackTrace();
                }
                return;
        }while (true);
    }

    public void jouerContreIA() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        this.j2 = new IAPuissance4("ordinateur",0);
        _ihm.demanderNomJoueur();
        _grille.initialiser();
        _ihm.afficherPlateau(_grille.toString());
        JoueurGeneral j;
        do {
            j = traitementTourJoueur();
            int g = this.getRotation(j);
            this._grille.Rotation(g);
            this.demandeCoup();
            changerTourJoueur();
            _ihm.afficherPlateau(_grille.toString());
            this.j2.update(this._grille);
        } while(!this._grille.partieTerminer());
        j.gagnePartie();
        _ihm.afficherGagnant(j);
        _ihm.re_jouer();
    }

    private int getRotation( JoueurGeneral j) {
        if(j.IA()){
            return j.getRotation();
        }
        return _ihm.demandeRotation();
    }

    private int getCoup(JoueurGeneral j){
        if (j.IA()){
            return j.getCoup();
        }
        return _ihm.demanderCoupPuissance();
    }

    @Override
    public void versionContinuer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        _grille.initialiser();
        _ihm.afficherPlateau(_grille.toString());
        JoueurGeneral joueurCourant;
        do {
            joueurCourant = traitementTourJoueur();
            _ihm.getCoupJoueurPuissance(joueurCourant.getNom());
            this.demandeCoup();
            _ihm.afficherPlateau(_grille.toString());
            int g = _ihm.demandeRotation();
            this._grille.Rotation(g);
            _ihm.afficherPlateau(_grille.toString());
            /*this.demandeCoup();*/
            /*_ihm.afficherPlateau(_grille.toString());*/
            changerTourJoueur();
        } while(!this._grille.partieTerminer());
        joueurCourant.gagnePartie();
        _ihm.afficherGagnant(joueurCourant);
    }

    public void jouer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        String[] noms = this._ihm.demanderNomJoueur();
        this.nom_joueur(noms[0], noms[1]);
        _grille.initialiser();
        _ihm.afficherPlateau(_grille.toString());
        JoueurGeneral joueurCourant;
        do {
            joueurCourant = traitementTourJoueur();
            _ihm.getCoupJoueurPuissance(joueurCourant.getNom());
            this.demandeCoup();
            _ihm.afficherPlateau(_grille.toString());
            int g = _ihm.demandeRotation();
            this._grille.Rotation(g);
            _ihm.afficherPlateau(_grille.toString());
            /*this.demandeCoup();*/
            /*_ihm.afficherPlateau(_grille.toString());*/
            changerTourJoueur();
        } while(!this._grille.partieTerminer());
        joueurCourant.gagnePartie();
        _ihm.afficherGagnant(joueurCourant);
        boolean rejouer = _ihm.re_jouer();
        if (rejouer ==true){
            versionContinuer();
        }
        else{
            return;
        }
    }





}
