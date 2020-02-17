package classes;

public class Usuaris{
    private String nom, cognom, nomUsuari, contrasenya, correu;
    private int edat, tel;
    private char sexe;


    public Usuaris(String nomUsuari, String contrasenya, String correu) {
        this.nomUsuari = nomUsuari;
        this.contrasenya = contrasenya;
        this.correu = correu;
    }




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


    public String getNomUsuari() {
        return nomUsuari;
    }
    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }


    public String getContrasenya() {
        return contrasenya;
    }
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }


    public String getCorreu() {
        return correu;
    }
    public void setCorreu(String correu) {
        this.correu = correu;
    }


    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }


    public int getTel() {
        return tel;
    }
    public void setTel(int tel) {
        this.tel = tel;
    }


    public char getSexe() {
        return sexe;
    }
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }
    
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------





}