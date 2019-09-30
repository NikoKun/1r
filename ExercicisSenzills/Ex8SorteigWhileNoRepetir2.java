package ExercicisSenzills;
import java.util.Random;

public class Ex8SorteigWhileNoRepetir2 {
    public static void main(String[] args) {
        Random num1 = new Random(); 
        int numero = num1.nextInt(1000);            //Aquest número aleatori sería del 0 al 999 ja que també compten el 0 com un número.
        int intentos=0;
        int rannum=0;
        int i = 0;

        boolean encontrado = false;
        
        int array[] = new int[1000];

    for(i=0;i<array.length;i++){
        array[i]= 2000;
    }

        while (!encontrado){                             //!trobat és igual a trobat=false ja que la exclamació és una negació.
            rannum = num1.nextInt(1000);
            boolean coin=false;
            for(i=0; i<array.length;i++){
                if(array[i]==rannum){
                    coin=true;
                    break;
                }
            }
            if (coin==false){                                  //Posar només la variable booleana és el mateix que el valor per defecte.
                array[intentos]=rannum;
                intentos++;
                if(numero==rannum)
                    encontrado=true;
            }
            else{
                System.out.println("Wala este no");
            }
        }
    
 
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("El número a endivinar era: "+rannum);
        System.out.println("A trigat "+intentos+" vegades.");
        System.out.println("-----------------------------------------------------------------------");

    }
}