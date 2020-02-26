package formes.formesG;

public class Isosceles extends Triangle{


//-------------------------------------------------------------------------------------
public Isosceles(String unitatMesura, float base, float altura) {
    super(unitatMesura, base, altura);
}

//-------------------------------------------------------------------------------------



@Override
    public void calcular() {
        float hypo =(float) (Math.sqrt(Math.pow(this.base, 2) + Math.pow(this.altura, 2)))*2;
        this.area =  (this.base * this.altura) / 2;
        this.perimetre = (hypo * 2) + this.base;
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