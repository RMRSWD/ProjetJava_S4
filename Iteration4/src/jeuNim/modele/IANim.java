package jeuNim.modele;

import java.util.Random;

public class IANim {



    public void Aleatoire(){
        int min = 1;
        int max = 10;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;

    }
}
