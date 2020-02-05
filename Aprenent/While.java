public class While{
    public static void main(String[] args) {
       int iteracio = 0;
       int fin = 5;
       String llista[] = {"Maria","Timur","Erola"};         //Declarem la array amb 3 noms.

       while(iteracio<llista.length){                       //El valor asignat a la array '.lenght' ens agafa la quantitat de dades que te com a número propi.
           System.out.println("Iteració: "+iteracio);       //Executa des de la posició 0 perqué iteracio=0.
           iteracio++;
       }


//       while(iteracio<llista.length){                       //Si esborrem el While superior, aquestes línies ens mostrarien els 3 noms de la array.
//       System.out.println((llista[iteracio]));    //Al posar la array mostrarem els noms...   
//       iteracio++;
//   }

       System.out.println("Ja!!!");

    }
}