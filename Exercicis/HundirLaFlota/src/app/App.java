package app;

public class App {
    public static void main(String[] args) throws Exception {
        boolean guanyat = false;
        String lle[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        int poslle = 0;

        int taulellJP[][] = new int[10][10];
        int taulellCOPIA[][] = new int[10][10];
        int recompteBaixells[][] = new int[4][4];


        System.out.println("Benvingut a Enfonsar La Teva Vida!!!");
        System.console().readLine("Pulsa enter per començar...");

        int numbaixells[] = new int[4];

        int baix = 0;
        String pos = "A-1";


        int l = 0;
        boolean baix2=true;
        while (l<4){
            baix2=true;
            while (baix2==true){
                System.out.println("-----------------------------------------------------------");
                System.out.println("1   -   Pesquer (1pos)");
                System.out.println("2   -   Llenyataire (2pos)");
                System.out.println("3   -   Porta avions (3pos)");
                System.out.println("4   -   Boomer (4pos)");
                System.out.println("-----------------------------------------------------------");

                baix = Integer.parseInt(System.console().readLine("Toca escollir baixell, escriu el seu número: "));
                if(numbaixells[baix-1]==2){
                    System.out.println("Ja has posat tots els baixells número "+baix);
                    System.out.println("-----------------------------------------------------------");
                }

                else{
                    numbaixells[(baix-1)]++;

                    baix2=false;
                    pos = System.console().readLine("Toca escollir la seva posició (A-1): ");
                    String userArr[] = pos.split("-");
    
    
                    if (userArr[0].equals("A")|| userArr[0]=="J"|| userArr[1]=="1" || userArr[1]=="10"){
                        System.out.println("La posició no es vàlida!!!");
                        System.out.println("-----------------------------------------------------------");
                    }
    
                    else{
                        for (int w=0; w<lle.length; w++){
                            if (lle[w].equals(userArr[0])){
                                for(int i=-1; i<2; i++){
                                    for(int j=-1; j<(baix+1); j++){
                                        if(taulellJP[i][j]==-1){
                                            
                                        }

                                    taulellJP[w][Integer.parseInt(userArr[1])]=1;

                                }
                                
    
    
    
    
    
    
    
    
                            }
                        }
                    }
                }

  




                
            }
        }





        // printTaulell(taulellCOPIA, lle);


    }















    public static void printCOPIANTSE(int taulellRe[][], int taulellFi[][]){










        for (int i=0;i<taulellFi.length;i++){
            for (int j=0;j<taulellFi[0].length;j++){
                taulellRe[i][j]=0;
                taulellFi[i][j] = taulellRe[i][j];
            }
        }
    }








    public static void printTaulell(int taulellFi[][], char llet[]){
        System.out.println("\n");
        System.out.print("\t");

        for(int j=1; j<11; j++){
            System.out.print(j+"\t");
        }

        System.out.println("\n");
        for (int i=0;i<taulellFi.length;i++){
            System.out.print(llet[i]+"\t");
            for (int j=0;j<taulellFi[0].length;j++){
                System.out.print(taulellFi[i][j]+"\t");

            }
            System.out.println("\n");
        }
    }












}