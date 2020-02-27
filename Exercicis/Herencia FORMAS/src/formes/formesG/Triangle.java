package formes.formesG;

public abstract class Triangle extends Formes{
    float base, altura;

    public Triangle(String unitatMesura, float base, float altura) {
        super(unitatMesura);
        this.base = base;
        this.altura = altura;
    }
}