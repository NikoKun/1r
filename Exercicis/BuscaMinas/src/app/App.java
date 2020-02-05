package app;

public class App {
    public static void main(String[] args) {
        int posX = 0;
        int posY = 0;

        int fi = 0;

        int i = 0;
        int j = 0;

        System.out.println("-----------------------------------------------------------");
        int linies = Integer.parseInt(System.console().readLine("Digues el número de línias que vols: "));
        int bombes = Integer.parseInt(System.console().readLine("Digues el número de bombes: "));
        System.out.println("-----------------------------------------------------------");

        int taulell[][] = new int[linies][linies];
        String taulellCOPIA[][] = new String[linies][linies];

        while (i < bombes) {
            posX = (int) Math.floor(Math.random() * linies);
            posY = (int) Math.floor(Math.random() * linies);
            if (taulell[posX][posY] != 9) {
                taulell[posX][posY] = 9;
                i++;
            }
        }

        for (i = 0; i < taulell.length; i++) {
            for (j = 0; j < taulell[0].length; j++) {
                taulellCOPIA[i][j] = "▒";
                // Primeras esquinas
                if (taulell[i][j] == 9) {
                    if (j == 0 && i == 0) {
                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i + 1][j + 1] != 9) {
                            taulell[i + 1][j + 1]++;
                        }
                    } else if (j == (taulell[0].length - 1) && i == (taulell.length - 1)) {
                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i - 1][j - 1] != 9) {
                            taulell[i - 1][j - 1]++;
                        }
                    }
                    else if (j == (taulell[0].length - 1) && i == 0) {
                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i + 1][j - 1] != 9) {
                            taulell[i + 1][j - 1]++;
                        }
                    } else if (j == 0 && i == (taulell.length - 1)) {
                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i - 1][j + 1] != 9) {
                            taulell[i - 1][j + 1]++;
                        }
                    }
                    // En medio derecha e izquierda
                    else if ((j > 0 | j < (taulell[0].length - 1)) && i == 0) {
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i + 1][j + 1] != 9) {
                            taulell[i + 1][j + 1]++;
                        }

                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i + 1][j - 1] != 9) {
                            taulell[i + 1][j - 1]++;
                        }
                    }
                    else if ((j > 0 | j < (taulell[0].length - 1)) && i == (taulell.length - 1)) {
                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i - 1][j - 1] != 9) {
                            taulell[i - 1][j - 1]++;
                        }

                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i - 1][j + 1] != 9) {
                            taulell[i - 1][j + 1]++;
                        }
                    }
                    // En medio arrib y abajo
                    else if ((i > 0 | i < (taulell.length - 1)) && j == 0) {
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i + 1][j + 1] != 9) {
                            taulell[i + 1][j + 1]++;
                        }

                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i - 1][j + 1] != 9) {
                            taulell[i - 1][j + 1]++;
                        }
                    } else if ((i > 0 | i < (taulell.length - 1)) && j == (taulell[0].length - 1)) {
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i + 1][j - 1] != 9) {
                            taulell[i + 1][j - 1]++;
                        }

                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i - 1][j - 1] != 9) {
                            taulell[i - 1][j - 1]++;
                        }
                    }
                    // Medio
                    else {
                        if (taulell[i + 1][j] != 9) {
                            taulell[i + 1][j]++;
                        }
                        if (taulell[i][j - 1] != 9) {
                            taulell[i][j - 1]++;
                        }
                        if (taulell[i + 1][j - 1] != 9) {
                            taulell[i + 1][j - 1]++;
                        }

                        if (taulell[i - 1][j] != 9) {
                            taulell[i - 1][j]++;
                        }
                        if (taulell[i - 1][j - 1] != 9) {
                            taulell[i - 1][j - 1]++;
                        }
                        if (taulell[i][j + 1] != 9) {
                            taulell[i][j + 1]++;
                        }
                        if (taulell[i - 1][j + 1] != 9) {
                            taulell[i - 1][j + 1]++;
                        }
                        if (taulell[i + 1][j + 1] != 9) {
                            taulell[i + 1][j + 1]++;
                        }
                    }
                }
            }
        }

        System.out.print("\n");
        System.out.print("    ");
        for (int wala = 0; wala < linies; wala++) {
            System.out.print(wala + "   ");
        }
        System.out.print("\n");

        for (i = 0; i < taulell.length; i++) {
            System.out.print("\n");
            System.out.print(i + "   ");
            for (j = 0; j < taulell[0].length; j++) {
                System.out.print(taulellCOPIA[i][j] + "   ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        boolean bomba = false;

        while (fi != (taulell.length * taulell.length) - bombes && bomba == false) {
            String userres = System.console().readLine("Digues una possició semblant a 'Y-X': ");
            String userresArr[] = userres.split("-");
            int X = Integer.parseInt(userresArr[0]);
            int Y = Integer.parseInt(userresArr[1]);
            System.out.println("-----------------------------------------------------------");

            System.out.print("\n");
            System.out.print("    ");
            for (int wala = 0; wala < linies; wala++) {
                System.out.print(wala + "   ");
            }
            System.out.print("\n");

            for (i = 0; i < taulell.length; i++) {
                System.out.print("\n");
                System.out.print(i + "   ");
                for (j = 0; j < taulell[0].length; j++) {
                    if (X == i && Y == j) {
                        taulellCOPIA[i][j] = Integer.toString(taulell[i][j]);
                        if (taulell[i][j] == 9) {
                            bomba = true;
                        }
                        fi++;
                    }
                    System.out.print(taulellCOPIA[i][j] + "   ");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        if (bomba == false) {
            System.out.print("Has guanyattttttttttttttt!");
        } else {
            System.out.print("BOMBAAAAAAAAAAAAAAAAAAAAAA!");
        }
    }
}