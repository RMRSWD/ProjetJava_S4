package vue;
import java.util.*;

import coup.Coup;
import jeuNim.controleurJeuNim.*;
import interfaceStrategy.StrategieJeu;

import jeuNim.modele.CoupInvalideException;
import jeuNim.modele.CoupNim;
import jeuNim.modele.Joueur;
import jeuPuissance4.Controleur.ControleurJeuPuissance;
import jeuPuissance4.Modele.CoupPuissance;
import jeuPuissance4.Modele.Grille;
import joueur.JoueurGeneral;
import plateau.Plateau;
public class Ihm {
    /*private int nbMaxAllu;*/
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
    public String[] demanderNomJoueur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer le nom du joueur premier joueur");
        String nomJoueur1 = sc.nextLine();
        System.out.println("Entrer le nom du deuxième joueur  : ");
        String nomJoueur2 = sc.nextLine();
        return new String[]{nomJoueur1,nomJoueur2};

    }


    public int saisie_nbre_tas() {
        System.out.println("Veuillez saisir le nombre de tas :");
        Scanner sc = new Scanner(System.in);
        int nbre_tas = -1;
        do {
            if (sc.hasNextInt()) {

                nbre_tas = sc.nextInt();
                if (nbre_tas >= 1) {
                   return nbre_tas;
                } else {
                    System.out.println("Veuillez saisir un entier strictement supérieur à zéro");
                }
            } else {
                System.out.println("Veillez saisir une valeur entière");
                sc.next();
            }
        } while (true);
    }


    public int inputMaxAlu() {
        while (true) {
            int nbMaxAllu;
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
        }
    }

    public void afficherPlateau(String m) {
        System.out.println(m);

        /*System.out.println(strategieJeu.plateauInitial());*/

    }


    /*public void demanderCoup(JoueurGeneral j)  {

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
                if (nbMaxAllumettes <= nbMaxAllu || nbMaxAllu == 0) {
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
    }*/
    public int [] demanderCoupNim()  {
        while(true){
            int numTas=0;
            int nbMaxAllumettes = 0;
            try {
                Scanner scanner = new Scanner(System.in);
                numTas = scanner.nextInt();
                nbMaxAllumettes = scanner.nextInt();
                if (nbMaxAllumettes>=1) {
                    return new int[]{numTas, nbMaxAllumettes};
                } else {
                    System.out.println("Vous avez saisi un nombre dépassant le niveau spécifié.");
                }
            }
        catch (Exception e) {
            System.out.println("Le programme n'accepte qu'un entier, choisissez à nouveau! \n");
        }


        }


    }


    public int demanderCoupPuissance(){
        System.out.println("Choisir entre 1 et 7");
        while(true) {
            int m;
            try {
                Scanner keyboardM = new Scanner(System.in);
                m = keyboardM.nextInt(); // .nextLine() = type String
                if (m >=1 && m <=7) {
                    return m;
                } else {
                    System.out.println("Nombre de tas dois etre superieur ou egal 1 !\n");
                    // nombre de Tas dois etre >= 1
                }
            } catch (Exception e) {
                System.out.println("Le programme n'accepte qu'un entier, choisissez à nouveau! \n");
            }
        }


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

    public boolean re_jouer() {
        while (true) {
            System.out.println(" voulez vous re-jouer?");
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Tapez vous 'Y' pour continuer et 'N' pour arreter");
                String joueur = scanner.nextLine();
                if (joueur.equals("Y")||joueur.equals("y")) {
                    return true;
                } else if (joueur.equals("N")||joueur.equals("n")) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }

    public int inputVersion() throws CoupInvalideException, jeuPuissance4.Modele.CoupInvalideException {
        int version = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez version: " +
                    "\n -Saisissez 1 pour version human contre human." +
                    "\n -Saisissez 2 pour version human contre ordinateur.");
            version = scanner.nextInt();
            if (version == 1) {
                break;
            } else if (version == 2) {
                break;
            }
        }
        return version;
    }


    public int demandeRotation() {
        System.out.println(" Veuillez saissir  0 pour la grille originale ou 1 pour la rotation gauche ou 2 pour la rotation droite");
        Scanner sc = new Scanner(System.in);
        int reponse = 0;
        do {
                reponse = sc.nextInt();
                if(reponse == 0){
                    return reponse;
                }
                else if (reponse == 1) {
                    return reponse;
                } else if (reponse == 2) {
                    return reponse;
                } else {
                    System.out.println("Veuillez saissir 1 pour la rotation gauche ou 2 pour la rotation droite");
                }
        } while (true);

    }

    /*public String getCoupJoueur(String nomj) {

        Scanner keyboardCoup = new Scanner(System.in);
        System.out.println(nomj +": à vous de jouer un coup sous la forme\n" + "'m n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas.");
        return keyboardCoup.nextLine();
    }*/
    public String getCoupJoueurPuissance(String nomj) {

        /*Scanner keyboardCoup = new Scanner(System.in);*/
        System.out.println(nomj +": à vous de jouer");
        /*return keyboardCoup.nextLine();*/
        /*return keyboardCoup;*/
        return nomj;
    }

    public String getCoupJoueurNim(String nomj){
        System.out.println(nomj +": à vous de jouer un coup sous la forme\n" + "'m n' où m est le tas choisi et n le nombre d'allumettes à retirer dans ce tas.");
        return nomj;
    }

}
