package jeuPuissance4.Modele;

public class Utit {
    public static int[] PosLibre = new int[]{7,7,7,7,7,7,7};

    public static void init_grille(char[][] grille){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                grille[i][j] = '|';
            }
        }
    }

    public static void printG(int Ligne, int Colonne, char[][] grille) {
        String s = "";
        for (int i = 0; i < Ligne; i++) {
            for (int j = 0; j < Colonne; j++) {
                s += grille[i][j] + " ";
            }
            s += "\n";
        }
        System.out.println(s);
    }

    public static char[][] RotationFix(boolean rotationG, char grille[][]) {
        int Ligne = 7;
        int Colonne = 7;
        char[][] new_grille = new char[Ligne][Colonne];
        for (int i = 0; i < Ligne; i++) {
            for (int j = 0; j < Colonne; j++) {
                if (rotationG){
                    new_grille[j][i] = grille[i][6-j];}
                else{
                    new_grille[j][i]= grille[6-i][j];
                }
            }

        }
        return new_grille;

    }

    public static char[][] Gravite(char grille[][]) {
        int Ligne = 7;
        int Colonne = 7;
        char[][] new_grille = new char[Ligne][Colonne];
        init_grille(new_grille);
        for (int i = 0; i < Ligne; i++) {
            int read = 0;
            int wire = 0;
            while (read < Colonne) {
                if (grille[i][read] == '|') {
                    read++;
                    continue;
                }
                new_grille[i][wire] = grille[i][read];
                wire++;
                read++;
            }
        }
        return new_grille;

    }


}
