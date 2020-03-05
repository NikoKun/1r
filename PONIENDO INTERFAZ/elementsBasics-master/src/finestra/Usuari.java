package finestra;

public class Usuari{
    String nomUsuari;
    String password;

    public Usuari(String nomUsuari, String password) {
        this.nomUsuari = nomUsuari;
        this.password = password;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    @Override
    public String toString() {
        return nomUsuari;
    }
   

    
    
    

}