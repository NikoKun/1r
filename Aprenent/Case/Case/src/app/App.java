package app;

public class App {
    public static void main(String[] args) throws Exception {
        //case
        int resultat=0;
        int a=0;
        int b=0;
        int operacio=0;
        switch (operacio){
            case "suma"
                resultat=a+b;
                break;
            case "resta"
                resultat=a-b;
            default{
                System.out.println("No ha funcionat");
            }
        }

        //For each              --- Comprova tota una array i, en aquest cas, la printeja.
        String wala[] = {"Wala1", "Wala2", "Wala3"};
        String walaCOPIA[];

        for(String MP : wala){
            System.out.println(MP);
        }



        //continue; fa que el bucle en el que estigui es repeteixi sense tindre en compte el codi de a continuació.
        //array1.add(vararr[i]) afegeix el contingut de vararr[] dintre de la array anomenada array1.

        //Buscar sobre el case (Un semblant a IFs)

    }
}