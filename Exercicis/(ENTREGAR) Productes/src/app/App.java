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

        // Client --- Strinhg: nom, cognom, dni, tel, poblacio

        // Factura --- String id
        //              LocalDateTime data
        //              ArrayList<Linia> linies = new ArrayList<Linia>()
        //              Client client

        // Linia --- Producte producte
        //              int quantitat, preuFinal

        // Producte --- String id, nomProducte
        //              int stock

        ArrayList<Client> clients = new ArrayList<Client>();
        ArrayList<Producte> productes = new ArrayList<Producte>();

        ArrayList<Factura> factures = new ArrayList<Factura>();

        boolean acabaPrograma = false;
        while (!acabaPrograma) {
            Functions.menu();
            String opcioMenu = System.console().readLine("   - ");

            switch (opcioMenu) {
            case "0":
                String infoClient[] = {"Nico","Esteban","123456789V","602393073","Tona", LocalDate.now().toString()};

                System.out.println(sep);
                do {
                    do {
                        System.out.println("   Introduce el DNI del cliente: (0 para salir) ");
                        infoClient[2] = System.console().readLine("   - ");
                        if (infoClient[2].equals("0")){
                            break;
                        }
                    }while (!Functions.dniCorrecte(clients, infoClient));
                }while (!Functions.dniRepetit(clients, infoClient));

                System.out.println("   Introduce el NOMBRE del cliente: ");
                infoClient[0] = System.console().readLine("   - ");
                System.out.println("   Introduce el APELLIDO del cliente: ");
                infoClient[1] = System.console().readLine("   - ");
                
                String dataN;
                do {
                    System.out.println("   Introduce la FECHA de NACIMIENTO del cliente: ");
                    dataN = System.console().readLine("   - ");
                }while (!Functions.dataCorrecte(infoClient));

                Functions.posarDataBé(dataN, infoClient);

                do {
                    System.out.println("   Introduce el TELÉFONO del cliente: ");
                    infoClient[3] = System.console().readLine("   - ");
                }while (!Functions.telCorrecte(infoClient));

                System.out.println("   Introduce el POBLACIÓN del cliente: ");
                infoClient[4] = System.console().readLine("   - ");



                Client introduintClient = new Client(infoClient[0], infoClient[1], infoClient[2], infoClient[3], infoClient[4], LocalDate.parse(infoClient[5]));
                clients.add(introduintClient);
            break;
            case "1":
                System.out.println(sep);
                System.out.println("\t- REGISTRO DE CLIENTES");
                Functions.mostraClients(clients);
            break;
            case "2":
                String[] idInom = {"L1234", "Peras", "0", "20"};
                do {
                    System.out.println("Escoje la ID del producto a introducir: (EJEMPLO = L1234) ");
                    idInom[0] = System.console().readLine("   - ");
                }while(!Functions.IdProducte(idInom));

                if (Functions.existeixProducte(productes, idInom)){
                    System.out.println("Escoje el nombre del producto:");
                    idInom[1] = System.console().readLine("   - ");
    
                    do {
                        System.out.println("Escoje el stock disponible del producto: ");
                        idInom[2] = System.console().readLine("   - ");
                    }while(!Functions.stockProducte(idInom[2]));
    
                    do {
                        System.out.println("Escoje el precio por unidad del producto: ");
                        idInom[3] = System.console().readLine("   - ");
                    }while(!Functions.preuProducte(idInom));
    
                    Producte introduintProducte = new Producte(idInom[0], idInom[1], Integer.parseInt(idInom[2]), Integer.parseInt(idInom[3]));
                    productes.add(introduintProducte);
                }
                else {
                    do {
                        System.out.println("Escoje el stock que quieres añadir al producto: ");
                        idInom[2] = System.console().readLine("   - ");
                    }while(!Functions.stockProducte(idInom[2]));
                    for (Producte info : productes) {
                        if (info.getId().equalsIgnoreCase(idInom[0])){
                            info.sumarStock(Integer.parseInt(idInom[2]));
                        }
                    }
                }

            break;
            case "3":
                System.out.println(sep);
                System.out.println("\t- REGISTRO DE PRODUCTOS");
                Functions.mostraProductes(productes);
            break;
            case "4":
                ArrayList<Linia> linies = new ArrayList<Linia>();
                String[] infoCompra = {"L2031","20","DNI","PreuDeLinia"};
                System.out.println(sep);
                System.out.println("\t- BIENVENIDO CLIENTE");

                do {
                    System.out.println("Escribe tu DNI: (0 para salir)");
                    infoCompra[2] = System.console().readLine("   - ");
                    if (infoCompra[2].equals("0")){
                        break;
                    }
                }while (!Functions.dniCorrecte(clients, infoCompra));
                Client clientActual = Functions.aconseguirClient(clients,infoCompra);
                
                boolean cumple = Functions.cumple(clientActual);

                if (Functions.dniCorrecte(clients, infoCompra)){
                        String salir = "-";

                        while (salir != "0"){
                            System.out.println("---");
                            System.out.println("Productes existents:");
                            System.out.println();
                            Functions.mostraProductes(productes);
                            System.out.println("---");
                            do {
                                do {
                                    System.out.println("Di el ID del producto que queras adquirir: (0 para salir)");
                                    if (salir == "0"){
                                        break;
                                    }
                                    infoCompra[0] = System.console().readLine("   - ");

                                }while(!Functions.IdProducte(infoCompra));
                                if (salir == "0"){
                                    break;
                                }

                                }while(Functions.existeixProducte(productes, infoCompra));

                            do {
                                do {
                                    System.out.println("Di la cantidad que quieres adquirir: ");
                                    infoCompra[1] = System.console().readLine("   - ");
                                }while(!Functions.stockProducte(infoCompra[1]));
                            }while(!Functions.stockCorrecte(infoCompra, productes));

                            Functions.restarStock(infoCompra, productes);

                            for (Producte produ:productes){
                                if (produ.getId().equals(infoCompra[0])) {
                                    Linia producteEscollit = new Linia(produ, Integer.parseInt(infoCompra[1]), Float.parseFloat(infoCompra[3]));
                                    linies.add(producteEscollit);
                                }
                            }
                    }

                    // HACER EL RECIVO


                    

   

                    // for (Producte info : productes) {
                    //     if (info.getId().equalsIgnoreCase(infoCompra[2])){
                    //         info.restarStock(Integer.parseInt(infoCompra[1]));
                    //     }
                    // }

                }
                else{
                    System.out.println("Este DNI no existe, rgistrate antes por vavor...");
                    break;
                }
            break;
            case "5":
            break;
            case "6":
            break;
            case "7":
            break;
            case "8":
                acabaPrograma = true;
            break;
            default:
                System.out.println("Tu ets tontu...");
            break;
        }
    }
    
    
    
    }
}