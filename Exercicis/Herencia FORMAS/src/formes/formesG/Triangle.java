package formes.formesG;

public class Triangle extends Formes{
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
        // calcular hipotenusa
        // perimetro = (hipotenusa * 2) * base
        this.area = (this.base * this.altura) / 2;

    }


    @Override
    public void printa() {
        System.out.println();
        System.out.println("Forma: "+getClass().getSimpleName());
        System.out.println("Base: "+this.base+unitatMesura);
        System.out.println("Alçada: "+this.altura+unitatMesura);
        System.out.println("Perimetre: "+this.perimetre+unitatMesura);
        System.out.println("Area: "+this.area+unitatMesura+"²");
        System.out.println();
    }
    



}