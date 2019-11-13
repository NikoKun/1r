public class Array{
    public static void main(String[] args) {
        System.out.println("Introdueix un primer nom: ");
        String nom0 = System.console().readLine();

        System.out.println("Introdueix segon un nom: ");
        String nom1 = System.console().readLine();

        System.out.println("Introdueix tercer un nom: ");
        String nom2 = System.console().readLine();


        String arrayNoms[]={nom0,nom1,nom2}; //La posició 0 de la array sempre serà el seu primer valor no la posició 1


        int posicio = (int)System.currentTimeMillis()%3; //De aquesta forma agafem els milisegons i agafem un residú màxim de 3 per realitzar la operació aleatoria
        System.out.println("-----------------------------------------------------------------------");

        System.out.println("El nom en la posició aleatoria és: "+arrayNoms[posicio]);

        System.out.println("El nom en la posició 0 és: "+arrayNoms[0]);
        System.out.println("El nom en la posició 1 és: "+arrayNoms[1]);
        System.out.println("El nom en la posició 2 és: "+arrayNoms[2]);
        System.out.println("-----------------------------------------------------------------------");
        
    }
}