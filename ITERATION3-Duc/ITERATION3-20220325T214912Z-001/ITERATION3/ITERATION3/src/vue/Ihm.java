package vue;

import Joueur.Joueur;
import Nim.modele.CoupNim;
import Nim.modele.Tas;
import controleur.Controleur;
import Puissance4.modele.*;

import java.util.*;

import Nim.controleur.ControleurJeuNim;
import Puissance4.controleur.ControleurPuissance4;
import controleurJeux.ControleurJeux;

public class Ihm {
    private Controleur controleur;
    private ControleurJeuNim controleurJeuNim;
    private ControleurPuissance4 controleurPuissance4;
    private int nbMaxAllu;
    private ControleurJeux controleurJeux;

    /*public void setControleur(Controleur controleur) {
        this.controleur = controleur;
    }*///DUC
    public void setControleurJeux(ControleurJeux controleurJeux){
        this.controleurJeux = controleurJeux;
    }



    public void setControleurPuissance4(ControleurPuissance4 controleurPuissance4) {
        this.controleurPuissance4 = controleurPuissance4;
    }

    public void setControleurJeuNim(ControleurJeuNim controleurJeuNim) {
        this.controleurJeuNim = controleurJeuNim;
    }//DUC

    public int choixJeu() {
        System.out.println("Bienvenue\n Veuillez saissir 1 pour jouer au jeu de Nim ou 2 pour le jeu de puissance 4");
        Scanner sc = new Scanner(System.in);
        int choix = 0;
        int reponse = 0;
        do {
            if (sc.hasNextInt()) {

                reponse = sc.nextInt();
                if (reponse == 1) {

                    choix = reponse;
                    return choix;
                } else if (reponse == 2) {
                    choix = reponse;
                    return choix;
                } else {
                    System.out.println("Veuillez saisir 1 pour Jeu de Nim ou 2 pour Jeu de Puissance 4");
                }
            } else {
                System.out.println("Veillez saisir une valeur entière");
                sc.next();
            }
        } while ((reponse != 1 || reponse != 2));

        return choix;
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
        controleurJeux.nom_joueur(nomJoueur1, nomJoueur2);

    }


    public void saisie_nbre_tas() {
        System.out.println("Veuillez saisir le nombre de tas :");
        Scanner sc = new Scanner(System.in);
        int nbre_tas = -1;
        do {
            if (sc.hasNextInt()) {

                nbre_tas = sc.nextInt();
                if (nbre_tas >= 1) {
                    controleurJeuNim.gerer_nbTas(nbre_tas);
                } else {
                    System.out.println("Veuillez saisir un entier strictement supérieur à zéro");
                }
            } else {
                System.out.println("Veillez saisir une valeur entière");
                sc.next();
            }
        } while ((nbre_tas <= 0));
    }


    public int inputMaxAlu(){
                while(true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Saisissez le nombre maximum d'allumettes que l'on peut retirer à chaque coup: ");
                nbMaxAllu = scanner.nextInt();
                if (nbMaxAllu>=0) {
                    return nbMaxAllu;
                }else{
                    System.out.println("Le nombre maximum d'allumettes dois etre superieur ou egal 0\n");
                }
            }catch (Exception e){
                System.out.println("Le programme n'accepte qu'un entier, choisissez à nouveau! \n");
            }
            return nbMaxAllu;
        }
    }

    public void afficherTas() {
        System.out.println(controleurJeuNim.afficherTas());
    }

    public void afficherGrille() {
        System.out.println(controleurPuissance4.afficherGrille());
    }

    public void demanderCoup(Joueur j,Tas tas) {

        int numTas ;
        int nbMaxAllumettes ;

        boolean condition = false;
        do {
            System.out.println(j.getNom() + " a vous de jouer : ");

            try {
                Scanner sc = new Scanner(System.in);
                numTas = sc.nextInt();
                nbMaxAllumettes = sc.nextInt();
                CoupNim coup = new CoupNim(numTas, nbMaxAllumettes);
                try {
                    if (nbMaxAllumettes <= nbMaxAllu||nbMaxAllu==0) {
                        tas.gererCoup(coup);}
                    else{
                        System.out.println("Vous avez saisi un nombre dépassant le niveau spécifié.\nVeuillez re-saisir un numéro <= "+nbMaxAllu);
                    }
                } catch (Nim.modele.CoupInvalideException e) {
                    System.out.println(e);
                    demanderCoup(j, tas);
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer des entiers");
                demanderCoup(j, tas);
            }


        } while (condition);
    }


    public void demandeCoupPuissance(Joueur joueur, Grille grille) {
        int numcol = 0;
        char couleur = controleurPuissance4.traitementJeton();
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
                    demandeCoupPuissance(joueur, grille);
                }


            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer des entiers");
                demandeCoupPuissance(joueur, grille);
            }
        } while (condition);
    }

    /**
     * methode permettant afficher gagnant
     *
     * @param gagnant
     */

    public void afficherGagnant(Joueur gagnant) {
        System.out.println("Le joueur " + gagnant.getNom() + " a gagné !");
        System.out.println("Nombre de partie gagné " + gagnant.getNbPartiesGagnees());
        System.out.println(" ");
    }

    /**
     * methode permetant de rejouer au jeu
     */
    public void re_jouer() {
        while (true) {
            System.out.println(" voulez vous re-jouer?");
            int joueur ;
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Tapez vous le numero 1 pour continuer et 2 pour arreter");
                joueur = scanner.nextInt();
                if (joueur == 1) {
                    controleurJeux.versionContinuer();
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
    public void scoreFinal() {//Duc::Je change ici ControleurJeux

        System.out.println("Le nombre parti gagner par le joueur" + ": " + controleurJeux.getJ1().getNom() + " est\n" + controleurJeux.NbPartiGagnerJoueur1());
        System.out.println("Le nombre parti gagner par le joueur" + ": " +controleurJeux.getJ2().getNom() + " est\n" + controleurJeux.NbPartiGagnerJoueur2());
        if (controleurJeux.NbPartiGagnerJoueur1() > controleurJeux.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur" + controleurJeux.getJ1().getNom() + "est le gagnant");
        } else if (controleurJeux.NbPartiGagnerJoueur1() < controleur.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur" + controleurJeux.getJ2().getNom() + "est le gagnant");
        } else System.out.println("les deux joueurs sont ex aequo");
    }


   /* public void setControleur(ControleurJeuNim controleurJeuNim) {
    }*/

    /*public void RotationGrille(){
        int num = 0;
        Scanner scanner = new Scanner (System.in);
        while(true){
            System.out.printf("Tapez 1 pour la rotation droite et 2 pour la gauche");
            num = scanner.nextInt();
            if (num == 1){


            }
        }
    }*/
}
