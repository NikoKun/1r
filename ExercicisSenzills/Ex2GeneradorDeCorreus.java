package ExercicisSenzills;

public class Ex2GeneradorDeCorreus {
    public static void main(String[] args) {
        String nom;
        String cog;
        String dom;

        System.out.println("Introdueix el teu nom:");
        nom = System.console().readLine(); 

        System.out.println("Introdueix el teu cognom:");
        cog = System.console().readLine();

        System.out.println("Introdueix el domini dessitjat:");
        dom = System.console().readLine();

        System.out.println("El teu correu és: "+nom+cog+"@"+dom);
    }
}
       