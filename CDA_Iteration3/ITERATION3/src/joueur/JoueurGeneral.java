package joueur;

public abstract class JoueurGeneral {
   private String nom;

    private int tour;
    private int nbPartiesGagnees;


    public JoueurGeneral(String nom,int tour) {
        this.nom = nom;
this.tour= tour;
    }





    public int getNbPartiesgagnees() {
        return nbPartiesGagnees;
    }

    public String getNom() {
        return nom;
    }



    public  void tourDeRole() {
        if (tour == 1) {
            tour = 0;
        } else if (tour == 0) {
            tour = 1;
        }
    }

    public void gagnePartie() {
        nbPartiesGagnees++;
    }

    public int getTour() {
        return tour;
    }


    public int getNbPartiesGagnees() {
        return nbPartiesGagnees;
    }


    public abstract char getY();

    public abstract char getX();
}
