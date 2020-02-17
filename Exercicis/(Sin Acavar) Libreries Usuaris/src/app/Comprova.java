package app;

import java.util.ArrayList;
import java.util.HashMap;
import classes.Usuaris;

public class Comprova {
    public static boolean comprovaUsuaris(Object[] personaTemp, HashMap<String, Usuaris> usuaris) {
        int[] usuariRepetit = {0};

        usuaris.forEach((k,l) ->{
            if (k.equalsIgnoreCase(personaTemp[0].toString())){
                usuariRepetit[0]++;
            }
        });

        if (usuariRepetit[0] > 0){
            return false;
        }
        else {
            return true;
        }

    }




    
}