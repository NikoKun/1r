package ExercicisSenzills;

public class Ex1CalculadoraDeMassa {
    public static void main(String[] args) {
        float pes;
        float est;
        float res;

        System.out.println("Introdueix el teu pes:");
        pes = Float.parseFloat(System.console().readLine()); 

        System.out.println("Introdueix la teva alçada:");
        est = Float.parseFloat(System.console().readLine());

        res = pes / (est * est);

        System.out.println("La teva massa és: "+res);

        if (res<18.5){
            System.out.println("Ves al metge.");
        }   
        else if (res<24.9) {
            System.out.println("Tens un baix pes.");
        }
           
        else if (res<29.9) {
            System.out.println("Tens un normal i saludable.");
        }
           else if (res<30) {
            System.out.println("Ja tens sobrepes.");
        }   
            else {
                System.out.println("Tens obesitat, ves al metge.");
            }
     }
}