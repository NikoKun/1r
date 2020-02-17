package classes;

import java.time.LocalDate;

public class Client {
    private String nom, cognom, dni, tel, poblacio;
    private LocalDate cumple;

    public Client(String nom, String cognom, String dni, String tel, String poblacio, LocalDate cumple) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
        this.tel = tel;
        this.poblacio = poblacio;
        this.cumple = cumple;
    }

    // ------------------------------------------------------------------------------------------------------------------------

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }


    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getPoblacio() {
        return poblacio;
    }
    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }


    public LocalDate getCumple() {
        return cumple;
    }
    public void setCumple(LocalDate cumple) {
        this.cumple = cumple;
    }



    
}