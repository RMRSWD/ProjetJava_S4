import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        char[][] grille = new char[7][7];
        init_grille(grille);//khoi tao grille
        grille[1][1]='r';// gan r vao dong 1 cot 1
        grille[1][2]='y';
        printG(7,7,grille);//hien thi grille
        char [][] y =  Gravite(grille);
        printG(7,7,y);// hien thi gravite
        char [][] x = RotationFix(true,grille);
        printG(7,7,x);//hien thi quay trai
        char [][] z = RotationFix(false,grille);
        printG(7,7,z);//hien thi quay phai
    }
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
            int write = 0;
            while (read < Colonne) {
                if (grille[i][read] == '|') {
                    read++;
                    continue;
                }
                new_grille[i][write] = grille[i][read];
                write++;
                read++;
            }
        }
        return new_grille;

    }




}


