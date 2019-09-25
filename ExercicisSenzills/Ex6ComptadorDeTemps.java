package ExercicisSenzills;
import java.text.DecimalFormat;

public class Ex6ComptadorDeTemps {
    public static void main(String[] args) {
        long pes;
        long tem;
        long fin;
        String enter;
        String frase;
        DecimalFormat find = new DecimalFormat("###.##");


        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Escriu (Start) per començar a escriure (Setze jutges d'un jutjat mengen fetge en un penjat):");
        enter = System.console().readLine(); 
        System.out.println("-----------------------------------------------------------------------");

        if(enter.equals("Start")){
            pes = System.currentTimeMillis();
            frase = System.console().readLine(); 

            if (frase.equals("Setze jutges d'un jutjat mengen fetge en un penjat")){
                tem = System.currentTimeMillis();
                fin = tem-pes;
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Has tardat "+ find.format((float)fin/1000)+" segons");
                System.out.println("-----------------------------------------------------------------------");

            }

            else {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Ho has escrit malament...");
                System.out.println("-----------------------------------------------------------------------");


            }

        }
        else {
        System.out.println("Sortint...");

        }


     }
}