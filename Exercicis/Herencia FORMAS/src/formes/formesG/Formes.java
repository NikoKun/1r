package formes.formesG;

import java.text.DecimalFormat;

public abstract class Formes {
    float perimetre, area;
    String unitatMesura;
    protected static DecimalFormat df = new DecimalFormat("#.##");



    public Formes(String unitatMesura) {
        this.unitatMesura = unitatMesura;
    }

//-------------------------------------------------------------------------------------

    public float getPerimetre() {
        return perimetre;
    }
    public void setPerimetre(float perimetre) {
        this.perimetre = perimetre;
    }


    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }


    public String getUnitatMesura() {
        return unitatMesura;
    }
    public void setUnitatMesura(String unitatMesura) {
        this.unitatMesura = unitatMesura;
    }

//-------------------------------------------------------------------------------------

    public void calcular() {

    }

    public void printa() {
        // printar cosas en cada classe
    }
}