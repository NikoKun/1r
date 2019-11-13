package app;

public class App {
    public static void main(String[] args) throws Exception {
        String paraules[] = { "Wala", "Chico" };
        int wa = 0;
        int we[] = { 0, 0 };

        int nron = 0;
        String jugadors[] = { "Nico", "Timur" };
        int i = 0;
        int j = 0;

        System.out.println("¡¡¡BENVINGUT AL JOC DELS MOTS ENCREUATS!!!");
        System.out.println("Digues el número de rondes");
        nron = Integer.parseInt(System.console().readLine());
        System.out.println("----------------------------------------------------------------------");

        for (i = 0; i < jugadors.length; i++) {
            System.out.println("Digues el nom del jugador número " + (i + 1));
            jugadors[i] = System.console().readLine();
        }
        System.out.println("----------------------------------------------------------------------");

        paraules[1] = System.console().readLine("Escolliu la primera paraula: ");
        System.out.println("----------------------------------------------------------------------");

        loop: for (i = 0; i < nron; i++) {
            System.out.println("¡¡¡Ronda número " + (i + 1) + "!!!");
            for (j = 0; j < jugadors.length; j++) {

                System.out.println(jugadors[j] + " digues una paraula que comenci per: "
                        + paraules[1 - j].substring(paraules[1 - j].length() - 2));
                paraules[j] = System.console().readLine();

                if (paraules[1 - j].startsWith(paraules[j].substring(paraules[j].length() - 2))) {
                    System.out.println("¡¡¡Correcte!!!");
                    System.out.println("----------------------------------------------------------------------");
                    we[j]++;
                } else {
                    System.out.println("¡¡¡Incorrecte!!!");
                    System.out.println("----------------------------------------------------------------------");
                    wa = j;
                    // System.out.println("Ha guanyat en "+jugadors[1-wa]);
                    // System.out.println("Puntuació d'en "+jugadors[1-wa]+": "+(wa+1));
                    // System.out.println("Puntuació d'en "+jugadors[wa]+": "+(-((wa+1)-nron)));
                    break loop;
                }
            }
            System.out.println("----------------------------------------------------------------------");
        }

        if (i == nron) {
            System.out.println("Empat!!!");
            System.out.println("Puntuació d'en " + jugadors[1 - wa] + ": " + we[0]);
            System.out.println("Puntuació d'en " + jugadors[wa] + ": " + we[1]);
            System.out.println("----------------------------------------------------------------------");
        }

        else {
            System.out.println("Ha guanyat en " + jugadors[1 - wa]);
            System.out.println("Puntuació d'en " + jugadors[1 - wa] + ": " + we[0]);
            System.out.println("Puntuació d'en " + jugadors[wa] + ": " + we[1]);
            System.out.println("----------------------------------------------------------------------");
        }
    }
}