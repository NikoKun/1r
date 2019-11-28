package app;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        String noms[] = { "nico", "timur" }; // 4 vocals
        int puntsres = 0;
        int punts[] = { 0, 0 };
        int lol = 0;

        char vocals[] = { 'A', 'E', 'I', 'O', 'U' };
        char consonants[] = { 'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'P', 'Q', 'R', 'S', 'T', 'V',
                'W', 'X', 'Y', 'Z' };
        char taulell[] = new char[9];

        Random ran = new Random();

        int nron = 0;
        int i = 0;
        int j = 0;
        int e = 0;
        int n = 0;

        for (int w = 0; w < 2; w++) {
            noms[w] = System.console().readLine("Digues el nom del jugador nº" + (w + 1) + ": ");

        }
        nron = Integer.parseInt(System.console().readLine("Digues el número de rondes: "));

        String paraules[][] = new String[nron][2]; // VARIABLE PARAULESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
        for (int w = 0; w < 9; w++) {
            taulell[w] = ' ';
        }

        for (i = 0; i < nron; i++) { // RONDA
            System.out.println("-----------------------------------------------------");
            System.out.println("RONDA NÚMERO " + (i + 1));

            for (int w = 0; w < 4; w++) { // POSAR VOCALS
                taulell[ran.nextInt(9)] = vocals[ran.nextInt(5)];
            }
            for (int w = 0; w < 9; w++) { // POSAR CONSONANTS
                if (taulell[w] == ' ') {
                    taulell[w] = consonants[ran.nextInt(22)];
                }
            }

            System.out.println();
            System.out.println("El taulell és:");
            for (int w = 0; w < taulell.length; w++) {
                System.out.print(taulell[w] + " ");
            }
            System.out.println();
            System.out.println();

            for (j = 0; j < 2; j++) {
                paraules[i][j] = System.console().readLine(noms[j] + ", digues la paraula que vols fer: ");
                for (e = 0; e < paraules[i][j].length(); e++) {
                    for (n = 0; n < 9; n++) {
                        if (taulell[n] == paraules[i][j].charAt(e)) {
                            taulell[n] = Character.toLowerCase(taulell[n]);
                            puntsres++;
                            break;
                        }
                    }
                }

                for (int w = 0; w < 9; w++) {
                    taulell[w] = Character.toUpperCase(taulell[w]);
                }

                if (puntsres != paraules[i][j].length()) {
                    System.out.println(noms[j] + ", la teva puntuació és: " + punts[j]);
                } else {
                    lol=punts[j];
                    punts[j] = (lol+puntsres);
                    System.out.println(noms[j] + ", la teva puntuació és: " + punts[j]);
                }
                puntsres = 0;
                // consonants.charAt(r.nextInt(vocals.length()))

            }

        }

        System.out.println("-----------------------------------------------------");
        System.out.println("Fi del joc!!!");
        System.out.println("Puntuacions: ");
        System.out.println(noms[0]+": "+punts[0]);
        System.out.println(noms[1]+": "+punts[1]);
        System.out.println("-----------------------------------------------------");


    }
}