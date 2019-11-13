import java.util.Random;

public class BINGOOOO {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int k = 0;
        int w = 0;

        int norep = 0;

        int files[][] = new int[3][9];

        int blancs[] = new int[9];
        int blan = 0;

        Random num1 = new Random();

                int iu = 0;
        int vu = 0;
        int wu = 0;
        int numAl = 0;
        int arrNoRepes[] = new int[89];
        int marc1 = 0;
        int marc2 = 0;
        int marc3 = 0;
        boolean wala = false;
        int aux = 0;
        int v = 0;

        for (j = 0; j < files[0].length; j++) {
            for (i = 0; i < files.length; i++) {
                k = 0;
                while (k == 0) {
                    norep = (num1.nextInt(9) + (j * 10));
                    boolean coin = false;
                    for (w = 0; w < files.length; w++) {
                        if (files[w][j] == norep) {
                            coin = true;
                            break;
                        }
                        coin = false;
                    }
                    if (coin == false) {
                        files[i][j] = norep;
                        k++;
                    }
                }
            }
        }

        for (v = 0; v < 2; v++) {
            for (j = 0; j < files[0].length; j++) {
                for (i = 0; i < 2; i++) {
                    if (files[i][j] > files[i + 1][j]) {
                        aux = files[i][j];
                        files[i][j] = files[i + 1][j];
                        files[i + 1][j] = aux;
                    }
                }
            }
        }

        int coin0 = 0;
        int coin1 = 0;
        int coin2 = 0;

        for (j = 0; j < blancs.length; j++) {
            boolean sale = true;
            while ((coin0 < 3 || coin1 < 3 || coin2 < 3) && sale == true) {
                blan = (num1.nextInt(3));
                if (blan == 0 && coin0 < 3) {
                    blancs[j] = blan;
                    coin0++;
                    sale = false;
                } else if (blan == 1 && coin1 < 3) {
                    blancs[j] = blan;
                    coin1++;
                    sale = false;
                } else if (blan == 2 && coin2 < 3) {
                    blancs[j] = blan;
                    coin2++;
                    sale = false;
                }
            }
        }

        for (j = 0; j < files[0].length; j++) {
            files[blancs[j]][j] = 0;

        }

        String filesFi[][] = new String[3][9];
        
        System.out.print("-----------------------------------------------------------------");

        for (j = 0; j < files[0].length; j++) {
            for (i = 0; i < 3; i++) {
                if (files[i][j] == 0) {
                    filesFi[i][j] = "--";
                } else {
                    filesFi[i][j] = String.valueOf(files[i][j]);
                }
            }
        }
        while (iu < 18) {
            for (j = 0; j < arrNoRepes.length; j++) {
                k = 0;
                while (k == 0) {
                    numAl = (num1.nextInt(89) + 1);
                    boolean coin = false;
                    for (w = 0; w < arrNoRepes.length; w++) {
                        if (arrNoRepes[w] == numAl) {
                            coin = true;
                            break;
                        }
                    }
                    if (coin == false) {
                        arrNoRepes[j] = numAl;
                        k++;

                        for (vu = 0; vu < files[0].length; vu++) {
                            for (wu = 0; wu < files.length; wu++) {

                                if (files[wu][vu] == numAl) {
                                    filesFi[wu][vu] = "XX";
                                    iu++;

                                    if (wu == 0) {
                                        marc1++;
                                    }

                                    else if (wu == 1) {
                                        marc2++;
                                    }

                                    else if (wu == 2) {
                                        marc3++;
                                    }
                                    if ((marc1 == 6) && (wala == false)) {
                                        System.out.print("\n");
                                        System.out.print("Has fet LÍNIA!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.print("\n");
                                        System.out.print("-----------------------------------------------------------------");
                                        wala = true;
                                    }
                                    else if ((marc2 == 6) && (wala == false)) {
                                        System.out.print("\n");
                                        System.out.print("Has fet LÍNIA!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.print("\n");
                                        System.out.print("-----------------------------------------------------------------");
                                        wala = true;

                                    }
                                    else if ((marc3 == 6) && (wala == false)) {
                                        System.out.print("\n");
                                        System.out.print("Has fet LÍNIA!!!!!!!!!!!!!!!!!!!!!!!");
                                        System.out.print("\n");
                                        System.out.print("-----------------------------------------------------------------");
                                        wala = true;

                                    }

                                }
                            }
                        }

                    }

                }

                System.out.print("\n");
                System.out.println("Ha sortit el número: " + numAl);

                for (v = 0; v < files.length; v++) {
                    System.out.println();
                    System.out.print("\n");
                    for (int js = 0; js < files[0].length; js++) {
                        System.out.print(filesFi[v][js] + "\t");
                    }
                }
                System.out.print("\n");
                System.out.print("\n");
                System.console().readLine("Presiona enter para continuar");
                System.out.print("\n");
                System.out.print("\n");
                System.out.println();
                System.out.print("-----------------------------------------------------------------");




            }

            if (iu == 18) {
                System.out.print("\n");
                System.out.print("\n");
                System.out.print("HAS FET BINGOOOOOOOOOOOOOOOOOOO!!!!!!!!!");
                System.out.print("\n");
                System.out.print("-----------------------------------------------------------------");
            }
            System.out.println();
            

        }

    }
}