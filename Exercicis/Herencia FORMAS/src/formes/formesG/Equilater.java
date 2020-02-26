package formes.formesG;

public class Equilater extends Triangle{


//-------------------------------------------------------------------------------------
public Equilater(String unitatMesura, float base, float altura) {
    super(unitatMesura, base, altura);
}

//-------------------------------------------------------------------------------------

@Override
    public void calcular() {
        this.altura = ((float) Math.pow(base*3,2) / 2) * this.base;
        this.area = (this.base * this.altura) / 2;
        this.perimetre = (this.base * 3);
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