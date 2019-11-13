
class Ex6CalculNotes{
    public static void main(String[] args) {
    int pr1;
    int pr2;
    int pr3;
    int pr4;
    int pr5;
    int pr6;

    int suma1;


    pr1 = Integer.parseInt(System.console().readLine("Escriu la primera nota: "));
    pr2 = Integer.parseInt(System.console().readLine("Escriu la segona nota: "));
    pr3 = Integer.parseInt(System.console().readLine("Escriu la tercera nota: "));
    pr4 = Integer.parseInt(System.console().readLine("Escriu la cuarta nota: "));
    pr5 = Integer.parseInt(System.console().readLine("Escriu la cinquena nota: "));

    pr6 = Integer.parseInt(System.console().readLine("Escriu la nota del examen final: "));

   suma1 = (int)((((pr1*0.4)+(pr2*0.4)+(pr3*0.4)+(pr4*0.4)+(pr5*0.4)+(pr6*0.6))/26)*10);
    
    System.out.println("La teva nota final és: "+suma1);


    }
}