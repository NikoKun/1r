package app;

public class App {
    public static void main(String[] args) throws Exception {
        float parJava[][] = new float[2][2]; // Puntuaciones Javalina
        float parSalt[][] = new float[2][2]; // Puntuaciones Salt
        String sino = "Si";
        String jug[] = new String[2];

        float score[][] = new float[2][3]; // Puntuaciones finales

        int pnico = 0;
        int ptimur = 0;

        System.out.println("Benvingut a les olimpíades");
        jug[0] = System.console().readLine("Introdueix el primer participant: ");
        jug[1] = System.console().readLine("Introdueix el segon participant: ");
        System.out.println("");
        System.out.println("Llista de participants:");
        System.out.println("Dorsal:     Nom:");
        System.out.println("  1         " + jug[0]);
        System.out.println("  2         " + jug[1]);
        System.out.println("---------------------------------------------------");

        // Llançament de javelina: Els atletes tenen 2 oportunitats per llançar la
        // javelina i el registre vàlid serà el més alt.
        System.out.println("Primera prova: Javalina");
        System.out.println("Cada participant tindrà 2 intents i computarà el llançament més llarg.");
        System.out.println("L'ordre de llançament serà el que determini el dorsal. Primer l’1 i després el 2.");
        System.out.println("Les distàncies en javelina solen estar entre els 50m i 80m (amb decimals)");
        System.out.println("---------------------------------------------------");
        System.out.println("Comença la prova de Javelina.");
        for (int i = 0; i < parJava.length; i++) {
            for (int j = 0; j < parJava[0].length; j++) {
                if (i == 0 || i == 2) {
                    System.out.println("Intent num: " + (j + 1) + " del participant: " + jug[0]);

                    parJava[i][j] = Float
                            .parseFloat(System.console().readLine("Introdueix el valor del llançament en metres:"));
                } else {
                    System.out.println("Intent num: " + (j + 1) + " del participant: " + jug[1]);

                    parJava[i][j] = Float
                            .parseFloat(System.console().readLine("Introdueix el valor del llançament en metres:"));
                }
            }
        }

        // Comp Punt Javalina NICO
        if (parJava[0][0] < parJava[0][1]) {
            score[0][0] = parJava[0][1];
        } else {
            score[0][0] = parJava[0][0];

        }
        // Comp Punt Javalina TIMUR
        if (parJava[1][1] < parJava[1][0]) {
            score[1][0] = parJava[1][0];
        } else {
            score[1][0] = parJava[1][1];
        }

        if (score[0][0] < score[1][0]) {
            ptimur++;
        } else {
            pnico++;
        }

        // Print RESULTAT 1
        System.out.println("\t" + "Jav" + "\t" + "Salt" + "\t" + "100M");
        System.out.println(jug[0] + "\t" + score[0][0] + "\t" + score[0][1] + "\t" + score[0][2]);
        System.out.println(jug[1] + "\t" + score[1][0] + "\t" + score[1][1] + "\t" + score[1][2]);
        System.out.println("---------------------------------------------------");

        System.out.println("Segona prova: Salt de longitud");
        System.out.println("Cada participant tindrà 2 intents i computarà el salt més llarg.");
        System.out.println("L'ordre de salt serà el que determini el dorsal");
        System.out.println("Els salts de longitud solen moure's entre els 5m i els 10m (amb decimals)");
        System.out.println("---------------------------------------------------");
        System.out.println("Comença la prova de Javelina.");

        for (int i = 0; i < parSalt.length; i++) {
            for (int j = 0; j < parSalt[0].length; j++) {
                if (i == 0 || i == 2) {
                    System.out.println("Intent num: " + (j + 1) + " del participant: " + jug[0]);
                    parSalt[i][j] = Float
                            .parseFloat(System.console().readLine("Introdueix el valor del llançament en metres:"));
                    sino = System.console().readLine("El salt és vàlid? (Escriu Si o No) ");
                    if (sino.equals("No")) {
                        parSalt[i][j] = 0;
                        sino = "Si";
                    }
                } else {
                    System.out.println("Intent num: " + (j + 1) + " del participant: " + jug[1]);
                    parSalt[i][j] = Float
                            .parseFloat(System.console().readLine("Introdueix el valor del llançament en metres:"));
                    sino = System.console().readLine("El salt és vàlid? (Escriu Si o No) ");
                    if (sino.equals("No")) {
                        parSalt[i][j] = 0;
                        sino = "Si";
                    }
                }
            }
        }

        // Comp Punt Salt NICO
        if (parSalt[0][0] < parSalt[0][1]) {
            score[0][1] = parSalt[0][1];
        } else {
            score[0][1] = parSalt[0][0];
        }
        // Comp Punt Salt TIMUR
        if (parSalt[1][1] < parSalt[1][0]) {
            score[1][1] = parSalt[1][0];
        } else {
            score[1][1] = parSalt[1][1];
        }

        if (score[0][1] < score[1][1]) {
            ptimur++;
        } else {
            pnico++;
        }

        // Print RESULTAT 2
        System.out.println("\t" + "Jav" + "\t" + "Salt" + "\t" + "100M");
        System.out.println(jug[0] + "\t" + score[0][0] + "\t" + score[0][1] + "\t" + score[0][2]);
        System.out.println(jug[1] + "\t" + score[1][0] + "\t" + score[1][1] + "\t" + score[1][2]);
        System.out.println("---------------------------------------------------");

        System.out.println("Tercera prova: Cursa 400m");
        System.out.println("L'aplicació donarà el tret de sortida a la prova amb un intro");
        System.out.println("Quan arribi cada un dels participants s'haurà de prèmer intro");
        System.out.println("Posteriorment es demana l'ordre d'arribada i s'actualitza el marcador.");
        System.out.println("---------------------------------------------------");
        System.out.println("Tot Preparat. Esperant el tret de sortida.");
        System.console().readLine("Prem intro per començar.");
        long temps1 = System.currentTimeMillis();

        System.console().readLine("Prem intro per fer arribar a algú");
        long temps2 = System.currentTimeMillis();

        System.console().readLine("Prem intro per fer arribar a algú");
        long temps3 = System.currentTimeMillis();

        float tmp1 = ((temps2 - temps1));
        float tmp2 = ((temps3 - temps1));

        System.out.println("Tots els atletes han arribat, ara toca especificar l’ordre d’arribada per dorsal.");

        int pos1 = Integer.parseInt(System.console().readLine("Tecleja el dorsal que a arribat en la posició 1: "));
        int pos2 = Integer.parseInt(System.console().readLine("Tecleja el dorsal que a arribat en la posició 2: "));

        if (pos1 == 1) {
            score[0][2] = tmp1 / 100;
        } else {
            score[1][2] = tmp1 / 100;
            System.out.println("WALA TIMUR");

        }
        if (pos2 == 1) {
            score[0][2] = tmp2 / 100;
        } else {
            score[1][2] = tmp2 / 100;
        }

        if (score[0][2] < score[1][2]) {
            pnico++;
        } else {
            ptimur++;
        }

        // Print RESULTAT 3
        System.out.println("\t" + "Jav" + "\t" + "Salt" + "\t" + "100M");
        System.out.println(jug[0] + "\t" + score[0][0] + "\t" + score[0][1] + "\t" + score[0][2]);
        System.out.println(jug[1] + "\t" + score[1][0] + "\t" + score[1][1] + "\t" + score[1][2]);
        System.out.println("---------------------------------------------------");

        if (ptimur < pnico) {
            System.out.println("El guanyador absolut de les olimpiades és: " + jug[0]);
            System.out.println("Resultat:");
            System.out.println(jug[0] + ":  1");
            System.out.println(jug[1] + ":   2");
        }

        else {
            System.out.println("El guanyador absolut de les olimpiades és: " + jug[1]);
            System.out.println("Resultat:");
            System.out.println(jug[1] + ":  1");
            System.out.println(jug[0] + ":   2");
        }

    }
}