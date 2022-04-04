package interfaceStrategy;

import jeuNim.modele.CoupInvalideException;
import joueur.JoueurGeneral;

public interface StrategieJeu {
    public String plateauInitial() ;
    public JoueurGeneral traitementTourJoueur();
    public int NbPartiGagnerJoueur2();
    public int NbPartiGagnerJoueur1();

 public void jouer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException;
    public  void versionContinuer() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException;

    public void nom_joueur(String nomJoueur1, String nomJoueur2);


   public  void gerer_nbTas(int nbre_tas);

    char traitementJeton();
}




