package supermercat.generic;

import java.time.LocalDate;
import java.time.Period;

public class Support{

    public static int calculaDies(LocalDate caducitat){
        Period p = Period.between( LocalDate.now(),caducitat);
        int dies = p.getDays();
        System.out.println("Dies perquè caduqui: "+dies);
        return dies;
    }






}