public class PasarFloatsAInts{
    public static void main(String[] args) {
        float v1 = 3;
        float v2 = 6;

        System.out.println("El resultat de la suma és: "+((int)v1+(int)v2)); //Posar (int) abans de la variable ens permet canviar el seu tipus de float a int.
        System.out.println("El resultat de la resta és: "+((int)v1-(int)v2));
        System.out.println("El resultat de la divisió és: "+(v1/v2));
        System.out.println("El resultat de la multiplicació és: "+(v1*v2));
    }
}