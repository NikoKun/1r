
class Ex5PreguntesAmbPuntuacio{
    public static void main(String[] args) {
    String pre1;
    String pre2;
    String pre3;

    int punt = 0;

    pre1 = System.console().readLine("Escriu el nom de un noi: ");
    if (pre1.equals("Nico")){
        punt++;
    }
    pre2 = System.console().readLine("Escriu el nom de una noia: ");
    if (pre2.equals("Erola")){
        punt++;
    }
    pre3 = System.console().readLine("Escriu el nom de un rus: ");
    if (pre3.equals("Timur")){
        punt++;
    }

    System.out.println("La teva puntuació és: "+punt);


    }
}