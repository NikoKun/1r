package formes.formesG;

public class Cercle extends Formes{
    final private float pi = 3.1415926535f;
    float radio;

    public Cercle(String unitatMesura, float radio) {
        super(unitatMesura);
        this.radio = radio;
    }

//-------------------------------------------------------------------------------------

    public float getPi() {
        return pi;
    }

    public float getRadio() {
        return radio;
    }
    public void setRadio(float radio) {
        this.radio = radio;
    }

//-------------------------------------------------------------------------------------

    @Override
    public void calcular() {
        this.area = this.radio * pi;
        this.perimetre = 2 * pi * this.radio;
    }
    
    @Override
    public void printa() {
        System.out.println("Forma: "+getClass().getSimpleName());
        System.out.println("Radi: "+df.format(this.radio)+unitatMesura);
        System.out.println("Perimetre: "+df.format(this.perimetre)+unitatMesura);
        System.out.println("Area: "+df.format(this.area)+unitatMesura+"²");
    }

}