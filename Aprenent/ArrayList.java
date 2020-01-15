import java.util.ArrayList;

public class ArrayList{
    public static void main(String[] args) {
        ArrayList<String> al1 = new ArrayList<String>();
        ArrayList<String> al2 = new ArrayList<String>();

        ArrayList< ArrayList<String> > al = new ArrayList< ArrayList<String> >();


        al1.add("Nico");   
        al2.add("Timur");   

        al.add(al1);
        al.add(al2);


        al.get(0).get(0);



        // al1.add("HOLA");                             -- Añade Hola a la primera posicion de la array
        // al1.add(1, "HOLA");                          -- Añade Hola a la segona posicion de la array


        // for(String paraula : al1){
        //     System.out.println(paraula);
        // }

    }
}