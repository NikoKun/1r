public class BasicCalculadora{
    public static void main(String[] args) {
        float primerValor = 5;
        float segonValor = 7;

        float resultatSuma;
        resultatSuma=primerValor+segonValor;
        System.out.println("La suma entre "+primerValor+" i "+segonValor+" és: "+resultatSuma);

        float resultatResta;
        resultatResta=primerValor-segonValor;
        System.out.println("La resta entre "+primerValor+" i "+segonValor+" és: "+resultatResta);

        float resultatMult;
        resultatMult=primerValor*segonValor;
        System.out.println("La multiplicació entre "+primerValor+" i "+segonValor+" és: "+resultatMult);

        float resultatDiv;
        resultatDiv=primerValor/segonValor;
        System.out.println("La suma divisió "+primerValor+" i "+segonValor+" és: "+resultatDiv);
    }
}