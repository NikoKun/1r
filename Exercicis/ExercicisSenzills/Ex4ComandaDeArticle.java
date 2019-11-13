package ExercicisSenzills;

import java.text.DecimalFormat;

public class Ex4ComandaDeArticle {
    public static void main(String[] args) {
        String art;
        float preu;
        float descompte;
        float res;

        System.out.println("Introdueix el nom de l'article:");
        art = System.console().readLine(); 

        System.out.println("Introdueix el seu preu original en euros:");
        preu = Float.parseFloat(System.console().readLine());

        System.out.println("Introdueix el percentatge de descompte a aplicar:");
        descompte = Float.parseFloat(System.console().readLine());

        res = preu-((descompte/100)*preu);
        
        DecimalFormat formato = new DecimalFormat("###.##");

        
        System.out.println("El preu final de l'article" +art+ "és: " +formato.format(res)+ "€");

     }
}