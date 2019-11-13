import java.util.Random;

public class DoWhile{
    public static void main(String[] args) {

        Random r = new Random();
        int array[] = new int[10];
        int array2[] = new int[10];

        for(int i=0; i<array.length; i++){
            array [i] = r.nextInt(10);
            System.out.prontln(array[i]);
        }
        for(int i=10; i<0; i--){
            array [i] = r.nextInt(10);
            System.out.prontln(array[i]);
        }




        // do {
        //    System.out.print("Count is: "+ count);                       
        //     count ++;
        // }while(count < 10);


    }
}