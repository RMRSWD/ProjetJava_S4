package vue;
import java.util.*;

import controleur.ControleurJeuNim;
import modele.*;

public class Ihm {
    private ControleurJeuNim controleurJeuNim;
    private int nbMaxAllu;

    public Ihm() {
        System.out.println(" Bienvenue dans le jeu de Nim. Vous pouvez commencez");
    }

    public void setControleurJeuNim(ControleurJeuNim controleurJeuNim){
        this.controleurJeuNim=controleurJeuNim;
    }

    /**
     * methode demandant le nombre de tas
     */

    public void saisie_nbre_tas() {
        System.out.println("Veuillez saisir le nombre de tas :");
        Scanner sc = new Scanner(System.in);
        int nbre_tas = -1;
        do {
            if (sc.hasNextInt()) {

                nbre_tas = sc.nextInt();
                if (nbre_tas >= 1) {
                    controleurJeuNim.gerer_nbTas(nbre_tas);
                }
                else{
                    System.out.println("Veuillez saisir un entier strictement supérieur à zéro");
                }
            }
            else{
                System.out.println("Veillez saisir une valeur entière");
                sc.next();
            }
        } while ((nbre_tas <= 0));
    }

    //input nombre allumette chaque coup

    /**
     * Methode demande le nom des joeurs
     */
    public void demanderNomJoueur(){
        Scanner sc = new Scanner (System.in);
            System.out.println("Entrer le nom du joueur premier joueur");
            String nomJoueur1 = sc.nextLine();
            System.out.println("Entrer le nom du deuxième joueur  : ");
            String nomJoueur2=sc.nextLine();
            controleurJeuNim.nom_joueur(nomJoueur1,nomJoueur2);

    }


    /**
     * Affiche le tas initiale donner pas le controleur
     */
    public void afficherTas() {
        System.out.println(controleurJeuNim.TasInitial());
    }

    /**
     * Methode donnant des instruction au utilisateur
     * @param j
     */

   /* public void demanderCoup(Joueur j,Tas tas) {

        int numTas = 0;
        int nbMaxAllumettes = 0;
        boolean condition = false;
        do {
            System.out.println(j.getNom() + " a vous de jouer : ");

            try{
                Scanner sc = new Scanner(System.in);
                    numTas = sc.nextInt();
                    nbMaxAllumettes = sc.nextInt();
                        CoupNim coup = new CoupNim(numTas, nbMaxAllumettes);
                        try {
                            tas.gererCoup(coup);
                        } catch (CoupInvalideException e) {
                            System.out.println(e);
                            demanderCoup(j,tas);
                        }

                        break;

            } catch (InputMismatchException e){
                System.out.println("Veuillez entrer des entiers");
                demanderCoup(j, tas);
            }



        } while (condition);
    }*/
   /* public void demanderCoup(Joueur j) {

        int numTas = 0;
        int nbMaxAllumettes = 0;
        while (true) {
            System.out.println(j.getNom() + " a vous de jouer.");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                numTas = scanner.nextInt();
                nbMaxAllumettes = scanner.nextInt();
                if (numTas > 0 && nbMaxAllumettes > 0) {
                    controleurJeuNim.recupererCoup(numTas, nbMaxAllumettes);
                    break;
                } else {
                    System.out.println(j.getNom() + "Entrez des valeurs positives !! ");
                }


            }
        }
    }*/
    public void demanderCoup(Joueur j) {

        int numTas = 0;
        int nbMaxAllumettes = 0;
        boolean condition = false;
        do {
            System.out.println(j.getNom() + " a vous de jouer : ");
            Scanner sc = new Scanner(System.in);

            if (sc.hasNextInt()) {
                numTas = sc.nextInt();
                nbMaxAllumettes = sc.nextInt();
                if (numTas > 0 && nbMaxAllumettes > 0) {
                    controleurJeuNim.recupererCoup(numTas, nbMaxAllumettes);
                    break;
                } else {
                    System.out.println(j.getNom() + "Entrez des valeurs positives !! ");
                    condition = true;
                }
            } else {
                System.out.println(" Veillez saisir un coup  valide");
                condition = true;
            }


        } while (condition);
    }

    /**
     * Affiche le joueur Gagnant ainsi que sont score
     * @param gagnant
     */

    public void afficherGagnant(Joueur gagnant){
        System.out.println("Le joueur "+ gagnant.getNom() + " a gagné !");
        System.out.println("Nombre de partie gagné "+ gagnant.getNbPartiesGagnees());
        System.out.println(" ");
    }


    public void re_jouer() {
        while (true) {
            System.out.println(" voulez vous re-jouer?");
            int joueur = 0;
            try {

                Scanner scanner = new Scanner(System.in);
                System.out.println("Tapez vous le numero 1 pour continuer et 2 pour arreter");
                joueur = scanner.nextInt();
                if (joueur == 1) {
                    controleurJeuNim.versionContinuer();
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
 public void scoreFinal() {

     System.out.println("Le nombre parti gagner par le joueur"+controleurJeuNim.getJ1().getNom()+"est\n"+controleurJeuNim.NbPartiGagnerJoueur1());
     System.out.println("Le nombre parti gagner par le joueur"+controleurJeuNim.getJ2().getNom()+"est\n"+controleurJeuNim.NbPartiGagnerJoueur2());
     if (controleurJeuNim.NbPartiGagnerJoueur1()> controleurJeuNim.NbPartiGagnerJoueur2()) {
         System.out.println("le joueur"+controleurJeuNim.getJ1().getNom()+"est le gagnant");
     }
     else if (controleurJeuNim.NbPartiGagnerJoueur1()< controleurJeuNim.NbPartiGagnerJoueur2()) {
         System.out.println("le joueur"+controleurJeuNim.getJ2().getNom()+"est le gagnant");
     }
     else System.out.println("les deux joueurs sont ex aequo");
 }


}



