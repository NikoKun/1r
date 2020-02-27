package formes.formesG;

public class Rectangle implements Formes{
    float perimetre, area, x, y;
    String unitatMesura;

    public Rectangle(String unitatMesura, float x, float y) {
        this.unitatMesura = unitatMesura;
        this.x = x;
        this.y = y;
    }

//-------------------------------------------------------------------------------------

    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }


    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

//-------------------------------------------------------------------------------------
    
    @Override
    public void calcular() {
        this.area = this.x * this.y;
        this.perimetre = (this.x + this.y) * 2;
    }


    @Override
    public void printa() {
        System.out.println("Forma: "+getClass().getSimpleName());
        System.out.println("Amplada: "+df.format(this.x)+unitatMesura);
        System.out.println("Alçada: "+df.format(this.y)+unitatMesura);
        System.out.println("Perimetre: "+df.format(this.perimetre)+unitatMesura);
        System.out.println("Area: "+df.format(this.area)+" "+unitatMesura+"²");
    }

}