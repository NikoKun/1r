
class Ex2{
    public static void main(String[] args) {
 
        String us1;
        String us2;

        int edat1;
        int edat2;
        
        System.out.println("Usuari1: Introdueix el teu nom:");
        us1 = System.console().readLine();
        System.out.println("Introdueix la teva edat");
        edat1 = Integer.parseInt(System.console().readLine());


        System.out.println("Usuari2: Introdueix el teu nom:");
        us2 = System.console().readLine();
        System.out.println("Introdueix la teva edat");
        edat2 = Integer.parseInt(System.console().readLine());



        
        if (edat1<edat2){
            System.out.println(us2+ " és "+(edat2-edat1)+" anys més gran que "+us1);
        }

        else{
            System.out.println(us1+ " és "+(edat1-edat2)+" anys més gran que "+us2);
        }

    }
}