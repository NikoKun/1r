public class PasarDeFloatAString{
    public static void main(String[] args) {
        float v1;
        float v2;
        System.out.println("Introdueix el primer número:");
        v1 = Float.parseFloat(System.console().readLine()); //El text 'Float.parseFloat(variable)' ens permet canviar de una variable tipus Float a una String amb un contingut de text

        System.out.println("Introdueix el segon número:");
        v2 = Float.parseFloat(System.console().readLine());



        System.out.println("El resultat de la suma és: "+((int)v1+(int)v2));
        System.out.println("El resultat de la resta és: "+((int)v1-(int)v2));
        System.out.println("El resultat de la divisió és: "+(v1/v2));
        System.out.println("El resultat de la multiplicació és: "+(v1*v2));
    }
}