package vue;
import java.util.*;

import coup.Coup;
import jeuNim.controleurJeuNim.*;
import interfaceStrategy.StrategieJeu;

import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuPuissance4.Controleur.ControleurJeuPuissance;
import jeuPuissance4.Modele.CoupPuissance;
import jeuPuissance4.Modele.Joueur;
import joueur.JoueurGeneral;
import plateau.Plateau;
public class Ihm {
    private StrategieJeu strategieJeu;
    private ControleurJeuNim controleurJeuNim;
private ControleurJeuPuissance controleurJeuPuissance;

    private int nbMaxAllu;

    public void setStrategieJeu(StrategieJeu strategieJeu) {
        this.strategieJeu = strategieJeu;
    }

    public void setControleurJeuPuissance(ControleurJeuPuissance controleurJeuPuissance) {
        this.controleurJeuPuissance = controleurJeuPuissance;
    }

    public void setControleurJeuNim(ControleurJeuNim controleurJeuNim) {
        this.controleurJeuNim = controleurJeuNim;
    }

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
        strategieJeu.nom_joueur(nomJoueur1, nomJoueur2);

    }


    public void saisie_nbre_tas() {
        System.out.println("Veuillez saisir le nombre de tas :");
        Scanner sc = new Scanner(System.in);
        int nbre_tas = -1;
        do {
            if (sc.hasNextInt()) {

                nbre_tas = sc.nextInt();
                if (nbre_tas >= 1) {
                    strategieJeu.gerer_nbTas(nbre_tas);
                } else {
                    System.out.println("Veuillez saisir un entier strictement supérieur à zéro");
                }
            } else {
                System.out.println("Veillez saisir une valeur entière");
                sc.next();
            }
        } while ((nbre_tas <= 0));
    }


    public int inputMaxAlu() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Saisissez le nombre maximum d'allumettes que l'on peut retirer à chaque coup: ");
                nbMaxAllu = scanner.nextInt();
                if (nbMaxAllu >= 0) {
                    return nbMaxAllu;
                } else {
                    System.out.println("Le nombre maximum d'allumettes dois etre superieur ou egal 0\n");
                }
            } catch (Exception e) {
                System.out.println("Le programme n'accepte qu'un entier, choisissez à nouveau! \n");
            }
            return nbMaxAllu;
        }
    }

    public void afficherPlateau() {
        System.out.println(strategieJeu.plateauInitial());
    }


    public void demanderCoup(JoueurGeneral j, Plateau plateau) throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {

        int numTas;
        int nbMaxAllumettes;

        boolean condition = false;
        do {
            System.out.println(j.getNom() + " a vous de jouer : ");

            try {
                Scanner sc = new Scanner(System.in);
                numTas = sc.nextInt();
                nbMaxAllumettes = sc.nextInt();
                Coup coup = new CoupNim(numTas, nbMaxAllumettes);
                if (nbMaxAllumettes <= nbMaxAllu||nbMaxAllu==0) {
                    plateau.gererCoup(coup);
                } else {
                    System.out.println("Vous avez saisi un nombre dépassant le niveau spécifié.\nVeuillez re-saisir un numéro <= " + nbMaxAllu);
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Veuillez entrer des entiers");
                demanderCoup(j, plateau);
            }


        } while (condition);
    }



 public void demandeCoup(JoueurGeneral joueur, Plateau plateau) throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
       /* int numcol = 0;
        char couleur = strategieJeu.traitementJeton();
        boolean condition = false;
        do {
            System.out.println(joueur.getNom() + " a vous de jouer : ");

            try {
                Scanner sc = new Scanner(System.in);
                numcol = sc.nextInt();

                Coup coup = new CoupPuissance(numcol, couleur);
                plateau.gererCoup(coup);


            } catch (jeuPuissance4.Modele.CoupInvalideException e) {
                System.out.println("Veuillez entrer des entiers");
                demandeCoup(joueur, plateau);
            }
        } while (condition);*/
         int numcol = 0;
         char couleur = strategieJeu.traitementJeton();
         boolean condition = false;
         do {
             System.out.println(joueur.getNom() + " a vous de jouer : ");

             try {
                 Scanner sc = new Scanner(System.in);
                 numcol = sc.nextInt();

                 CoupPuissance coup = new CoupPuissance(numcol, couleur);
                 try {
                     plateau.gererCoup(coup);
                 } catch (CoupInvalideException e) {
                     System.out.println(e);
                     demandeCoup(joueur, plateau);
                 }


             } catch (InputMismatchException e) {
                 System.out.println("Veuillez entrer des entiers");
                 demandeCoup(joueur, plateau);
             }
         } while (condition);
    }



    /**
     * methode permettant afficher gagnant
     *
     * @param
     */

    public void afficherGagnant(JoueurGeneral gagnant) {
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
            int joueur;
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Tapez vous le numero 1 pour continuer et 2 pour arreter");
                joueur = scanner.nextInt();
                if (joueur == 1) {
                    strategieJeu.versionContinuer();
                    break;
                } else if (joueur == 2) {
                    //this.scoreFinal();

                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    /**
     *
    public void scoreFinal(Joueur j1, Joueur j2) {

        System.out.println("Le nombre parti gagner par le joueur" + ":" + j1.getNom() + "est\n" + j1.NbPartiGagnerJoueur1());
        System.out.println("Le nombre parti gagner par le joueur" + ":" + j2.getNom() + "est\n" + j2.NbPartiGagnerJoueur2());
        if (j1.NbPartiGagnerJoueur1() > j2.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur" + j1.getNom() + "est le gagnant");
        } else if (j1.NbPartiGagnerJoueur1() < j2.NbPartiGagnerJoueur2()) {
            System.out.println("le joueur" + j2.getNom() + "est le gagnant");
        } else System.out.println("les deux joueurs sont ex aequo");
    }
     affiche le score final des joueur et montre le vainceur
     */

}
