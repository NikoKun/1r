package ExercicisSenzills;

public class Ex6ComptadorDeTemps {
    public static void main(String[] args) {
        long pes;
        long tem;
        long fin;
        String enter;
        String frase;

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
                System.out.println("Has tardat "+fin+" milisegons");
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