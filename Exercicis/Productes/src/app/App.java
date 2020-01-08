package app;

public class App {
    public static void main(String[] args) throws Exception {
        String productes[][] = new String[4][100];
        //1-Referencia    2-Nombre    3-Precio    4-Unidades

        String frases1[] = {"Digues la referencia: ","Digues el nom: ","Digues el preu (€): ","Digues les unitats: "};
        String sep = "--------------------------------------------------------------------------------------------";

        int coll;
        int camp;


        int pos = 0;
        int posIns = 0;

        boolean acaba = false;
        boolean acabaIns = false;

        String opcio;
        String opcioIns;


        while (acaba == false){
            System.out.println(sep);
            System.out.println("Sí, això és un menú...");
            System.out.println(sep);
            System.out.println("1. Afegir una línia");
            System.out.println("2. Eliminar una línia");
            System.out.println("3. Modificar un camp");
            System.out.println("4. Printar totes les línies");
            System.out.println("5. Sortir del programa");
            System.out.println(sep);
    
            opcio = System.console().readLine("Selecciona la opció: ");
    
            switch (opcio) {
                case "1":
                    acabaIns = false;
                    while (acabaIns == false){
                        System.out.println(sep);
                        System.out.println("La liniua que estàs afegint és la "+(pos+1));
                        for (int j=0; j<4; j++){
                            productes[j][pos] = System.console().readLine(frases1[j]+"");
                        }
                        pos++;
                        opcioIns = System.console().readLine("Vols continuar? (s/n) ");
                        if (opcioIns.equals("n")){
                            acabaIns = true;
                        }

                        
                    }
                break;
    
    
    
    
                case "2":
                    System.out.println(sep);
                    coll = Integer.parseInt(System.console().readLine("Digues quina línia vols eliminar: "));
                    for (int i=0; i<4; i++){
                        for (int j=(coll-1); j<pos; j++){
                            productes[i][j] = productes[i][(j+1)];
                        }
                    }
                    pos--;
                    posIns = 0;
                    System.out.println(sep);
                    System.out.println("REF\t - \tNOM\t - \tPREU\t - \tUNI");
                    System.out.println(sep);
                    for (int j=0; j<pos; j++){
                        posIns++;
                        System.out.print((posIns)+"\t - \t");
                        for (int i=0; i<4; i++){
                            System.out.print(productes[i][j]);
                            if (i==2){
                                System.out.print("€");
                            }
                            System.out.print("\t - \t");
                        }
                        System.out.println("");               
                    }
                break;




                case "3":
                posIns = 0;
                System.out.println(sep);
                System.out.println("POS\t - \tREF\t - \tNOM\t - \tPREU\t - \tUNI");
                System.out.println(sep);
                for (int j=0; j<pos; j++){
                    posIns++;
                    System.out.print((posIns)+"\t - \t");
                    for (int i=0; i<4; i++){
                        System.out.print(productes[i][j]);
                        if (i==2){
                            System.out.print("€");
                        }
                        System.out.print("\t - \t");
                    }
                    System.out.println("");               
                }

                coll = Integer.parseInt(System.console().readLine("Digues de quina línia vols editar: "));
                camp = Integer.parseInt(System.console().readLine("Digues quin camp vols editar: "));
                productes[(camp-1)][(coll-1)] = System.console().readLine("Per a qué ho vols substituir? ");

                posIns = 0;
                System.out.println(sep);
                System.out.println("POS\t - \tREF\t - \tNOM\t - \tPREU\t - \tUNI");
                System.out.println(sep);
                for (int j=0; j<pos; j++){
                    posIns++;
                    System.out.print((posIns)+"\t - \t");
                    for (int i=0; i<4; i++){
                        System.out.print(productes[i][j]);
                        if (i==2){
                            System.out.print("€");
                        }
                        System.out.print("\t - \t");
                    }
                    System.out.println("");               
                }
                break;
    



                case "4":
                    posIns = 0;
                    System.out.println(sep);
                    System.out.println("POS\t - \tREF\t - \tNOM\t - \tPREU\t - \tUNI");
                    System.out.println(sep);
                    for (int j=0; j<pos; j++){
                        posIns++;
                        System.out.print((posIns)+"\t - \t");
                        for (int i=0; i<4; i++){
                            System.out.print(productes[i][j]);
                            if (i==2){
                                System.out.print("€");
                            }
                            System.out.print("\t - \t");
                        }
                        System.out.println("");               
                    }
                break;



                case "5":
                    acaba = true;
                break;
    
    
            }
        }
        





    }
}