package classes;

import classes.Producte;


public class Linia {
    private Producte producte;
    private int quantitat;
    private float preuFinal;

    public Linia(Producte producte, int quantitat, float preuFinal) {
        this.producte = producte;
        this.quantitat = quantitat;
        this.preuFinal = preuFinal;
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public Producte getProducte() {
        return producte;
    }
    public void setProducte(Producte producte) {
        this.producte = producte;
    }


    public int getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }


    public float getPreuFinal() {
        return preuFinal;
    }
    public void setPreuFinal(float preuFinal) {
        this.preuFinal = preuFinal;
    }





    public void canviaPreu(float preuFinal) {
        this.preuFinal -= preuFinal;
    }
    











}