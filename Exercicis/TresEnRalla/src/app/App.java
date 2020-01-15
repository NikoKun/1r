package app;

public class App {
    public static void main(String[] args) throws Exception {
        boolean tria = true;
        boolean jug = true;

        String jugador[] = new String[2];
        String tempS;
        int primerTemporal = 0;
        int segFase[] = { 0, 0 };
        int posInteligent[] = { 0, 0, 0 };
        int posI = 0;
        int posJ = 0;

        String taulell[][] = new String[][] { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };

        System.out.println("------------------------------------------------------------");
        System.out.println("                TRES EN RALLA!!!");
        System.out.println("------------------------------------------------------------");

        while (tria || jug) {
            System.out.println("Quin simbol vols tindre? (X/O)");
            tempS = System.console().readLine();
            System.out.println("------------------------------------------------------------");

            if (tempS.equalsIgnoreCase("X")) {
                jugador[0] = "X";
                jugador[1] = "O";
                tria = false;
            } else if (tempS.equalsIgnoreCase("O")) {
                jugador[0] = "O";
                jugador[1] = "X";
                tria = false;
            } else {
                System.out.println("Aquest caracter no és correcte!!!!");
            }

            System.out.println("Vols començar tú? (S/N)");
            tempS = System.console().readLine();
            System.out.println("------------------------------------------------------------");
            if (tempS.equalsIgnoreCase("S")) {
                primerTemporal = 0;
                jug = false;
            } else if (tempS.equalsIgnoreCase("N")) {
                primerTemporal = 1;
                jug = false;
            } else {
                System.out.println("Aquest caracter no és correcte!!!!");
            }
        }

        while (!jug) {
            if (primerTemporal == 0) {
                if (!jugador(taulell, posI, posJ, jugador, segFase)) {
                    break;
                }
                if (!maquina(taulell, posI, posJ, jugador, segFase, posInteligent)) {
                    break;
                }
            } else {
                if (!maquina(taulell, posI, posJ, jugador, segFase, posInteligent)) {
                    break;
                }
                if (!jugador(taulell, posI, posJ, jugador, segFase)) {
                    break;
                }
            }
        }
    }

    public static void printaTaula(String taulell[][]) { // Mostrar el taulell de joc
        int num = 1;
        System.out.println("    1   2   3");
        System.out.println("  -------------");
        for (int i = 0; i < taulell.length; i++) {
            System.out.print(num + " | ");
            for (int j = 0; j < taulell[0].length; j++) {
                System.out.print(taulell[i][j] + " ");
                System.out.print("| ");
            }
            System.out.println("");
            System.out.println("  -------------");
            num++;
        }
        System.out.println("");
        System.out.println("------------------------------------------------------------");
    }

    public static boolean comprSiFicha(String taulell[][], int posI, int posJ) { // Comprovar si en la posició hi ha una
                                                                                 // fitxa o no
        if (taulell[posI][posJ] == "X" || taulell[posI][posJ] == "O") {
            return false;
        } else {
            return true;
        }
    }

    public static boolean tepasas(int posI, int posJ) { // Comprova si la posició és superior a la mida del taulell
        if ((posI < 0 || posI > 2) || (posJ < 0 || posJ > 2)) {
            System.out.println("Te PASAS!");
            System.out.println("------------------------------------------------------------");
            return true;
        } else {
            return false;
        }
    }

    public static boolean jugador(String taulell[][], int posI, int posJ, String jugador[], int[] segFase) { // Torn del
                                                                                                             // jugador
        boolean posNoOcu = false;
        boolean posNoOcuelimina = false;
        int primer = 0;
        while (!posNoOcu) {
            System.out.println();
            printaTaula(taulell);
            do {
                posI = (Integer.parseInt(System.console().readLine("Digues posició (I): "))) - 1;
                posJ = (Integer.parseInt(System.console().readLine("Digues posició (X): "))) - 1;
                System.out.println("------------------------------------------------------------");
            } while (tepasas(posI, posJ));

            if (comprSiFicha(taulell, posI, posJ)) {
                segFase[0]++;
                taulell[posI][posJ] = jugador[0];
                posNoOcu = true;

                if ((segFase[0] > 3)) { // A partir de les 3 fitxes hem d'eliminar-ne una anterior...
                    while (!posNoOcuelimina) {
                        int posIelimina = 0;
                        int posJelimina = 0;
                        do {
                            posIelimina = (Integer
                                    .parseInt(System.console().readLine("Digues posició a eliminar (I): "))) - 1;
                            posJelimina = (Integer
                                    .parseInt(System.console().readLine("Digues posició a eliminar (X): "))) - 1;
                            System.out.println("------------------------------------------------------------");
                        } while (tepasas(posIelimina, posJelimina));

                        if (taulell[posIelimina][posJelimina].equals(jugador[0])) {
                            taulell[posIelimina][posJelimina] = " ";
                            posNoOcuelimina = true;
                        } else {
                            System.out.println("Posició incorrecte!!!!!!!!");
                        }
                    }
                    if ((posNoOcu == true && posNoOcuelimina == false)
                            || (posNoOcu == false && posNoOcuelimina == true)) {
                        segFase[0]--;
                    }
                }
                if (!guanyat(taulell, primer, jugador)) {
                    return false;
                }
            } else {
                System.out.println("Posició ocupada!!!!!!!!");
            }
        }
        return true;
    }

