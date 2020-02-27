package formes.formesG;

public abstract class Triangle implements Formes{
    float perimetre, area, base, altura;
    String unitatMesura;

    public Triangle(String unitatMesura, float base, float altura) {
        this.unitatMesura = unitatMesura;
        this.base = base;
        this.altura = altura;
    }


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


    public float getBase() {
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }


    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }


    public String getUnitatMesura() {
        return unitatMesura;
    }
    public void setUnitatMesura(String unitatMesura) {
        this.unitatMesura = unitatMesura;
    }
}