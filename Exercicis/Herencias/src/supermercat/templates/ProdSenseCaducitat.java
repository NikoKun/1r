package supermercat.templates;



public class ProdSenseCaducitat extends Producte{

    private String tipus;

    public ProdSenseCaducitat(String nom, float preu, String tipus) {
        super(nom, preu);
        this.tipus = tipus;
    }

    //----------------------------------------------------------------------

    public String getTipus() {
        return tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    
    //----------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString()+" tipus = "+this.tipus;
    }
}