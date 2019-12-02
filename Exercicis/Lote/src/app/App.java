package app;

public class App {
    public static void main(String[] args) throws Exception {
        int taulellC[][] = new int[10][5];
        int taulellD[][] = new int[2][5];

        int respostaC[] = new int[5];
        int respostaD[] = new int[2];

        int surtC[] = new int[5];
        int surtD[] = new int[2];

        int num = 0;

        boolean trobats = false;

        int intent = 1;
        int c = 0;
        int d = 0;
        int wala;
        boolean repe = false;

        System.out.println("-----------------------------------------------------------------");
        for (int i=0; i<taulellC.length; i++){
            for (int j=0; j<taulellC[0].length; j++){
                num++;
                taulellC[i][j] = num;
                System.out.print(taulellC[i][j]+"\t");
            }
            System.out.println("");
        }

        System.out.println("");
        num = 0;
        for (int i=0; i<taulellD.length; i++){
            for (int j=0; j<taulellD[0].length; j++){
                num++;
                taulellD[i][j] = num;
                System.out.print(taulellD[i][j]+"\t");
            }
            System.out.println("");
        }
        System.out.println("-----------------------------------------------------------------");

        String res;
        res = System.console().readLine("Vols escollir els números (1) o generar-los alearotia-ment (2): ");




        if (res.equals("1")){
            System.out.println("Digues els primers 5 números:");
            for (int i=0; i<5; i++){
                int resC = 0;
                respostaC[i] = Integer.parseInt(System.console().readLine((i + 1) + ": "));
                for (int j=0; j<respostaC.length; j++){
                    surtC[j] = (int)Math.floor(Math.random()*50+1);
                    if (respostaC[i]==respostaC[j]){
                        resC++;
                        if (resC==2){
                            System.out.println("Aquest número està repetit!!!");
                            i--;
                        }
                    }
                    else if ( respostaC[i]<1 || respostaC[i]>50){
                        System.out.println("Número Incorrecte!!!");
                        i--;
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------");
    
            System.out.println("Digues els 2 ultims números:");
            for (int i=0; i<2; i++){
                int resD = 0;
                respostaD[i] = Integer.parseInt(System.console().readLine((i + 1) + ": "));
                for (int j=0; j<respostaD.length; j++){
                    surtD[j] = (int)Math.floor(Math.random()*10+1);
                    if (respostaD[i]==respostaD[j]){
                        resD++;
                        if (resD==2){
                            i--;
                        }
                    }
                    else if ( respostaD[i]<1 || respostaD[i]>10){
                        i--;
                    }
                }        
            }
        }

        else if (res.equals("2")){


            for (int i=0; i<5; i++){
                int resC = 0;
                respostaC[i] = (int)Math.floor(Math.random()*50+1);

                for (int j=0; j<respostaC.length; j++){
                    surtC[j] = (int)Math.floor(Math.random()*50+1);
                    if (respostaC[i]==respostaC[j]){
                        resC++;
                        if (resC==2){
                            i--;
                        }
                    }
                    else if ( respostaC[i]<1 || respostaC[i]>50){
                        i--;
                    }
                }
            }

            for (int i=0; i<2; i++){
                int resD = 0;
                respostaD[i] = (int)Math.floor(Math.random()*10+1);
                for (int j=0; j<respostaD.length; j++){
                    surtD[j] = (int)Math.floor(Math.random()*10+1);
                    if (respostaD[i]==respostaD[j]){
                        resD++;
                        if (resD==2){
                            System.out.println("Aquest número està repetit!!!");
                            i--;
                        }
                    }
                    else if ( respostaD[i]<1 || respostaD[i]>10){
                        System.out.println("Número Incorrecte!!!");
                        i--;
                    }
                }        
            }

            System.console().readLine("Presiona enter per continuar...");
        }


        else {
            System.out.println("Aquesta opció no és correcte!!!");
        }


    System.out.println("-----------------------------------------------------------------");

    while (trobats==false){
        c=0;
        d=0;

        for (int j=0; j<surtC.length; j++){
            wala = (int)Math.floor(Math.random()*50+1);
            repe = false;
            while (repe==false){
                repe = true;
                for (int w=0; w<surtC.length; w++){
                    if (surtC[w]==wala){
                        wala = (int)Math.floor(Math.random()*50+1);
                        repe = false;
                    }
                }
            }
            surtC[j] = wala;
        }

        for (int j=0; j<surtD.length; j++){
            wala = (int)Math.floor(Math.random()*10+1);
            repe = false;
            while (repe==false){
                repe = true;
                for (int w=0; w<surtD.length; w++){
                    if (surtD[w]==wala){
                        wala = (int)Math.floor(Math.random()*10+1);
                        repe = false;
                    }
                }
            }
            surtD[j] = wala;
        }

        for (int j=0; j<respostaC.length; j++){
            for (int f=0; f<respostaC.length; f++){
                if (respostaC[j]==surtC[f]){
                    c++;
                }
            }
        }
        for (int j=0; j<respostaD.length; j++){
            for (int f=0; f<respostaD.length; f++){
                if (respostaD[j]==surtD[f]){
                    d++;
                }
            }
        }

        if (c==5 && d==2){
            System.out.println("HAS GUANYAT EL PRIMER PREMI!!!!!!!");
            trobats=true;
            System.out.println(respostaC[0]+","+respostaC[1]+","+respostaC[2]+","+respostaC[3]+","+respostaC[4]+" --- "+respostaD[0]+","+respostaD[1]+"--> Intent correcte: "+intent);
            System.out.println("Resultat: ");
            System.out.println(surtC[0]+","+surtC[1]+","+surtC[2]+","+surtC[3]+","+surtC[4]+" --- "+surtD[0]+","+surtD[1]);
        }

        intent++;
    }
    System.out.println("-----------------------------------------------------------------");






    }
}