    public static boolean millorPos(String taulell[][], int[] posInteligent) { // Comprova si hi ha una millor posició
        for (int i = 0; i < taulell.length; i++) {
            posInteligent[1] = 0; // j
            posInteligent[2] = 2;

            for (int j = 0; j < taulell[0].length; j++) {
                if (taulell[i][j] == "O") {
                    posInteligent[1]++; // j
                } else if (taulell[i][j] == " ") {
                    posInteligent[2] = i;
                } else if (taulell[i][j] == "X") {
                    break;
                }
            }
            if (posInteligent[1] == 2) {
                System.out.println("Wala0");

                posInteligent[0] = i; // i
                posInteligent[1]++; // j
                return true;
            }
        }
        posInteligent[1] = 0; // j

        for (int j = 0; j < taulell[0].length; j++) {
            posInteligent[0] = 0; // i
            posInteligent[2] = 2; // j
            for (int i = 0; i < taulell.length; i++) {
                if (taulell[i][j] == "O") {
                    posInteligent[0]++; // i
                } else if (taulell[i][j] == " ") {
                    posInteligent[2] = j;
                } else if (taulell[i][j] == "X") {
                    break;
                }
            }
            if (posInteligent[0] == 2) {
                System.out.println("Wala1");
                posInteligent[1] = j; // j
                posInteligent[0]++; // i
                return true;
            }
        }

        if ((taulell[0][0] == "O" && taulell[2][2] == "O") || (taulell[2][0] == "O" && taulell[0][2] == "O")) {
            System.out.println("Wala3");
            posInteligent[0] = 3; // i
            posInteligent[1] = 3; // j
            posInteligent[2] = 1; // j
            return true;
        }

        return false;

    }

    public static boolean maquina(String taulell[][], int posI, int posJ, String jugador[], int[] segFase,
            int[] posInteligent) { // Torn de la màquina
        boolean posNoOcu = false;
        boolean posNoOcue = false;
        int primer = 1;

        int vegades = 0;
        while (!posNoOcu) {

            if (millorPos(taulell, posInteligent)) {
                if (posInteligent[1] == 3 && posInteligent[0] == 3) {
                    posI = (int) (Math.random() * 3);
                    posJ = (int) (Math.random() * 3);
                    System.out.println("Mo" + posI + posJ);
                    vegades++;
                } else if (posInteligent[0] == 3) {
                    posJ = posInteligent[1];
                    posI = posInteligent[2];
                    System.out.println("re = " + posI + posJ);
                    vegades++;
                }

                else if (posInteligent[1] == 3) {
                    posI = posInteligent[0];
                    posJ = posInteligent[2];
                    System.out.println("no = " + posI + posJ);
                    vegades++;

                }
                System.out.println(vegades);
            }

            else {
                posI = (int) (Math.random() * 3);
                posJ = (int) (Math.random() * 3);
                System.out.println(".. = " + posI + posJ);
            }

            if (vegades >= 1) {
                posI = (int) (Math.random() * 3);
                posJ = (int) (Math.random() * 3);
                System.out.println("... = " + posI + posJ);
                vegades = 0;
            }

            if (comprSiFicha(taulell, posI, posJ)) {
                System.out.println("WALAAAAAAA");
                segFase[1]++;
                taulell[posI][posJ] = jugador[1];
                posNoOcu = true;
                if ((segFase[1] > 3)) {
                    while (!posNoOcue) {
                        int posIe = (int) (Math.random() * 3);
                        int posJe = (int) (Math.random() * 3);
                        if (taulell[posIe][posJe].equals(jugador[1])) {
                            taulell[posIe][posJe] = " ";
                            posNoOcue = true;
                        }
                    }
                    if ((posNoOcu == true && posNoOcue == false) || (posNoOcu == false && posNoOcue == true)) {
                        segFase[1]--;
                    }
                }
                if (!guanyat(taulell, primer, jugador)) {
                    return false;
                }
            }
        }
        System.out.println("Tirada de la màquina: I=" + (posI + 1) + " J=" + (posJ + 1));
        return true;
    }

    public static boolean guanyat(String taulell[][], int primer, String jugador[]) { // Comprovar si algú ha guanyat
        int comp = 0;
        for (int i = 0; i < taulell.length; i++) {
            comp = 0;
            for (int j = 0; j < taulell[0].length; j++) {
                if (taulell[i][j].equals(jugador[primer])) {
                    comp++;
                }
                if (comp == 3) {
                    win(jugador, primer, taulell);
                    return false;
                }
            }
        }

        for (int j = 0; j < taulell[0].length; j++) {
            comp = 0;
            for (int i = 0; i < taulell.length; i++) {
                if (taulell[i][j].equals(jugador[primer])) {
                    comp++;
                }
                if (comp == 3) {
                    win(jugador, primer, taulell);
                    return false;
                }
            }
        }

        if (taulell[0][0].equals(jugador[primer]) && taulell[1][1].equals(jugador[primer])
                && taulell[2][2].equals(jugador[primer])) {
            win(jugador, primer, taulell);
            return false;
        } else if (taulell[0][2].equals(jugador[primer]) && taulell[1][1].equals(jugador[primer])
                && taulell[2][0].equals(jugador[primer])) {
            win(jugador, primer, taulell);
            return false;
        } else {
            return true;
        }
    }

    public static void win(String jugador[], int primer, String[][] taulell) { // Missatge final
        if (primer == 0) {
            System.out.println("FELICITATS!!!!!!!!!!!!");
            System.out.println("Has guanyat!!!!!!!!!!!!!!!!!!!");
            System.out.println("");
            printaTaula(taulell);
        } else {
            System.out.println("FELICITATS MÀQUINA!!!!!!!!!!!!");
            System.out.println("La màquina ha guanyat!!!!!!!!!!!!!!!!!!!");
            System.out.println("");
            printaTaula(taulell);
        }
    }
}