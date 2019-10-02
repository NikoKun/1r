
import java.text.DecimalFormat;


public class Ex9ApuntAUnaCursaPerDorsal {
    public static void main(String[] args) {
    

    String noms[] = new String[1000];
    String noms1="S";
    String nom2="n";
    int posn = 0;
    int n = 0;
    int wala;


    long pes;
    long pes2;
    long pes3;

    int num = 1;

    String dorsal[] = new String[1000];
    String dorsal1;
    int posd = 0;
    int p = 0;

    DecimalFormat find = new DecimalFormat("###.##");

    System.out.println("Introdueix els noms dessitjats:");

    while (!noms1.equals("x")){                             
        noms1 = System.console().readLine();
        noms[posn] = noms1;
        dorsal1 = "Dorsal "+(posd+1);
        dorsal[posd] = dorsal1;
        posd++;
        posn++;
    }
    
    pes = System.currentTimeMillis();
    posn= posn-1;
    posd= posd-1;
    System.out.println("-----------------------------------------------------------------------");
    System.out.println("Posicions:");

    while (p!=posd){                             
        System.out.println(noms[n]+ ": " +dorsal[p]);
        p++;
        n++;
    }
    System.out.println("-----------------------------------------------------------------------");

    while((noms.length-(999-n))>num){                      
    
        wala=Integer.parseInt(System.console().readLine("Introdueix el dorsal: "));
        pes2 = System.currentTimeMillis();
        pes3 = pes2-pes;
        System.out.println(noms[wala-1]+" a quedat en la posició "+num);
        num++;
        System.out.println("A trigat: "+find.format((float)pes3/1000)+"s");



    }

    }
}