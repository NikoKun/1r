package classes.functions;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import classes.Client;
import classes.Factura;
import classes.Linia;
import classes.Producte;

public class Functions {
    static String pattern = "###,###.##";
    static DecimalFormat format = new DecimalFormat(pattern);
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
        System.out.println("|       6 - Mostar Facturas de un Cliente                      |");
        System.out.println("|       7 - Mostrar Facturas de Hoy                            |");
        System.out.println("|--------------------------------------------------------------|");
        System.out.println("|       8 - SORTIR                                             |");
        System.out.println("|--------------------------------------------------------------|");
    }

    public static boolean dniCorrecte(ArrayList<Client> clients, String infoClient) {
        if (!infoClient.matches("[0-9]{9}[A-Za-z]")) {
            System.out.println("   Formato incorrecto!");
            System.out.println(sep);
            return false;
        }
        return true;
    }

    public static boolean dniRepetit(ArrayList<Client> clients, String infoClient) {
        for (Client info : clients) {
            if (info.getDni().equalsIgnoreCase(infoClient)) {
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
            System.out.println("   - DNI: " + info.getDni());
            System.out.println("      Nombre: " + info.getNom());
            System.out.println("      Apellido: " + info.getCognom());
            System.out.println("      Fecha de nacimiento: " + info.getCumple().getDayOfMonth() + "-"
                    + info.getCumple().getMonthValue() + "-" + info.getCumple().getYear());
            System.out.println("      Teléfono: " + info.getTel());
            System.out.println("      Población: " + info.getPoblacio());
            System.out.println();
        }
        System.out.println(sep);
    }

    public static boolean IdProducte(String[] idInom) {
        if (!idInom[0].matches("[A-Za-z][0-9]{4}")) {
            if (!idInom[0].equals("0")) {
                System.out.println("   Formato incorrecto!");
                System.out.println(sep);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public static boolean existeixProducte(ArrayList<Producte> productes, String[] idInom) {
        for (Producte info : productes) {
            if (info.getId().equalsIgnoreCase(idInom[0])) {
                if (!idInom[0].equals("0")) {
                    System.out.println("   Esta ID de PRODUCTO es existent...");
                    System.out.println(sep);
                    return false;
                }
                return true;
            }
        }
        System.out.println("La ID de PRODUCTO no es existente...");
        return true;
    }

    public static boolean stockProducte(String idInom) {
        if (!idInom.matches("[0-9]+")) {
            System.out.println("   Formato incorrecto!");
            return false;
        }
        return true;
    }

    public static boolean preuProducte(String[] idInom) {
        if (Float.parseFloat(idInom[3]) < 0.01f) {
            System.out.println("   Formato incorrecto!");
            return false;
        }
        return true;
    }

    public static void mostraProductes(ArrayList<Producte> productes) {
        for (Producte info : productes) {
            System.out.println();
            System.out.println("   - ID Producte: " + info.getId());
            System.out.println("      Desc: " + info.getNomProducte());
            System.out.println("      Stock: " + info.getStock() + " unidades");
            System.out.println("      Precio/Unidad: " + info.getPreu() + "€/u");
            System.out.println();
        }
        System.out.println(sep);
    }

    public static Client aconseguirClient(ArrayList<Client> clients, String[] infoCompra) {
        Client clientAescollir = new Client("null", "null", "null", "null", "null", LocalDate.now());
        for (Client info : clients) {
            if (info.getDni().equals(infoCompra[2])) {
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

    public static boolean stockCorrecte(String[] infoCompra, ArrayList<Producte> productes) {
        for (Producte pere : productes) {
            if (pere.getId().equals(infoCompra[0])) {
                if (Integer.parseInt(infoCompra[1]) <= pere.getStock()) {
                    infoCompra[3] = String.valueOf(Float.parseFloat(infoCompra[1]) * pere.getPreu());
                    return true;
                }
            }
        }
        System.out.println("Stock exscesivo...");
        return false;
    }

    public static boolean dataCorrecte(String infoClient) {
        if (infoClient.matches("^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
            return true;
        }
        System.out.println("---");
        return false;
    }

    public static LocalDate posarDataBe(String dataN, String[] infoClient) {
        String[] dataCompleta = dataN.split("-");
        // infoClient[5] = String.valueOf()+"-"+String.valueOf()+"-"+String.valueOf();
        LocalDate ara = LocalDate.of(Integer.parseInt(dataCompleta[2]), Integer.parseInt(dataCompleta[1]),
                Integer.parseInt(dataCompleta[0]));
        return ara;
    }

    public static boolean cumple(Client clientActual) {
        if (clientActual.getCumple().getDayOfMonth() == LocalDate.now().getDayOfMonth() && clientActual.getCumple().getMonthValue() == LocalDate.now().getMonthValue() ) {
            System.out.println(sep);
            System.out.println("HOY ES TU CUMPLEAÑOS!!!!!!!!!!!");
            System.out.println("Recuerda que tienes un 10% de descuento en todos los productos!!!!");
            System.console().readLine("Presiona cualquier tecla para continurar... ");
            System.out.println(sep);
            return true;
        }
        return false;
    }
    public static boolean cumpleS(Client clientActual) {
        if (clientActual.getCumple().getDayOfMonth() == LocalDate.now().getDayOfMonth() && clientActual.getCumple().getMonthValue() == LocalDate.now().getMonthValue() ) {
            return true;
        }
        return false;
    }
    public static void printaLinias(Factura facturA, ArrayList<Producte> productes, float total, float iva, boolean cumple) {
        total = 0;
        iva = 0;
        for (Producte actualP : productes) {
            for (Linia actualL : facturA.getLinies()) {
                if (actualP.getId().equals(actualL.getProducte().getId())) {
                    System.out.println();
                    System.out.println(" - ID producte: " + actualP.getId());
                    System.out.println("    NOM: " + actualP.getNomProducte() + "\t" + "Quantitat: "
                            + actualL.getQuantitat() + "\tPreufinal: " +format.format(actualL.getProducte().getPreu()) + "€");
                    System.out.println();
                    total = total + actualL.getPreuFinal();
                    iva = iva + (actualL.getPreuFinal()*0.21f);
                }
            }
        }
        if (cumple == true){
            float descompte = total * 0.1f;
            total = total - descompte;
            iva = total * 0.21f;
            System.out.println(" ---");
            System.out.println("HOY ES TU CUMPLE!!!");
            System.out.println("Te hemos aplicado un descuento de el 10%");
            System.out.println("Te has ahorrado "+format.format(descompte)+"€");
        }
        System.out.println(" ---");
        System.out.println("   Recuento sin IVA: "+format.format(total - iva)+"€");
        System.out.println("   IVA: "+format.format(iva)+"€");
        System.out.println("   Total: "+format.format(total)+"€");

    }

    public static void mostraFacturas(ArrayList<Factura> factures, ArrayList<Producte> productes, float total, float iva, boolean cumple) {
        System.out.println(sep);
        for (Factura totes : factures) {
            cumple = Functions.cumpleS(totes.getClient());
            total = 0;
            iva = 0;
            System.out.println();
            System.out.println("  - ID Factura: " + totes.getId());
            System.out.println("      Data: " + totes.getData().getDayOfMonth() + "-" + totes.getData().getMonth() + "-"+ totes.getData().getYear());
            System.out.println("      Client : " + totes.getClient().getNom() + " (Amb DNI: " + totes.getClient().getDni() + " )");
            for (Linia actualL : totes.getLinies()) {
                for (Producte actualP : productes) {
                    if (actualP.getId().equals(actualL.getProducte().getId())) {
                        System.out.println();
                        System.out.println("     - ID Producte: " + actualP.getId());
                        System.out.println("        NOM: " + actualP.getNomProducte() + "\t" + "Quantitat: "
                                + actualL.getQuantitat() + "\tPreufinal: " + format.format(actualL.getProducte().getPreu()) + "€");
                        System.out.println();
                        total = total + actualL.getPreuFinal();
                        iva = iva + (actualL.getPreuFinal()*0.21f);
                    }
                }
            } 
            if (totes.getData().getDayOfMonth() == totes.getClient().getCumple().getDayOfMonth() && totes.getData().getMonth() == totes.getClient().getCumple().getMonth()){
                float descompte = total * 0.1f;
                total = total - descompte;
                iva = total * 0.21f;
                System.out.println("");
                System.out.println("HOY ES TU CUMPLE!!!");
                System.out.println("Te hemos aplicado un descuento de el 10%");
                System.out.println("Te has ahorrado "+format.format(descompte)+"€");
                System.out.println("");
            }
            System.out.println("   Recuento sin IVA: "+format.format(total - iva)+"€");
            System.out.println("   IVA: "+format.format(iva)+"€");
            System.out.println("   Total: "+format.format(total)+"€");
            System.out.println(sep);
        }
    }





    public static void printaFatura(Client clientActual) {
        System.out.println(sep);
        System.out.println("FACTURA ------------------------------------------");
        System.out.println(" - Adquisidor ");
        System.out.println("   DNI: " + clientActual.getDni());
        System.out.println("   Nombre: " + clientActual.getNom());
        System.out.println("   Apellido: " + clientActual.getCognom());
        System.out.println("   Población: " + clientActual.getPoblacio());
        System.out.println("   Teléfono: " + clientActual.getTel());
        System.out.println("   Fecha de nacimiento: " + clientActual.getCumple());
        System.out.println("---");
        System.out.println("   Productes adquirits: ");
        System.out.println("---");
    }

    public static void mostraFacturasHoy(ArrayList<Factura> factures, ArrayList<Producte> productes, float total, float iva, boolean cumple) {
        System.out.println(sep);
        for (Factura totes : factures) {
            cumple = Functions.cumpleS(totes.getClient());
            total = 0;
            iva = 0;
            if (totes.getData().equals(LocalDate.now())) { 
                System.out.println();
                System.out.println("  - ID Factura: " + totes.getId());
                System.out.println("      Data: " + totes.getData().getDayOfMonth() + "-" + totes.getData().getMonth()
                        + "-" + totes.getData().getYear());
                System.out.println("      Client : " + totes.getClient().getNom() + " (Amb DNI: "
                        + totes.getClient().getDni() + " )");
                if (totes.getData().getDayOfMonth() == totes.getClient().getCumple().getDayOfMonth() && totes.getData().getMonth() == totes.getClient().getCumple().getMonth()){
                    System.out.println();
                    System.out.println("HOY ES TU CUMPLE!!!");
                    System.out.println("En esta factura se aplicó un descuento del 10%");
                    System.out.println();
                }
                for (Linia actualL : totes.getLinies()) {
                    for (Producte actualP : productes) {
                        if (actualP.getId().equals(actualL.getProducte().getId())) {
                            System.out.println();
                            System.out.println(" - ID producte: " + actualP.getId());
                            System.out.println("    NOM: " + actualP.getNomProducte() + "\t" + "Quantitat: "
                                    + actualL.getQuantitat() + "\tPreufinal: " + format.format(actualL.getProducte().getPreu()) + "€");
                            System.out.println();
                            total = total + actualL.getPreuFinal();
                            iva = iva + (actualL.getPreuFinal()*0.21f);
                        }
                    }
                }
                System.out.println(sep);
            }
        }
        System.out.println(sep);
    }

    public static void mostraFacturasBusqueda(ArrayList<Factura> factures, ArrayList<Producte> productes, String dni, float total, float iva, boolean cumple, String dataFac) {
        System.out.println(sep);
        String[] dataSplit = dataFac.split("-");
        LocalDate daataFactura = LocalDate.of(Integer.parseInt(dataSplit[2]), Integer.parseInt(dataSplit[1]), Integer.parseInt(dataSplit[0]));


        for (Factura totes : factures) {
            total = 0;
            iva = 0;
            if (dni.equals(totes.getClient().getDni()) && (totes.getData().equals(daataFactura))){
                System.out.println();
                System.out.println("  - ID Factura: " + totes.getId());
                System.out.println("      Data: " + totes.getData().getDayOfMonth() + "-" + totes.getData().getMonth()
                        + "-" + totes.getData().getYear());
                System.out.println("      Client : " + totes.getClient().getNom() + " (Amb DNI: "+ totes.getClient().getDni() + " )");
                if (totes.getData().getDayOfMonth() == totes.getClient().getCumple().getDayOfMonth() && totes.getData().getMonth() == totes.getClient().getCumple().getMonth()){
                    System.out.println();
                    System.out.println("HOY ES TU CUMPLE!!!");
                    System.out.println("En esta factura se aplicó un descuento del 10%");
                    System.out.println();
                }
                for (Linia actualL : totes.getLinies()) {
                    for (Producte actualP : productes) {
                        if (actualP.getId().equals(actualL.getProducte().getId())) {
                            System.out.println();
                            System.out.println("       - ID producte: " + actualP.getId());
                            System.out.println("          NOM: " + actualP.getNomProducte() + "\t" + "Quantitat: "
                                    + actualL.getQuantitat() + "\tPreufinal: " + format.format(actualL.getProducte().getPreu()) + "€");
                            System.out.println();
                        }
                    }
                }
            }
        }
        System.out.println(sep);
    }

}