package supermercat.templates;

import java.time.LocalDate;

import supermercat.generic.Support;

public class ProdAmbCaducitat extends Producte {
    private LocalDate dataCaducitat;

    public ProdAmbCaducitat(String nom, float preu, LocalDate dataCaducitat) {
        super(nom, preu);
        this.dataCaducitat = dataCaducitat;
    }

    // ----------------------------------------------------------------------

    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    // ----------------------------------------------------------------------

    @Override
    public String toString() {
        return super.toString() + " Caducitat: " + dataCaducitat.toString();
    }
    

    @Override
    public float calcular(int quantitat) {
        float preuFinal = super.calcular(quantitat);
        int diesCaducitat = Support.calculaDies(this.dataCaducitat);
        switch (diesCaducitat) {
        case 1:
            preuFinal -= (preuFinal * 0.75f);
            System.out.println("Descompte del 75%");
            break;
        case 2:
            preuFinal -= (preuFinal * 0.5f);
            System.out.println("Descompte del 50%");
            break;
        case 3:
            preuFinal -= (preuFinal * 0.25f);
            System.out.println("Descompte del 25%");
            break;
        case 4:
            preuFinal -= (preuFinal * 0.1f);
            System.out.println("Descompte del 10%");
            break;
        }
        System.out.println("Preu articles: "+preuFinal);
        return preuFinal;
    }

}