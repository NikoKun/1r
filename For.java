public class For{
    public static void main(String[] args) {
       int iteracio = 0;
       String llista[] = {"Maria","Timur","Erola"};         //Declarem la array amb 3 noms.


       for(iteracio=0; iteracio<llista.length; iteracio++){                       
           System.out.println("Iteració: "+llista[iteracio]);       
       }

       System.out.println("Ja!!!");

    }
}