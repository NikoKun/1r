package formes;

import java.util.ArrayList;

import formes.formesG.Cercle;
import formes.formesG.Equilater;
import formes.formesG.Escale;
import formes.formesG.Formes;
import formes.formesG.Rectangle;
import formes.formesG.Isosceles;

public class Principal {
    static String sep = "----------------------------------------------------------------";

    public static void main(String[] args) throws Exception {
        float formes[] = { 0.0f, 0.0f };
        String mesura = "0";
        boolean finalitza = false;
        boolean finalitzaOno = false;
        int num = 0;

        while (!finalitza){
            finalitzaOno = false;
            while (!finalitzaOno){
            ArrayList<Formes> obj = new ArrayList<Formes>(); 
            System.out.println(sep);
            System.out.println("Benvingut al principi del programa!!!!");
            System.out.println(sep);

            System.out.println("Digues el número de formes que vols calcular: ");
            num = Integer.parseInt(System.console().readLine());

            for (int i=0; i<num; i++){
                System.out.println();
                System.out.println(sep);
                System.out.println("1 - Quadrat");
                System.out.println("2 - Cercle");
                System.out.println("3 - Triangle");
                System.out.println("----");
                System.out.println();
                System.out.println("Digues el tipus de forma que vols calcular: ");
                int opcio = Integer.parseInt(System.console().readLine());

                switch (opcio){
                    case 1:
                        System.out.println(sep);
                        System.out.println("Digues el tipus de mesura que vols utilitzar: (mm, cm, m ...)");
                        mesura = System.console().readLine();
                        System.out.println();
                        System.out.println("Digues la alçada: ");
                        formes[0] = Float.parseFloat(System.console().readLine());
                        System.out.println();
                        System.out.println("Digues la amplada: ");
                        formes[1] = Float.parseFloat(System.console().readLine());

                        Rectangle formQ = new Rectangle(mesura, formes[0], formes[1]);
                        formQ.calcular();
                        obj.add(formQ);
                    break;
                    case 2:
                        System.out.println(sep);
                        System.out.println("Digues el tipus de mesura que vols utilitzar: (mm, cm, m ...)");
                        mesura = System.console().readLine();
                        System.out.println();
                        System.out.println("Digues el seu radi: ");
                        formes[0] = Float.parseFloat(System.console().readLine());

                        Cercle formC = new Cercle(mesura, formes[0]);
                        formC.calcular();
                        obj.add(formC);
                    break;
                    case 3:
                        System.out.println(sep);
                        System.out.println();
                        System.out.println(sep);
                        System.out.println("1 - Isosceles");
                        System.out.println("2 - Escalé");
                        System.out.println("3 - Equilater");
                        System.out.println("----");
                        System.out.println();
                        System.out.println("Digues el tipus de triangle que vols fer: ");
                        int op = Integer.parseInt(System.console().readLine());
                        switch (op){
                            case 1:
                            // isosceles
                                System.out.println("Digues el tipus de mesura que vols utilitzar: (mm, cm, m ...)");
                                mesura = System.console().readLine();
                                System.out.println();
                                System.out.println("Digues la base: ");
                                formes[0] = Float.parseFloat(System.console().readLine());
                                System.out.println();
                                System.out.println("Digues l'altura: ");
                                formes[1] = Float.parseFloat(System.console().readLine());
        
                                Isosceles formTI = new Isosceles(mesura, formes[0], formes[1]);
                                formTI.calcular();
                                obj.add(formTI);
                            break;
                            case 2:
                            // escaleno
                                System.out.println("Digues el tipus de mesura que vols utilitzar: (mm, cm, m ...)");
                                mesura = System.console().readLine();
                                System.out.println();

                                System.out.println("Digues la base: ");
                                formes[0] = Float.parseFloat(System.console().readLine());
                                System.out.println();

                                System.out.println("Digues el primer costat: ");
                                float segon = Float.parseFloat(System.console().readLine());
                                System.out.println();

                                System.out.println("Digues el segon costat: ");
                                float tercer = Float.parseFloat(System.console().readLine());
                                System.out.println();

                                Escale formTEs = new Escale(mesura, formes[0], formes[1], segon, tercer);
                                formTEs.calcular();
                                obj.add(formTEs);
                            break;
                            case 3:
                                // equilatero
                                System.out.println("Digues el tipus de mesura que vols utilitzar: (mm, cm, m ...)");
                                mesura = System.console().readLine();
                                System.out.println();
                                System.out.println("Digues la base: ");
                                formes[0] = Float.parseFloat(System.console().readLine());
                                System.out.println();
        
                                Equilater formTE = new Equilater(mesura, formes[0], formes[1]);
                                formTE.calcular();
                                obj.add(formTE);
                            break;
                        }

                    break;
                    default:
                        System.out.println("Forma saltada...");
                    break;
                }
            }
                finalitzaOno = true;
                System.out.println(sep);
                System.out.println("RESULTATS;");
                System.out.println(sep);
                System.out.println();
                for (Formes res : obj) {
                    res.printa();
                    System.out.println();
                }
                System.out.println(sep);
            }

            System.out.println("Vols acavar? (si/no)");
            String fi = System.console().readLine();
    
            if (fi.equalsIgnoreCase("si")){
                finalitza = true;
            }
        }
    }
}