package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<String> Cantant = new ArrayList<String>();
        ArrayList<String> Titol = new ArrayList<String>();
        ArrayList<ArrayList<String>> ArrString = new ArrayList<ArrayList<String>>();

        ArrayList<Integer> ID = new ArrayList<Integer>();
        ArrayList<Integer> Vots = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> ArrInt = new ArrayList<ArrayList<Integer>>();

        boolean exit = true;
        int menu = 0;
        int compta = 0;

        int posicions[] = new int[9999];


        // Cantant.add("Niko De Corridor");
        // Titol.add("Tu y yo");
        // ID.add(0);
        // Vots.add(230);


        while (exit) {

            menu();
            menu = Integer.parseInt(System.console().readLine("Opció: "));

            switch (menu) {
            case 1:
                System.out.println("--------------------------------------------------------------------------------");
                Cantant.add(compta, System.console().readLine("Cantant: "));
                Titol.add(compta, System.console().readLine("Cançó: "));
                ID.add(compta);
                Vots.add(0);


                compta++;
                ArrString.add(Cantant);
                ArrString.add(Titol);
                ArrInt.add(ID);
                ArrInt.add(Vots);

            break;

            case 2:
                llistaTot(ArrString, ArrInt, compta, posicions);
                System.out.println("--------------------------------------------------------------------------------");
                int pos = Integer.parseInt(System.console().readLine("ID: "));
                pos--;
                Vots.set(pos,(Vots.get(pos)+1));


                ArrInt.add(ID);
                ArrInt.add(Vots);
            break;

            case 3:
                llistaTot(ArrString, ArrInt, compta, posicions);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("Quin tema vols eliminar?");
                pos = Integer.parseInt(System.console().readLine("ID: "));
                pos--;
                compta--;


                Vots.remove(pos);
                ID.remove(pos);
                Cantant.remove(pos);
                Titol.remove(pos);

                ArrInt.add(ID);
                ArrInt.add(Vots);
                ArrString.add(Cantant);
                ArrString.add(Titol);


            break;

            case 4:
                llistaTot(ArrString, ArrInt, compta, posicions);
            break;

            case 5:
                exit = false;
            break;
            }
        }

        // al.add(al1);
        // al.add(al2);

        // System.out.println(al.get(0).get(0));

    }

    public static void menu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("1 - Afegeix un cantant");
        System.out.println("2 - Afegeix vots");
        System.out.println("3 - Eliminar tema");
        System.out.println("4 - Llista els temes");
        System.out.println("5 - Exit");
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void llistaTot(ArrayList<ArrayList<String>> ArrString, ArrayList<ArrayList<Integer>> ArrInt,int compta, int posicions[]) {
        sorttemas(ArrInt, posicions, compta);

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Cantants i cançons:\n");
        System.out.println("ID    Cantant\t       Cançó\t        Vots");
        System.out.println("--------------------------------------------------------------------------------");
        for (int i = 0; i < compta; i++) {
            System.out.print(ArrInt.get(0).get(posicions[i])+1+". ");
            System.out.print("   ");
            System.out.print(ArrString.get(0).get(posicions[i]));
            System.out.print("\t - \t");
            System.out.print(ArrString.get(1).get(posicions[i]));
            System.out.print("\t - \t");
            System.out.print(ArrInt.get(1).get(posicions[i]));
            System.out.println();
            System.out.println();
        }
    }


    
    public static void sorttemas(ArrayList<ArrayList<Integer>> ArrInt, int posicions[], int compta) {
        int auxPos = 0;

        for(int i=0; i<compta; i++){
            posicions[i]=(i);
        }

        for(int i=0; i<(compta); i++){
            for(int j=0; j<(compta-1); j++){
                if ((ArrInt.get(1).get(posicions[j])) < (ArrInt.get(1).get(posicions[j+1]))){
                    auxPos = posicions[j+1];
                    posicions[j+1] = posicions[j];
                    posicions[j] = auxPos;
                }
            }
        }

    }
}