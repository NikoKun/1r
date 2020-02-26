package supermercat;

import java.time.LocalDate;
import java.util.ArrayList;

import supermercat.templates.ProdAmbCaducitat;
import supermercat.templates.ProdSenseCaducitat;
import supermercat.templates.Producte;

public class Supermercat {
    public static void main(String[] args) throws Exception {

        ArrayList<Producte> alp = new ArrayList<>();
        alp.add(new Producte("Coche",1f));
        alp.add(new ProdAmbCaducitat("Manzanas",2f, LocalDate.of(2020,2,22)));
        alp.add(new ProdSenseCaducitat("Silla",3f, "Moble"));


        float total = 0;
        for (Producte pr : alp){
            total += pr.calcular(10);
        }

        System.out.println("El total és: "+total);


                      

    }
}