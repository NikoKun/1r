import java.util.Random;
public class ArrayBidimensional{
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        int files[][] = new int[3][4];
        Random num1 = new Random(); 


        for(i=0; i<files.length; i++){
            System.out.println();
            System.out.print("\n");
            for(j=0; j<files[0].length; j++){
                files[i][j] = num1.nextInt(5);
                System.out.print(files[i][j]);
            }
        }
        

        
    }
}