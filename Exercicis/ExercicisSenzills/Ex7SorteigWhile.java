package ExercicisSenzills;

public class Ex7SorteigWhile {
    public static void main(String[] args) {
        int num; 
        int prova=0;
        int vegades=0;
        num = (int)(Math.random() * 999 + 1);


        while(num!=prova){
            prova = (int)(Math.random() * 999 + 1);      
            System.out.println(prova);
            vegades++;
        }

        System.out.println("Ja!!! Ha tardat "+vegades+" vegades i el número era "+num+".");

    }
}