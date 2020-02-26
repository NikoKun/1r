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
        float hypo =(float) (Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.altura, 2)))*2;
        this.area = (hypo * 2) + this.base;
        this.perimetre = (this.base * this.altura) / 2;
    }


    @Override
    public void printa() {
        System.out.println();
        System.out.println("Forma: "+getClass().getSimpleName());
        System.out.println("Base: "+df.format(this.base)+unitatMesura);
        System.out.println("Alçada: "+df.format(this.altura)+unitatMesura);
        System.out.println("Perimetre: "+df.format(this.perimetre)+unitatMesura);
        System.out.println("Area: "+df.format(this.area)+unitatMesura+"²");
        System.out.println();
    }
    



}