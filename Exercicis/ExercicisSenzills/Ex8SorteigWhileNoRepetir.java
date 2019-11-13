package ExercicisSenzills;

public class Ex8SorteigWhileNoRepetir {
    public static void main(String[] args) {
        int i=0;
        int num1=0; 
        int num2=0;
        boolean save = true;
        int repetit=0;
        int cont=0;
        int vegades=0;
        
 
        int [] array = new int[10000];
        num1 = (int) (Math.random()*1000);
        num2 = (int) (Math.random()*1000);

        while (num1!=num2){
            for (i = 0;i<array.length;i++){
                save=true;
                if(array[i]==num2){
                    save=false;
                    repetit++;
                    break;
                }
            }
            if (save=true){
                array[cont]=num2;
                cont ++;
                vegades++;
            }
            num2 = (int) (Math.random()*1000);
        }
 
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("El número a endivinar era: "+num1);
        System.out.println("A trigat "+vegades+" i a repetit "+repetit+" cops.");
        System.out.println("-----------------------------------------------------------------------");

    }
}