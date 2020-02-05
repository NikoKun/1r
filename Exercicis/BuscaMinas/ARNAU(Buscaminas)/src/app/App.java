package app;

public class App {
    public static void main(String[] args) {

        int cantitatBombas = 4;
        int randomColumna = 0;
        int randomFila = 0;
        boolean partidaNova = true;
        boolean lost = false;
        int intents = 0;
        boolean win = false;

        while (partidaNova) { // Bucle partida

            System.out.print("Escriu la cantitat de columnes i files del camp de mines: ");
            int longitud = Integer.parseInt(System.console().readLine());
            int arrayBomba[][] = new int[longitud][longitud];
            String arrayString[][] = new String[longitud][longitud];
            System.out.print("Quina es la cantitat de minas que vosl: ");
            cantitatBombas = Integer.parseInt(System.console().readLine());

            System.out.println();
            System.out.println();

            for (int i = 0; i < cantitatBombas; i++) {

                do {
                    randomColumna = (int) (Math.floor(Math.random() * longitud));
                    randomFila = (int) (Math.floor(Math.random() * longitud));
                } while (arrayBomba[randomFila][randomColumna] == -1);

                arrayBomba[randomFila][randomColumna] = -1;

            }

            for (int i = 0; i < arrayBomba.length; i++) {// Rows
                for (int j = 0; j < arrayBomba[0].length; j++) {// Columnes
                    if (arrayBomba[i][j] < 0) {

                        // Row superior

                        if (i == 0 && j > 0 && j < arrayBomba[0].length - 1) {
                            for (int x = i; x < i + 1; x++) {// Rows
                                for (int k = j - 1; k < j + 2; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Columna esquerre

                        if (j == 0 && i > 0 && i < arrayBomba.length - 1) {
                            for (int x = i - 1; x < i + 2; x++) {// Rows
                                for (int k = j; k < j + 1; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Row Inferior

                        if (i == arrayBomba.length - 1 && j > 0 && j < arrayBomba[0].length - 1) {
                            for (int x = i - 1; x < i + 1; x++) {// Rows
                                for (int k = j - 1; k < j + 2; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Columna dreta

                        if (j == arrayBomba[0].length - 1 && i > 0 && i < arrayBomba.length - 1) {
                            for (int x = i - 1; x < i + 2; x++) {// Rows
                                for (int k = j - 1; k < j + 1; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Cantonada superior esquerra

                        if (j == 0 && i == 0) {
                            for (int x = i; x < i + 2; x++) {// Rows
                                for (int k = j; k < j + 2; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Cantonada inferior esquerre

                        if (j == 0 && i == arrayBomba.length - 1) {
                            for (int x = i - 1; x < i + 1; x++) {// Rows
                                for (int k = j; k < j + 2; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Cantonada inferior dreta

                        if (j == arrayBomba[0].length - 1 && i == arrayBomba.length - 1) {
                            for (int x = i - 1; x < i + 1; x++) {// Rows
                                for (int k = j - 1; k < j + 1; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Cantonada superior dreta

                        if (j == arrayBomba[0].length - 1 && i == 0) {
                            for (int x = i; x < i + 2; x++) {// Rows
                                for (int k = j - 1; k < j + 1; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }

                        // Altres

                        if (j > 0 && i > 0 && j < arrayBomba[0].length - 1 && i < arrayBomba.length - 1) {
                            for (int x = i - 1; x < i + 2; x++) {// Rows
                                for (int k = j - 1; k < j + 2; k++) {// Columnes
                                    if (arrayBomba[x][k] >= 0) {
                                        arrayBomba[x][k] = arrayBomba[x][k] + 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < arrayBomba.length; i++) {// Rows
                for (int j = 0; j < arrayBomba[0].length; j++) {// Columnes
                    arrayString[i][j] = "■";
                }
            }

            while (!lost && !win) {// Bucle ronda

                System.out.print("    ");

                for (int i = 0; i < arrayString[0].length; i++) {// Columnes
                    System.out.print(i + "   ");
                }

                for (int i = 0; i < arrayString.length; i++) {// Rows
                    System.out.println();
                    System.out.println();

                    for (int j = -1; j < (arrayString[0].length); j++) {// Columnes
                        if (j < 0) {
                            System.out.print(i + "   ");
                        } else {
                            System.out.print(arrayString[i][j] + "   ");
                        }
                    }
                }

                System.out.println();
                System.out.println();
                System.out.println();
                System.out.print("Escriu la posicio a comprovar (0-0) ");
                String resultat = System.console().readLine();
                String[] parts = resultat.split("-");
                String part1 = parts[0];
                String part2 = parts[1];

                if (arrayBomba[Integer.parseInt(part1)][Integer.parseInt(part2)] < 0) {
                    System.out.println("Has escollit una posicio amb una bomba");
                    lost = true;
                }
                if (arrayBomba[Integer.parseInt(part1)][Integer.parseInt(part2)] == 0) {
                    System.out.println("Has escollit una posicio sensa bombas aprop");
                    intents++;
                }
                if (arrayBomba[Integer.parseInt(part1)][Integer.parseInt(part2)] > 0) {
                    System.out.println("Has escollit una posicio amb bombas aprop");
                    intents++;
                }
                System.out.println();

                for (int i = 0; i < arrayBomba.length; i++) {// Rows
                    for (int j = 0; j < arrayBomba[0].length; j++) {// Columnes
                        if (i == Integer.parseInt(part1) && j == Integer.parseInt(part2)) {
                            arrayString[i][j] = Integer
                                    .toString(arrayBomba[Integer.parseInt(part1)][Integer.parseInt(part2)]);
                            if (arrayBomba[Integer.parseInt(part1)][Integer.parseInt(part2)] < 0) {
                                arrayString[i][j] = "o";
                            }
                        }

                    }
                }
                if (intents == (arrayBomba.length * arrayBomba[0].length) - cantitatBombas) {
                    win = true;
                    System.out.println("Has guanyat!!");
                }
                // for (int i = 0; i < arrayBomba.length; i++) {// Rows
                // System.out.println();
                // System.out.println();
                // for (int j = 0; j < (arrayBomba[0].length); j++) {// Columnes

                // System.out.print(arrayBomba[i][j] + " ");

                // }
                // }
                // System.out.println();

            } // Bucle ronda

            System.out.print("Si vols tornar a jugar introdueix en el teclat S, si no vols tornar a jugar N: ");
            if(System.console().readLine().equalsIgnoreCase("N")){
                partidaNova=false;
            }
        } // Bucle joc
    }
}