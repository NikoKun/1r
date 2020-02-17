package classes;


public class Producte {
    String id, nomProducte;
    int stock;
    float preu;

    public Producte(String id, String nomProducte, int stock, int preu) {
        this.id = id;
        this.nomProducte = nomProducte;
        this.stock = stock;
        this.preu = preu;
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getNomProducte() {
        return nomProducte;
    }
    public void setNomProducte(String nomProducte) {
        this.nomProducte = nomProducte;
    }


    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }


    public float getPreu() {
        return preu;
    }
    public void setPreu(float preu) {
        this.preu = preu;
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public void sumarStock(int stocki) {
        this.stock += stocki;
    }
    public void restaStock(int stocki) {
        this.stock -= stocki;
    }





    
}