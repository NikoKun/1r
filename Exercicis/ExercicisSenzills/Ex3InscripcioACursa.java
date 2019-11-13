package ExercicisSenzills;

public class Ex3InscripcioACursa {
    public static void main(String[] args) {
        String nom;
        float edat;
        String sexe;

        System.out.println("Introdueix el teu nom:");
        nom = System.console().readLine(); 

        System.out.println("Introdueix la teva edat:");
        edat = Float.parseFloat(System.console().readLine());

        System.out.println("Introdueix el teu sexe escriguent 'Home' o 'Dona':");
        sexe = System.console().readLine();


        if (edat<16){
            if (sexe.equals("Home")){
                System.out.println(nom+ " la teva categoria és Juvenil masculí.");
            }



            else if (sexe.equals("Dona")) {
                System.out.println(nom+" la teva categoria és Juvenil femení.");

            }

            else {
                System.out.println("No a quedat clar el teu sexe.");           
            }

        }   






        else if (edat<65) {
            if (sexe.equals("Home")){
                System.out.println(nom+" la teva categoria és Sènior masculí.");
            }



            else if (sexe.equals("Dona")) {
                System.out.println(nom+" la teva categoria és Sènior femení.");

            }

            else {
                System.out.println("No a quedat clar el teu sexe.");           
            }

        }   



        else if (edat>65) {
            if (sexe.equals("Home")){
                System.out.println(nom+" la teva categoria és Veterà masculí.");
            }



            else if (sexe.equals("Dona")) {
                System.out.println(nom+" la teva categoria és Veterà femení.");

            }

            else {
                 System.out.println("No a quedat clar el teu sexe.");           
            }

        }   
 



        else {
            System.out.println("No a quedat clara la teva edat.");           

        }
     }
}