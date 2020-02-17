package app.classes;

public class Persona{
    private int edat;
    private float altura, pes, distanciaRecorreguda;
    private String DNI;

    

    public Persona(int edat, float distanciaRecorreguda) {
        this.edat = edat;
        this.distanciaRecorreguda = distanciaRecorreguda;
    }



    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }


    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }


    public float getPes() {
        return pes;
    }
    public void setPes(float pes) {
        this.pes = pes;
    }


    public float getDistanciaRecorreguda() {
        return distanciaRecorreguda;
    }
    public void setDistanciaRecorreguda(float distanciaRecorreguda) {
        this.distanciaRecorreguda = distanciaRecorreguda;
    }


    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        this.DNI = dNI;
    }


    // ------------------------------------------------------------------------------------------


    public void recorreXMetres(float metres){
        this.distanciaRecorreguda = this.distanciaRecorreguda + metres;
        // return this.distanciaRecorreguda;
    }


    public void mostrarInfo(){
        System.out.println("DNI: "+this.DNI);
        System.out.println("Edat: "+this.edat);
        System.out.println("Altura: "+this.altura);
        System.out.println("Pes: "+this.pes);
    }



}