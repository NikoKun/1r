
class Ex2LlargadaFrase{
    public static void main(String[] args) {
    String frase;
    int i=0;
    frase = System.console().readLine();
    char num[] = frase.toCharArray();

    while (i<num.length) {
        i++;
    }
    System.out.println("La frase té "+i+" caràcters.");


    }
}