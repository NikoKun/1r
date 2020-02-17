package app;

import java.util.TreeMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        HashMap<String, ArrayList<Object>> pacients = new HashMap<String, ArrayList<Object>>(); // ID Sanitaria, nom, data naixement
        HashMap<String, ArrayList<Object>> metge = new HashMap<String, ArrayList<Object>>(); // ID Metge, nom, especialitat

        HashMap<String, String> metgespersonals = new HashMap<String, String>(); // ID pacient, id metge, 

        TreeMap<Integer, ArrayList<Object>> visites = new TreeMap<Integer, ArrayList<Object>>(); // ID Visita, data, id metge, id pacient

        String sep = "------------------------------------------------------------------------------------------------------------";

        boolean acabat = false;
        int numvisita = 0;

        while (!acabat){
            int dataI[] = new int[3];
            String data = ".";
            int horaI[] = new int[2];
            String hora = ".";

            System.out.println(sep);
            System.out.println("1 - Afegir metges");
            System.out.println("2 - Afegir pacients");
            System.out.println("3 - Afegir visites");
            System.out.println("4 - Llistar les visites per metges");
            System.out.println("5 - Llistar els metges");
            System.out.println("6 - Llistar els pacients");
            System.out.println(sep);

            System.out.println("Escull opció: ");
            int menu = Integer.parseInt(System.console().readLine());
            System.out.println(sep);

            switch (menu){
                case 1:
                    ArrayList<Object> ifnoMetge = new ArrayList<Object>();
                    boolean correcte = false;

                    while (!correcte){
                        String id = System.console().readLine("ID del metge: ");
                        ifnoMetge.add(System.console().readLine("Nom del metge: "));
                        ifnoMetge.add(System.console().readLine("Especialitat del metge: "));

                        System.out.println(sep);
                        correcte = segur(id, ifnoMetge, metge);
                    }
                break;
                case 2:
                    ArrayList<Object> infoPacient = new ArrayList<Object>();
                    correcte = false;

                    while (!correcte){
                        int[] naixement = new int[3];
                        String naixementS = ".";
                        String id = System.console().readLine("ID del pacient: ");
                        infoPacient.add(System.console().readLine("Nom del pacient: "));
                        while (!comprovaData(naixementS, naixement)){
                            naixementS = System.console().readLine("Data de naixement: (dd-mm-yyyy) ");
                        }
                        infoPacient.add(naixement);

                        System.out.println(sep);
                        correcte = segur(id, infoPacient, pacients);
                    }
                break;
                case 3:
                    while (!comprovaData(data, dataI)){
                        System.out.println("Digues la data:(dd-mm-yyyy)");
                        data = System.console().readLine();
                    }

                    System.out.println(sep);

                    while (!comprovaHora(hora, horaI)){
                        System.out.println("Digues la hora:(hh:mm)");
                        hora = System.console().readLine();
                    }
                    LocalDateTime visita = LocalDateTime.of(dataI[2],dataI[1],dataI[0],horaI[0],horaI[1],0,00);

                    //-----------------------
                    ArrayList<Object> tepare = new ArrayList<Object>();
                    tepare.add(visita);
                    System.out.println("Digues la ID del metge: ");
                    tepare.add("1");
                    tepare.add("1");

                    visites.put(numvisita, tepare);
                    numvisita++;
                    //-----------------------
                    
                break;
                case 4:
                    System.out.println("Digues la id del metge que vulguis revisar: ");
                    String idmetge = System.console().readLine();
                    printaVisitesPerMetges(idmetge, visites, pacients, metge);
                break;
                case 5:
                    System.out.println("Metges Registrats:");
                    System.out.println();
                    printaMetges(metge);
                break;
                case 6:
                    System.out.println("Pacients Registrats:");
                    System.out.println();
                    printaPacients(pacients);
                break;

            }
        }
    }




// ---------------------------------------------------------------------------------------------------------------------

public static boolean comprovaData(String data, int dataI[]){
    if (data.matches("^((0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(19|2[0-9])[0-9]{2})$")||data.matches("^(([1-9]|[12][0-9]|3[01])-([1-9]|1[012])-(19|2[0-9])[0-9]{2})$")){
        String dataS[] = data.split("-");
        for (int i=0; i<3; i++){
            dataI[i] = Integer.parseInt(dataS[i]);
        }
        return true;
    }
    else if (data == "."){
        return false;  
    }
    System.out.println("Format Incorrecte!");
    return false;        
}

// ---------------------------------------------------------------------------------------------------------------------

    public static boolean comprovaHora(String hora, int horaI[]){
        if (hora.matches("[0-2][0-9]:[0-5][0-9]")){
            String horaS[] = hora.split(":");
            for (int i=0; i<2; i++){
                horaI[i] = Integer.parseInt(horaS[i]);
            }
            return true;
        }
        else if (hora == "."){
            return false;  
        }
        System.out.println("Format Incorrecte!");
        return false;  
    }

// ---------------------------------------------------------------------------------------------------------------------

    public static boolean segur(String id, ArrayList<Object> info, HashMap<String, ArrayList<Object>> tot){
        if (System.console().readLine("Estas segur de continuar? (si/no) ").equalsIgnoreCase("si")){
            tot.put(id, info);
            return true;
        }
        else{
            System.out.println("Metge no afegit...");
            return true;
        }
    }

    // ---------------------------------------------------------------------------------------------------------------------

    public static void printaVisitesPerMetges(String idmetge,TreeMap<Integer, ArrayList<Object>> visites,HashMap<String, ArrayList<Object>> pacients,HashMap<String, ArrayList<Object>> metge){
        visites.forEach((k,j) -> {
            System.out.println("Metge: "+metge.get(idmetge).get(0));
            if (j.get(1).equals(idmetge)){
                System.out.println("Data de visita: "+j.get(0));
                System.out.println("ID Pacient: "+j.get(2));
                System.out.println("Nom Pacient: "+pacients.get(j.get(2)).get(0));
                System.out.println("Nom Pacient: "+pacients.get(j.get(2)).get(0));
                System.out.println("Data naixement del Pacient: "+pacients.get(j.get(2)).get(1));
            }
        });
    }

    // ---------------------------------------------------------------------------------------------------------------------

    public static void printaMetges(HashMap<String, ArrayList<Object>> metge){
        metge.forEach((k,j) -> {
            System.out.println("ID Metge: "+k);
            System.out.println("Nom: "+j.get(0));
            System.out.println("Especialitat: "+j.get(1));
        });
    }

    // ---------------------------------------------------------------------------------------------------------------------

    public static void printaPacients( HashMap<String, ArrayList<Object>> pacients){
        pacients.forEach((k,j) -> {
            System.out.println("ID Pacient: "+k);
            System.out.println("Nom: "+j.get(0));
            System.out.println("Data de naixement: "+j.get(1));
        });
    }

}
