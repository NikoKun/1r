package app;

import java.util.HashMap;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, ArrayList<Object>> stock = new HashMap<>();
        // id, quantitat, descripcio, preu
        HashMap<String, ArrayList<String>> clients = new HashMap<>();
        // tel, nom, cognom, poblacio
        HashMap<Integer, Integer> comanda = new HashMap<>();
        // referencia, quantitat

        boolean acabat = false;
        int exis[] = { 0 };
        boolean opMenu = false;
        DecimalFormat format = new DecimalFormat("#.00");
        String sep = "-------------------------------------------------------------------------------------------";

        while (!opMenu) {
            opcions(sep);

            int menu = Integer.parseInt(System.console().readLine());
            switch (menu) {
            case 1:
                exis[0] = 0;
                System.out.println(sep);
                acabat = false;
                while (!acabat) {
                    ArrayList<Object> productes = new ArrayList<Object>();
                    int id = (Integer.parseInt(System.console().readLine("Digues la id del producte: (0 = sortir) ")));
                    if (id == 0) {
                        break;
                    }
                    productes.add(id);

                    stock.forEach((k, v) -> {
                        if (productes.get(0).equals(v.get(0))) {
                            exis[0]++;
                        }
                    });
                    if (exis[0] > 0) {
                        productes.add(stock.get(productes.get(1)));
                        productes.add(stock.get(productes.get(2)));
                        productes.add(Integer.parseInt(System.console().readLine("Digues la quantitat del producte: ")));
                        stock.replace((int) productes.get(0), productes);
                        System.out.println(sep);
                    } else {
                        productes.add(System.console().readLine("Digues la descripció del producte: "));
                        String preu1 = System.console().readLine("Digues el preu del producte: ");
                        String preu2 = "0";
                        if (preu1.contains(",")) {
                            String[] preu = preu1.split(",");
                            preu2 = preu[0] + "." + (preu[1]);
                        } else {
                            preu2 = preu1;
                        }
                        float preu3 = Float.parseFloat(preu2);
                        productes.add(preu3);
                        productes.add(Integer.parseInt(System.console().readLine("Digues la quantitat del producte: ")));
                        stock.put((int) productes.get(0), productes);
                        System.out.println(sep);
                    }
                }

                break;
            case 2:
                System.out.println(sep);
                stock.forEach((k, v) -> {
                    System.out.println("ID Producte - " + k);
                    System.out.println("\tDesc: " + v.get(1));
                    System.out.println("\tPreu/unitat: " + v.get(2) + "€");
                    System.out.println("\tUnitats: " + v.get(3));
                    System.out.println();
                });
                break;
            case 3:
                System.out.println(sep);
                ArrayList<String> client = new ArrayList<String>();
                client.add(System.console().readLine("Digues el telefon del client: "));
                client.add(System.console().readLine("Digues el nom del client: "));
                client.add(System.console().readLine("Digues el cognom del client: "));
                client.add(System.console().readLine("Digues la població del client: "));
                clients.put(client.get(0), client);
                break;
            case 4:
                System.out.println(sep);
                int[] no = { 0 };
                String tel = System.console().readLine("Digues el telefon que vols cercar: ");
                System.out.println(sep);
                clients.forEach((k, v) -> {
                    if (k.matches(tel)) {
                        System.out.println("Telefon - " + k);
                        System.out.println("\tNom: " + v.get(1));
                        System.out.println("\tCognom: " + v.get(2));
                        System.out.println("\tPoblació: " + v.get(3));
                        System.out.println();
                        no[0]++;
                    }
                });
                if (no[0] < 1) {
                    System.out.println("El client no existeix");
                }
                break;
            case 5:
                ArrayList<Object> unidades = new ArrayList<Object>();
                System.out.println(sep);
                String revisaTel = System.console().readLine("Digues el telefon de client: ");
                System.out.println(sep);
                clients.forEach((k, v) -> {
                    loop: if (k.matches(revisaTel)) {
                        System.out.println("Telefon - " + k);
                        System.out.println("\tNom: " + v.get(1));
                        System.out.println("\tCognom: " + v.get(2));
                        System.out.println("\tPoblació: " + v.get(3));
                        boolean comandaaa = false;
                        while (!comandaaa) {
                            System.out.println();
                            int id = (Integer
                                    .parseInt(System.console().readLine("Digues la id del producte: (0 = sortir) ")));
                            if (id == 0) {
                                break loop;
                            }
                            System.out.println(sep);
                            stock.forEach((l, j) -> {
                                if (l.equals(id)) {
                                    boolean quantitat = false;
                                    while (!quantitat) {
                                        System.out.println();
                                        System.out.println("\tDesc: " + j.get(1));
                                        System.out.println("\tPreu/unitat: " + j.get(2) + "€");
                                        System.out.println("\tUnitat: " + j.get(3));
                                        System.out.println();

                                        int unis = (Integer
                                                .parseInt(System.console().readLine("Digues les unitats que vols: ")));
                                        System.out.println();
                                        if (unis > (int) j.get(3)) {
                                            System.out.println("No hi han suficients!!!");
                                        } else {
                                            unidades.add(j.get(0));
                                            unidades.add(j.get(1));
                                            unidades.add(j.get(2));
                                            unidades.add(((int) j.get(3) - unis));
                                            stock.put(id, unidades);
                                            quantitat = true;
                                            comanda.put(id, unis);

                                        }
                                    }

                                }
                            });
                        }

                    }
                });

                if (comanda.isEmpty()) {
                    System.out.println("El client és nou");
                    System.out.println("Introdueix el client abans de la venda");
                } else if (!comanda.isEmpty()) {
                    float[] preu = { 0, 0 };
                    LocalDateTime ara = LocalDateTime.now();
                    System.out.println(sep);
                    System.out.println("FACTURA");
                    System.out.println(sep);
                    System.out.println(
                            "Data -> " + ara.getDayOfMonth() + " de " + ara.getMonth() + " de " + ara.getYear());
                    System.out.println("Hora -> " + ara.getHour() + ":" + ara.getMinute());
                    System.out.println();
                    System.out.println("Telefon - " + clients.get(revisaTel).get(0));
                    System.out.println("\tNom: " + clients.get(revisaTel).get(1));
                    System.out.println("\tCognom: " + clients.get(revisaTel).get(2));
                    System.out.println("\tPoblació: " + clients.get(revisaTel).get(3));
                    System.out.println();
                    System.out.println("PRODUCTES");
                    System.out.println();

                    stock.forEach((d, r) -> {
                        comanda.forEach((z, b) -> {
                            if (d.equals(z)) {
                                System.out.println("ID Producte - " + d);
                                System.out.println("\tDesc: " + r.get(1));
                                System.out.println("\tPreu/unitat: " + r.get(2) + "€");
                                System.out.println("\tUnitats: " + comanda.get(1));
                                float wala = (float) r.get(2) * (float) comanda.get(1);
                                float iva = ((float) r.get(2) * (float) comanda.get(1)) * ((float) 0.21);
                                float walaIVA = ((float) r.get(2) * (float) comanda.get(1)) - iva;
                                System.out.println("\tPreu total del producte: " + wala + "€");
                                preu[0] = preu[0] + wala;
                                preu[1] = preu[1] + walaIVA;
                                System.out.println();
                            }
                        });
                    });

                    System.out.println("SubTotal: " + format.format(preu[1]) + "€");
                    System.out.println("IVA: " + format.format((preu[0] - preu[1])) + "€");
                    System.out.println("Total: " + format.format(preu[0]) + "€");
                }
                break;
            case 6:
                opMenu = true;
                break;
            }
        }

    }

    public static void opcions(String sep) {
        System.out.println(sep);
        System.out.println("    Mercat de fruita");
        System.out.println(sep);
        System.out.println("1 - Afegir stock");
        System.out.println("2 - Mostrar stock");
        System.out.println("3 - Crear client");
        System.out.println("4 - Cercar client per telefon");
        System.out.println("5 - Venda");
        System.out.println("6 - Sortir");
        System.out.println(sep);

    }
}