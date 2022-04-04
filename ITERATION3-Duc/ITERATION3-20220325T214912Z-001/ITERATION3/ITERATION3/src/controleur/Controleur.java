/*package controleur;
import Joueur.Joueur;
import vue.Ihm;

public abstract class Controleur {
    *//*private Joueur j1;
    private Joueur j2;*//*

    public Controleur(Ihm ihm) {
    }


    *//*public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }*//*

    public abstract int NbPartiGagnerJoueur1();
    public abstract int NbPartiGagnerJoueur2();

    *//*public abstract String BarreInitiale();*//*


    *//*public abstract void changerTourJoueur();*//*

    public abstract void jouer();

    public abstract void versionContinuer();

   *//* public void nom_joueur(String nomJ1, String nomJ2) {
        String nomJoueur1 = nomJ1;
        String nomJoueur2 = nomJ2;
        this.j1 = new Joueur(nomJoueur1, 1);
        this.j2 = new Joueur(nomJoueur2, 0);
    }*//*

   *//* public void changerTourJoueur(){//DUC::Je change ici
        this.j1.tourDeRole();
        this.j2.tourDeRole();

    }

    public Joueur traitementTourJoueur(){
        if(getJ1().getTour()==1){
            return getJ1();
        }
        else if (getJ2().getTour()==1){
            return getJ2();
        }
        return  getJ1();
    }*//*
}*/
package controleur;
        import Joueur.Joueur;
        import vue.Ihm;

public interface Controleur {

    public int NbPartiGagnerJoueur1();

    public int NbPartiGagnerJoueur2();


    public void jouer();

    public void versionContinuer();

    public Joueur traitementTourJoueur();

    public void changerTourJoueur();

}