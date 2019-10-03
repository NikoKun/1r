
class Ex3{
    public static void main(String[] args) {
    
        float us1;

        System.out.println("Introdueix la teva nota:");
        us1 = Float.parseFloat(System.console().readLine());


        if (us1<0){
            System.out.println("Aquest número no és factible.");
        }
        else if (us1<3){
            System.out.println("Nota: Molt deficient.");
            System.out.println("No t'has mirat res!");
        }

        else if (us1<4){
            System.out.println("Nota: Insuficient.");
            System.out.println("Tot i que has sapigut fer algunes coses encara falta per aprovar.");
        }
        else if (us1<5){
            System.out.println("Nota: Insuficient alt.");
            System.out.println("Ànims... Et falta poc per aprovar!");
        }
        else if (us1<6){
            System.out.println("Nota: Suficient.");
            System.out.println("Has aprovat però justet. No et confiis!");
        }
        else if (us1<8){
            System.out.println("Nota: Notable.");
            System.out.println("La teva evolució és bona! Endevant.");
        }
        else if (us1<11){
            System.out.println("Nota: Excel·lent.");
            System.out.println("Felicitats!!! Arribes a l'Excel·lència!!");
        }

        else {
            System.out.println("Aquest número no és factible.");

        }

    }
}