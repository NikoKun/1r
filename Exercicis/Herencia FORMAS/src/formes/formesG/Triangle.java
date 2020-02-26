package formes.formesG;

public abstract class Triangle extends Formes{
    float base, altura;

    public Triangle(String unitatMesura, float base, float altura) {
        super(unitatMesura);
        this.base = base;
        this.altura = altura;
    }

//-------------------------------------------------------------------------------------

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

//-------------------------------------------------------------------------------------

    @Override
    public void calcular() {
    }


    @Override
    public void printa() {
    }
    



}