package app;

import java.time.LocalDate;
import java.util.ArrayList;

import classes.Client;
import classes.Factura;
import classes.Linia;
import classes.Producte;
import classes.functions.Functions;

public class App {
    static String sep = "------------------------------------------------------------------------------";

    public static void main(String[] args) throws Exception {

        ArrayList<Client> clients = new ArrayList<Client>();
        ArrayList<Producte> productes = new ArrayList<Producte>();
        ArrayList<Factura> factures = new ArrayList<Factura>();

        float total = 0;
        float iva = 0;
        int numFac = 0;
        boolean acabaPrograma = false;
        while (!acabaPrograma) {
            Functions.menu();
            String opcioMenu = System.console().readLine("   - ");

            switch (opcioMenu) {
            case "0":
                String infoClient[] = { "Nico", "Esteban", "123456789V", "602393073", "Tona", LocalDate.now().toString() };
                System.out.println(sep);
                do {
                    System.out.println("   Introduce el DNI del cliente: (0 para salir) ");
                    infoClient[2] = System.console().readLine("   - ");
                    if (infoClient[2].equals("0")) {
                        break;
                    }
                } while (!Functions.dniCorrecte(clients, infoClient[2]) || !Functions.dniRepetit(clients, infoClient[2]));

                System.out.println("   Introduce el NOMBRE del cliente: ");
                infoClient[0] = System.console().readLine("   - ");
                System.out.println("   Introduce el APELLIDO del cliente: ");
                infoClient[1] = System.console().readLine("   - ");

                String dataN;
                do {
                    System.out.println("   Introduce la FECHA de NACIMIENTO del cliente: ");
                    dataN = System.console().readLine("   - ");
                } while (!Functions.dataCorrecte(infoClient[5]));

                do {
                    System.out.println("   Introduce el TELÉFONO del cliente: ");
                    infoClient[3] = System.console().readLine("   - ");
                } while (!Functions.telCorrecte(infoClient));

                System.out.println("   Introduce el POBLACIÓN del cliente: ");
                infoClient[4] = System.console().readLine("   - ");

                Client introduintClient = new Client(infoClient[0], infoClient[1], infoClient[2], infoClient[3],infoClient[4], Functions.posarDataBe(dataN, infoClient));
                clients.add(introduintClient);
                break;
            case "1":
                System.out.println(sep);
                System.out.println("\t- REGISTRO DE CLIENTES");
                Functions.mostraClients(clients);
                System.console().readLine("Presiona cualquier tecla para continurar... ");
                break;

            case "2":
                String[] idInom = { "L1234", "Peras", "0", "20" };
                boolean sortir = false;
                while (!sortir) {
                    do {
                        System.out.println(sep);
                        System.out.println("Escoje la ID del producto a introducir: (EJEMPLO = L1234) (0 para salir) ");
                        idInom[0] = System.console().readLine("   - ");
                        if (idInom[0].equals("0")) {
                            sortir = true;
                            break;
                        }
                    } while (!Functions.IdProducte(idInom));
                    if (idInom[0].equals("0")) {
                        break;
                    }
                    if (Functions.existeixProducte(productes, idInom)) {
                        System.out.println("Escoje el nombre del producto:");
                        idInom[1] = System.console().readLine("   - ");

                        do {
                            System.out.println("Escoje el stock disponible del producto: ");
                            idInom[2] = System.console().readLine("   - ");
                        } while (!Functions.stockProducte(idInom[2]));

                        do {
                            System.out.println("Escoje el precio por unidad del producto: ");
                            idInom[3] = System.console().readLine("   - ");
                        } while (!Functions.preuProducte(idInom));

                        Producte introduintProducte = new Producte(idInom[0], idInom[1], Integer.parseInt(idInom[2]), Float.parseFloat(idInom[3]));
                        productes.add(introduintProducte);
                    } else {

                        do {
                            System.out.println("Escoje el stock que quieres añadir al producto: ");
                            idInom[2] = System.console().readLine("   - ");
                        } while (!Functions.stockProducte(idInom[2]));
                        for (Producte info : productes) {
                            if (info.getId().equalsIgnoreCase(idInom[0])) {
                                info.sumarStock(Integer.parseInt(idInom[2]));
                            }
                        }
                    }
                }
                break;
            case "3":
                System.out.println(sep);
                System.out.println("\t- REGISTRO DE PRODUCTOS");
                Functions.mostraProductes(productes);
                System.console().readLine("Presiona cualquier tecla para continurar... ");
                break;
            case "4":
                boolean productesAfegits = false;
                ArrayList<Linia> linies = new ArrayList<Linia>();
                String[] infoCompra = { "L2031", "20", "DNI", "PreuDeLinia" };
                System.out.println(sep);
                System.out.println("\t- BIENVENIDO CLIENTE");
                do {
                    System.out.println("Escribe tu DNI: (0 para salir)");
                    infoCompra[2] = System.console().readLine("   - ");
                    if (infoCompra[2].equals("0")) {
                        break;
                    }
                } while (!Functions.dniCorrecte(clients, infoCompra[2]));
                if (infoCompra[2].equals("0")) {
                    break;
                }
                Client clientActual = Functions.aconseguirClient(clients, infoCompra);
                boolean cumple = Functions.cumple(clientActual);

                if (Functions.dniCorrecte(clients, infoCompra[2])) {
                    String salir = "-";
                    while (salir != "0") {
                        System.out.println("---");
                        System.out.println("Productes existents:");
                        System.out.println();
                        Functions.mostraProductes(productes);
                        System.out.println("---");
                        do {
                            System.out.println("Di el ID del producto que queras adquirir: (0 para acabar la compra)");

                            infoCompra[0] = System.console().readLine("   - ");
                            if (infoCompra[0].equals("0")) {
                                salir = "0";
                                break;
                            }
                        } while (!Functions.IdProducte(infoCompra) && Functions.existeixProducte(productes, infoCompra));

                        if (infoCompra[0].equals("0")) {
                            break;
                        }

                        boolean wala = false;
                        do {
                            System.out.println("Di la cantidad que quieres adquirir: ");
                            infoCompra[1] = System.console().readLine("   - ");

                            for (Producte pere : productes) {
                                if (pere.getId().equals(infoCompra[0])) {
                                    if (Integer.parseInt(infoCompra[1]) <= pere.getStock()) {
                                        infoCompra[3] = String.valueOf(Float.parseFloat(infoCompra[1]) * pere.getPreu());
                                        wala = true;
                                    }
                                }
                            }
                            System.out.println("Stock exscesivo...");

                        } while (!Functions.stockProducte(infoCompra[1]) && !wala);

                        for (Producte info : productes) {
                            if (info.getId().equalsIgnoreCase(infoCompra[0])) {
                                info.restarStock(Integer.parseInt(infoCompra[1]));
                            }
                        }

                        for (Producte produ : productes) {
                            if (produ.getId().equalsIgnoreCase(infoCompra[0])) {
                                Linia producteEscollit = new Linia(produ, Integer.parseInt(infoCompra[1]), Float.parseFloat(infoCompra[3]));
                                linies.add(producteEscollit);
                                productesAfegits = true;
                            }
                        }
                    }

                    if (productesAfegits == true) {
                        Factura facturA = new Factura(String.valueOf(numFac), LocalDate.now(), linies, clientActual);
                        factures.add(facturA);

                        Functions.printaFatura(clientActual);
                        Functions.printaLinias(facturA, productes, total, iva, cumple);
                        System.out.println(sep);

                        numFac++;
                    } else if (productesAfegits == false) {
                        System.out.println("No has agafat cap producte...");
                    }
                } else {
                    System.out.println("Este DNI no existe, rgistrate antes por vavor...");
                    break;
                }
                break;
            case "5":
                cumple = false;
                Functions.mostraFacturas(factures, productes, total, iva, cumple);
                System.console().readLine("Presiona cualquier tecla para continurar... ");
                break;
            case "6":
                cumple = false;
                String dataFac = "0";
                String dni = ".";
                do {
                    System.out.println("   Introduce el DNI del cliente: (0 para salir) ");
                    dni = System.console().readLine("   - ");
                    if (dni.equals("0")) {
                        break;
                    }
                } while (!Functions.dniCorrecte(clients, dni) && Functions.dniRepetit(clients, dni));
                do {
                    System.out.println("   Introduce la FECHA de la FACTURA: ");
                    dataFac = System.console().readLine("   - ");
                } while (Functions.dataCorrecte(dataFac));

                Functions.mostraFacturasBusqueda(factures, productes, dni, total, iva, cumple, dataFac);
                System.console().readLine("Presiona cualquier tecla para continurar... ");

                break;
            case "7":
                cumple = false;
                // Factura hoy
                System.out.println(sep);
                System.out.println("FACTURAS DE HOY");
                Functions.mostraFacturasHoy(factures, productes, total, iva, cumple);
                System.console().readLine("Presiona cualquier tecla para continurar... ");

                break;
            case "8":
                cumple = false;
                System.out.println(sep);
                System.out.println("RESUMEN DE HOY");
                System.out.println(sep);
                Functions.mostraFacturasHoy(factures, productes, total, iva, cumple);
                System.console().readLine("Presiona cualquier tecla para continurar... ");
                acabaPrograma = true;
                System.out.println(sep);
                break;
            default:
                System.out.println("Tu ets tontu...");
                break;
            }
        }

    }

}