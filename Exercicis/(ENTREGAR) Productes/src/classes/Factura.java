package classes;

import classes.Client;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Factura {
    private String id;
    private LocalDateTime data;
    private ArrayList<Linia> linies = new ArrayList<Linia>();
    private Client client;

    public Factura(String id, LocalDateTime data, ArrayList<Linia> linies, Client client) {
        this.id = id;
        this.data = data;
        this.linies = linies;
        this.client = client;
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }


    public ArrayList<Linia> getLinies() {
        return linies;
    }
    public void setLinies(ArrayList<Linia> linies) {
        this.linies = linies;
    }


    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }










    
}