package app;

import java.util.ArrayList;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws Exception {
        String sep1 = "--------------------------------------------------------------------------------------------------------------------";

        ArrayList<LocalDate> fecha = new ArrayList<LocalDate>();

        ArrayList<ArrayList<String>> recordatorios = new ArrayList<ArrayList<String>>();
        ArrayList<String> titulo = new ArrayList<String>();
        ArrayList<String> cuerpo = new ArrayList<String>();

        recordatorios.add(titulo);
        recordatorios.add(cuerpo);

        LocalDate esteMes = LocalDate.now();


        boolean sortir = false;
        boolean correcte = false;
        int opcioMenu = 0;


        while (!sortir){

            presentacion(sep1, esteMes);
            printaMes(fecha, sep1, esteMes);
            menu(sep1);
            
            correcte = false;
            while (!correcte){
                opcioMenu = Integer.parseInt(System.console().readLine("Selecciona una opción: "));
                if (opcioMenu >= 1 && opcioMenu <= 5){
                    correcte = true;
                }
                else {
                    System.out.println(sep1);
                    System.out.println("   OPCIÓN INCORRECTA!!!");
                    System.out.println(sep1);
                    menu(sep1);
                }
            }

            switch(opcioMenu){
            case 1:
                System.out.println(sep1);
                String fechaA = System.console().readLine("Escoge la fecha: (YYYY-MM-DD) ");
                esteMes = LocalDate.parse(fechaA);


            break;
            case 2:
                System.out.println(sep1);

                for (int i=0; i<fecha.size(); i++){
                    if (fecha.get(i).equals(esteMes)){
                        System.out.println("Día: "+esteMes.getDayOfMonth()+" - "+recordatorios.get(0).get(i));
                        System.out.println("   "+recordatorios.get(1).get(i));
                        System.out.println();
                        System.out.println();

                    }
                } 
                System.console().readLine("Presiona ENTER para continuar...");
                System.out.println(sep1);
            break;
            case 3:
                printaNotesMes(sep1, fecha, recordatorios, esteMes);
                System.console().readLine("Presiona ENTER para continuar...");
            break;
            case 4:
                recordatorios.get(0).add(System.console().readLine("Escribe el título: "));
                recordatorios.get(1).add(System.console().readLine("Escribe la nota: "));
                fecha.add(esteMes);
            break;
            case 5:
                printaNotesMes(sep1, fecha, recordatorios, esteMes);
                String temporal = "0";

                temporal = System.console().readLine("Escribe el título: ");

                for (int i=0; i<fecha.size(); i++){
                    if (recordatorios.get(0).get(i).equals(temporal)){
                        recordatorios.get(0).remove(i);
                        recordatorios.get(1).remove(i);
                        fecha.remove(i);
                    }
                }





            break;
            case 6:
                sortir = true;
            break;
            }
        }





    }

    //-------------------------------------------------------------------------------------------------------------------------

    public static void presentacion(String sep1, LocalDate esteMes) {
        System.out.println(sep1);
        System.out.println("   Bienvenido a tu agenda de confianza!!!!");
        System.out.println("   By: Mark Zuck\tFecha:  " + esteMes);
        System.out.println(sep1);
    }

    //-------------------------------------------------------------------------------------------------------------------------

    public static void printaMes(ArrayList<LocalDate> fecha, String sep1,  LocalDate esteMes) {
        LocalDate esteMes1 = esteMes;
        LocalDate seleccion = LocalDate.of(1900, 01, 01);
        boolean sortit = false;
        boolean record = false;
        int compta = 1;

        esteMes = esteMes.minusDays(esteMes.getDayOfMonth());

        do {
            esteMes = esteMes.plusDays(1);
            if (esteMes.getMonthValue() != esteMes1.getMonthValue()) {
                System.out.println();
                sortit = true;
            }
            if (!sortit) {
                record = false;

                for (LocalDate ldt:fecha){
                    if (ldt.equals(esteMes)){
                        record = true;
                        seleccion = ldt;
                        break;
                    }
                }

                if ((esteMes.getDayOfMonth()==esteMes1.getDayOfMonth()) && (record==true) && (esteMes.getDayOfMonth()==seleccion.getDayOfMonth())){
                    System.out.print("     [-" + esteMes.getDayOfMonth()+"-]");
                }
                else if ((record==true)){
                    System.out.print("     -" + esteMes.getDayOfMonth()+"-");
                }
                else if(esteMes.getDayOfMonth()==esteMes1.getDayOfMonth()){
                    System.out.print("     [" + esteMes.getDayOfMonth()+"]");
                }
                else {
                    System.out.print("\t" + esteMes.getDayOfMonth());
                }
            }
            if (compta == 7) {
                System.out.println();
                System.out.println();
                compta = 0;
            }
            compta++;
        } while (!sortit);
        System.out.println(sep1);
    }

    //-------------------------------------------------------------------------------------------------------------------------

    public static void menu(String sep1) {
        System.out.println("   1. Cambiar de fecha");
        System.out.println("   2. Ver notas de el día");
        System.out.println("   3. Ver notas de el mes");
        System.out.println("   4. Añadir una nota");
        System.out.println("   5. Eliminar una nota");
        System.out.println("   6. Salir");
        System.out.println(sep1);
    }

    //-------------------------------------------------------------------------------------------------------------------------


    public static void printaNotesMes(String sep1, ArrayList<LocalDate> fecha, ArrayList<ArrayList<String>> recordatorios, LocalDate esteMes) {
        System.out.println(sep1);
        for (int i=0; i<fecha.size(); i++){
            LocalDate dataTemporal = fecha.get(i);
            if (dataTemporal.getMonthValue()== esteMes.getMonthValue()){
                System.out.println("Día: "+dataTemporal.getDayOfMonth()+" - "+recordatorios.get(0).get(i));
                System.out.println("   "+recordatorios.get(1).get(i));
                System.out.println();
                System.out.println();

            }
        } 
        System.out.println(sep1);
    }





}