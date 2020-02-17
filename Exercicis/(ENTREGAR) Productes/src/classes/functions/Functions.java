package classes.functions;

import java.time.LocalDate;
import java.util.ArrayList;

import classes.Client;
import classes.Producte;

public class Functions {
    static String sep = "------------------------------------------------------------------------------";

    public static void menu() {
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|                   BIENVENIDO A MERCA-TONA                    |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|       0 - Introduce a un Cliente                             |");
        System.out.println("|       1 - Mostar Todos los Clientes                          |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|       2 - Añadir Stock                                       |");
        System.out.println("|       3 - Mostrar Sock                                       |");
        System.out.println("|       4 - Realizar una Compra                                |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|       5 - Mostar Todas las Facturas                          |");
        System.out.println("|       6 - Mostar Facturas Antiguas                           |");
        System.out.println("|       7 - Mostrar Facturas de Hoy                            |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|       8 - SORTIR                                             |");
        System.out.println("|--------------------------------------------------------------|");
    }

    public static boolean dniCorrecte(ArrayList<Client> clients, String[] infoClient) {
        if (!infoClient[2].matches("[0-9]{9}[A-Za-z]")) {
            System.out.println("   Formato incorrecto!");
            System.out.println(sep);
            return false;
        }
        return true;
    }

    public static boolean dniRepetit(ArrayList<Client> clients, String[] infoClient) {
        for (Client info : clients) {
            if (info.getDni().equalsIgnoreCase(infoClient[2])){
                System.out.println("   Este DNI ya existe...");
                System.out.println(sep);
                return false;
            }
        }
        return true;
    }

    public static boolean telCorrecte(String[] infoClient) {
        if (!infoClient[3].matches("[0-9]{9}")) {
            System.out.println("   Formato incorrecto!");
            System.out.println(sep);
            return false;
        }
        return true;
    }


    public static void mostraClients(ArrayList<Client> clients) {
        System.out.println(sep);
        for (Client info : clients) {
            System.out.println();
            System.out.println("   - DNI: "+info.getDni());
            System.out.println("      Nombre: "+info.getNom());
            System.out.println("      Apellido: "+info.getCognom());
            System.out.println("      Fecha de nacimiento: "+info.getCumple().getDayOfMonth()+"-"+info.getCumple().getMonthValue()+"-"+info.getCumple().getYear());
            System.out.println("      Teléfono: "+info.getTel());
            System.out.println("      Población: "+info.getPoblacio());
            System.out.println();
        }
    }


    public static boolean IdProducte(String[] idInom){
        if (!idInom[0].matches("[A-Za-z][0-9]{4}")) {
            System.out.println("   Formato incorrecto!");
            System.out.println(sep);
            return false;
        }
        return true;
    }

    public static boolean existeixProducte(ArrayList<Producte> productes, String[] idInom){
        for (Producte info : productes) {
            if (info.getId().equalsIgnoreCase(idInom[0])){
                System.out.println("   Esta ID de PRODUCTO es existent...");
                System.out.println(sep);
                return false;
            }
        }
        System.out.println("La ID de PRODUCTO no es existente...");
        return true;
    }

    public static boolean stockProducte(String idInom){
        if (!idInom.matches("[0-9]+")){
            System.out.println("   Formato incorrecto!");
            return false;
        }
        return true;
    }

    public static boolean preuProducte(String[] idInom){
        if (!idInom[3].matches("[0-9]+")){
            System.out.println("   Formato incorrecto!");
            return false;
        }
        return true;
    }


    public static void mostraProductes(ArrayList<Producte> productes){
        for (Producte info:productes){
            System.out.println();
            System.out.println("   - ID Producte: "+info.getId());
            System.out.println("      Desc: "+info.getNomProducte());
            System.out.println("      Stock: "+info.getStock()+" unidades");
            System.out.println("      Precio/Unidad: "+info.getPreu()+"€/u");
            System.out.println();
        }
    }

    public static Client aconseguirClient(ArrayList<Client> clients, String[] infoCompra){
        Client clientAescollir = new Client("null", "null", "null", "null", "null", LocalDate.now());
        for (Client info:clients){
            if (info.getDni().equals(infoCompra[2])){
                clientAescollir.setNom(info.getNom());
                clientAescollir.setCognom(info.getCognom());
                clientAescollir.setDni(info.getDni());
                clientAescollir.setCumple(info.getCumple());
                clientAescollir.setPoblacio(info.getPoblacio());
                clientAescollir.setTel(info.getTel());
                return clientAescollir;
            }
        }
        System.out.println("Esto no puede ser................");
        return clientAescollir;
    }

    public static boolean stockCorrecte(String[] infoCompra,ArrayList<Producte> productes){
        for (Producte pere:productes){
            if (pere.getId().equals(infoCompra[0])) {
                if (Integer.parseInt(infoCompra[1]) <= pere.getStock()){
                    infoCompra[3] = String.valueOf(Integer.parseInt(infoCompra[1]) * pere.getPreu());
                    return true;
                }
            }
        }
        System.out.println("Stock exscesivo...");
        return false;
    }


    public static void restarStock(String[] infoCompra,ArrayList<Producte> productes){
        for (Producte info : productes) {
            if (info.getId().equalsIgnoreCase(infoCompra[2])){
                info.restaStock(Integer.parseInt(infoCompra[1]));
            }
        }
    }



    public static boolean dataCorrecte(String[] infoClient){
        if (infoClient[5].matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")){
            return true;
        }
        return false;
    }


    public static void posarDataBé(String dataN,String[] infoClient){
        String [] dataCompleta = dataN.split("-");
        infoClient[5] = String.valueOf(dataCompleta[2])+"-"+String.valueOf(dataCompleta[1])+"-"+String.valueOf(dataCompleta[0]);
    }



    public static boolean cumple(Client clientActual){
        if (clientActual.getCumple().equals(LocalDate.now())){
            System.out.println(sep);
            System.out.println("HOY ES TU CUMPLEAÑOS!!!!!!!!!!!");
            System.out.println("Recuerda que tienes un 10% de descuento en todos los productos!!!!");
            System.console().readLine("Presiona cualquier tecla para continurar... ");
            System.out.println(sep);
            return true;
        }
        return false;
    }

}