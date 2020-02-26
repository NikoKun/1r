package formes.formesG;

public class Escale extends Triangle{
float tercer, segon;

//-------------------------------------------------------------------------------------
public Escale(String unitatMesura, float base, float altura, float segon, float tercer) {
    super(unitatMesura, base, altura);
    this.tercer = segon;
    this.tercer = tercer;
}

//-------------------------------------------------------------------------------------
    public float getTercer() {
        return tercer;
    }
    public void setTercer(float tercer) {
        this.tercer = tercer;
    }


    public float getSegon() {
        return segon;
    }
    public void setSegon(float segon) {
        this.segon = segon;
    }




    @Override
    public void calcular() {
        this.altura = ((float) (Math.pow(base,2)+Math.pow(this.segon,2)+Math.pow(this.tercer,2)) / 2) * this.base;
        this.area = (this.base * this.altura) / 2;
        this.perimetre = (this.base + this.segon + this.tercer);
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