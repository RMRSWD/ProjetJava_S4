package vue;
import  controleur.Controleur;
import modele.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ihm {
    private Controleur controleur;

    public Ihm() {
        System.out.println(" Bienvenue dans le jeu de Puissance 4. Vous pouvez commencez");
    }

    public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }

    public Controleur getControleur() {
        return controleur;
    }


    /**
     * Methode demande le nom des joeurs
     */
    public void demanderNomJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur premier joueur");
        String nomJoueur1 = sc.nextLine();
        System.out.println("Entrer le nom du deuxième joueur  : ");
        String nomJoueur2 = sc.nextLine();
        controleur.nom_joueur(nomJoueur1, nomJoueur2);

    }

    public void afficherGrille() {
        System.out.println(controleur.grilleInitial());
    }

    /**
     * methode permettant demander le coup
     * @param joueur
     * @param grille
     */
    public void demandeCoup(Joueur joueur, Grille grille) {
        int numcol = 0;
        char couleur = controleur.traitementJeton();
        boolean condition = false;
        do {
            System.out.println(joueur.getNom() + " a vous de jouer : ");

            try {
                Scanner sc = new Scanner(System.in);
                numcol = sc.nextInt();

                CoupPuissance coup = new CoupPuissance(numcol, couleur);
                try {
                    grille.gererCoup(coup);
                } catch (CoupInvalideException e) {
                    System.out.println(e);
                    demandeCoup(joueur, grille);
                }


            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer des entiers");
                demandeCoup(joueur, grille);
            }
        } while (condition);
    }

    /**
     * methode permettant afficher gagnant
     * @param gagnant
     */
    public void afficherGagnant(Joueur gagnant){
        System.out.println("Le joueur "+ gagnant.getNom() + " a gagné !");
        System.out.println("Nombre de partie gagné "+ gagnant.getNbPartiesGagnees());
        System.out.println(" ");
    }

    /**
     * methode permetant de rejouer un coup
     */
    public void re_jouer() {
        while (true) {
            System.out.println(" voulez vous re-jouer?");
            int joueur = 0;
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Tapez vous le numero 1 pour continuer et 2 pour arreter");
                joueur = scanner.nextInt();
                if (joueur == 1) {
                    controleur.versionContinuer();
                    break;
                } else if (joueur == 2) {
                    this.scoreFinal();

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    /**
     * affiche le score final des joueur et montre le vainceur
     */
    public void scoreFinal() {

        System.out.println("Le nombre parti gagner par le joueur"+controleur.getJ1().getNom()+"est\n"+controleur.NbPartiGagnerJoueur1());
        System.out.println("Le nombre parti gagner par le joueur"+controleur.getJ2().getNom()+"est\n"+controleur.NbPartiGagnerJoueur2());
        if (controleur.NbPartiGagnerJoueur1()> controleur.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur"+controleur.getJ1().getNom()+"est le gagnant");
        }
        else if (controleur.NbPartiGagnerJoueur1()< controleur.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur"+controleur.getJ2().getNom()+"est le gagnant");
        }
        else System.out.println("les deux joueurs sont ex aequo");
    }
    public void joueurRoration() {
        int rotationD = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tapez 1 pour une rotation à droite, 2 pour une rotation à gauche");
            rotationD = scanner.nextInt();
            if (rotationD == 1) {
                Grille.rotationDroit(new char[7][7]);
                break;
            } else if (rotationD==2){
                Grille.rotationGauche(new char[7][7]);
                break;
            }
        }


    }


}
