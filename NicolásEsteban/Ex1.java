
class Ex1{
    public static void main(String[] args) {
 
        int edat;

        edat = Integer.parseInt(System.console().readLine("Introdueix la teva edat: "));

        if (edat<18){
            System.out.println("Hauras d'esperarte "+(18-edat)+" anys per sacarte el carnet.");
        }

        else{
            System.out.println("Ja et pots treure el carnet de conduir perqué ja ets major d'edat");
        }

    }
}