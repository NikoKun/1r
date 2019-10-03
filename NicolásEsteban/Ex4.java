import java.util.Random;

class Ex4{
    public static void main(String[] args) {
 

        Random num1 = new Random();
        int un[] = new int[10];
        int un1[] = new int[100];
        int un2[] = new int[1000];

        int un00=0;
        int un01=0;

        int un10=0;
        int un11=0;

        int un20=0;
        int un21=0;


        int i = 0;


        for(i=0;i<10;i++) {
            int num2 = num1.nextInt(2);
            un[i] = num2;
        }

        for(i=0;i<100;i++) {
            int num2 = num1.nextInt(2);
            un1[i] = num2;
        }

        for(i=0;i<1000;i++) {
            int num2 = num1.nextInt(2);
            un2[i] = num2;
        }


        for(i=0;i<un.length;i++){
            if(un[i]==0){
                un00++;
            }
            else{
                un01++;
            }
        }
        
        for(i=0;i<un1.length;i++){
            if(un1[i]==0){
                un10++;
            }
            else{
                un11++;
            }
        }

        for(i=0;i<un2.length;i++){
            if(un2[i]==0){
                un20++;
            }
            else{
                un21++;
            }
        }


        System.out.println("A l'array 1 (longitud 10) hi han "+un00+" monedes en cara i "+un01+" en creu.");
        System.out.println("A l'array 2 (longitud 100) hi han "+un10+" monedes en cara i "+un11+" en creu.");
        System.out.println("A l'array 3 (longitud 100) hi han "+un20+" monedes en cara i "+un21+" en creu.");


    }
}