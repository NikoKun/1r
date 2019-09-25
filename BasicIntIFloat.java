public class BasicIntIFloat{
    public static void main(String[] args) {
        final int DIES_SETMANA = 7;  //Al posar 'final' abans de la variable, la declara com a no canviant;
        int primerValor = 4; //int = valors sense decimals
        int segonValor = 6;
        int resultat;
        resultat=primerValor+segonValor;
        System.out.println("El resultat és:"+resultat);


        
        final float fDIES_SETMANA = 7;
        float fprimerValor = 4; 
        float fsegonValor = 6;
        float fresultat;
        fresultat=fprimerValor+fsegonValor;
        System.out.println("El resultat f és:"+fresultat);
    }
}