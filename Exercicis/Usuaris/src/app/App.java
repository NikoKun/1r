package app;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

public class App {
    public static void main(String[] args) throws Exception {
        // Nom, cognom, adreça, població, data naix, user, passw
        // Contra - Regular expres (if (pass.matches("condicions")))
        // Guardar edat en base a la data

        // Date date= new Date();
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // String[] dataAvui = sdf.format(date).split("/");

        String usuaris[][] = new String[7][20];
        int edat[] = new int[20];

        String menu;

        String user;
        boolean exit = false;
        boolean vols = false;
        String v;
        String c;

        boolean rape = true;
        int pos = 0;

        while (!exit) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("  - Wala escoge el sabor que prefieras:");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Llista usuaris per edat");
            System.out.println("4. Cerca");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------------------------------------");

            menu = System.console().readLine("Selecciona una opció: ");
            System.out.println("-------------------------------------------------------------------");

            if (menu.equals("1")) {
                System.out.println();
                while (rape) {
                    String reg;
                    String pass;

                    reg = System.console().readLine("Introdueix l'usuari: ");
                    pass = System.console().readLine("Introdueix la contrasenya: ");

                    for (int i = 0; i < 20; i++) {
                        if (reg.equals(usuaris[5][i])) {
                            if (pass.equals(usuaris[6][i])) {
                                System.out
                                        .println("-------------------------------------------------------------------");
                                System.out.println("Usuari correcte!!!");
                                rape = false;
                                break;
                            }
                        } else {
                            if (i == 19) {
                                System.out
                                        .println("-------------------------------------------------------------------");
                                System.out.println("Login incorrecte!!!");
                                System.out
                                        .println("-------------------------------------------------------------------");
                                rape = false;
                            }
                        }

                    }
                }
            }

            else if (menu.equals("2")) {
                vols = false;
                while (!vols) {
                    usuaris[0][pos] = System.console().readLine("Introdueix el teu nom: ");
                    usuaris[1][pos] = System.console().readLine("Introdueix el teu cognom: ");
                    usuaris[2][pos] = System.console().readLine("Introdueix la teva adreça: ");
                    usuaris[3][pos] = System.console().readLine("Introdueix la teva població: ");

                    rape = true;
                    while (rape) {
                        c = System.console().readLine("Introdueix la data de naixement (dd/MM/yyyy):");
                        // SimplreDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        // String[] dataAvui = sdf.format(date).split("/");

                        String[] dataNaix = c.format(c).split("/");

                        if (Integer.parseInt(dataNaix[1]) < 13) {
                            if (c.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
                                usuaris[4][pos] = c;
                                rape = false;

                                Date date = new Date();
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                                String[] dataAvui = sdf.format(date).split("/");

                                edat[pos] = Integer.parseInt(dataAvui[2]) - Integer.parseInt(dataNaix[2]);

                                if (Integer.parseInt(dataAvui[1]) < Integer.parseInt(dataNaix[1])) {
                                    edat[pos] = edat[pos] - 1;
                                }

                                else {
                                    if (Integer.parseInt(dataAvui[2]) < Integer.parseInt(dataNaix[2])) {
                                        edat[pos] = edat[pos] - 1;
                                    }
                                }

                            } else {
                                System.out
                                        .println("-------------------------------------------------------------------");
                                System.out.println("Aquesta data no es correcte!!!");
                                System.out
                                        .println("-------------------------------------------------------------------");
                            }
                        } else {
                            System.out.println("-------------------------------------------------------------------");
                            System.out.println("Aquesta data no es correcte!!!");
                            System.out.println("-------------------------------------------------------------------");
                        }

                    }

                    rape = true;
                    while (rape) {
                        rape = false;
                        user = System.console().readLine("Introdueix el teu nom d'usuari: ");
                        for (int i = 0; i < 20; i++) {
                            if (user.equalsIgnoreCase(usuaris[5][i])) { // MIRAR
                                                                        // ------------------------------------------------------
                                System.out
                                        .println("-------------------------------------------------------------------");
                                System.out.println("Aquest nom d'usuari no esta disponible!!!");
                                System.out
                                        .println("-------------------------------------------------------------------");
                                rape = true;
                            }
                        }
                        if (rape == false) {
                            usuaris[5][pos] = user;
                        }
                    }

                    while (rape == false) {
                        c = System.console().readLine("Introdueix la teva contrassenya: ");
                        if (c.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$")) {
                            usuaris[6][pos] = c;
                            rape = true;
                        } else {
                            System.out.println("-------------------------------------------------------------------");
                            System.out.println("Aquesta contrasenya és poc segura!!!");
                            System.out.println("-------------------------------------------------------------------");
                        }
                    }

                    System.out.println("Vols continuar?");
                    v = System.console().readLine();
                    if (v.equals("si")) {
                        vols = true;
                    } else {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("Torna a entrar la informació: ");
                        System.out.println("-------------------------------------------------------------------");
                        for (int i = 0; i < usuaris.length; i++) {
                            usuaris[i][pos] = "null";
                        }
                    }
                }
                pos++;
            }

            else if (menu.equals("3")) {
                int edatOrd[] = new int[20];
                String as;
                int edatAux = 0;
                ;

                for (int i = 0; i < pos; i++) {
                    edatOrd[i] = edat[i];
                }
                for (int i = 0; i < pos; i++) {
                    for (int j = (i + 1); j < pos; j++) {
                        if (edatOrd[i] > edatOrd[j]) {
                            edatAux = edatOrd[i];
                            edatOrd[i] = edatOrd[j];
                            edatOrd[j] = edatAux;
                        }
                    }
                }

                as = System.console().readLine("Ascendent (a) o Descendent(d): ");

                if (as.equals("a")) {
                    for (int i = 0; i < pos; i++) {
                        for (int j = 0; j < pos; j++) {
                            if (edatOrd[j] == edat[i]) {
                                System.out.println("");
                                System.out.print("Nom: " + usuaris[0][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Cognom: " + usuaris[1][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Població: " + usuaris[3][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Edat: " + edat[i] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.println("");
                            }
                        }
                    }
                }
                if (as.equals("d")) {
                    for (int i = (pos - 1); i > -1; i--) {
                        for (int j = (pos - 1); j > -1; j--) {
                            if (edatOrd[j] == edat[i]) {
                                System.out.println("");
                                System.out.print("Nom: " + usuaris[0][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Cognom: " + usuaris[1][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Població: " + usuaris[3][j] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.print("Edat: " + edat[i] + "\t" + "\t");
                                System.out.print("\n");
                                System.out.println("");
                            }
                        }
                    }
                }

                else {
                    System.out.println("Aquesta opció no és correcte.");
                }

            }

            else if (menu.equals("4")) {
                System.out.println("Digues que vols filtrar:");
                String filtre = System.console().readLine("Selecciona una opció: ");
                Pattern pattern = Pattern.compile(filtre);
                for (int j = 0; j < pos; j++) {
                    for (int i = 0; i < usuaris.length; i++) {
                        Matcher matcher = pattern.matcher(usuaris[i][j]);
                        if (matcher.find()) {
                            System.out.println(""); // MIRAR -----------------------
                            for (int w = 0; w < usuaris.length; w++) {
                                System.out.print(usuaris[w][j] + "\t" + "\t");
                                System.out.print("\n");
                            }
                            System.out.println("");
                        }
                        break;
                    }
                }
            }

            else if (menu.equals("5")) {
                exit = true;
            }
        }

    }
}