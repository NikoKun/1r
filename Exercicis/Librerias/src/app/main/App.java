package app.main;
import app.funcions.*;
import app.classes.*;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("------------------------------------------------------------------------------------------"); 
        Persona niko = new Persona(10, 0);
        niko.setDNI("123456789A");
        niko.mostrarInfo();

        niko.recorreXMetres(5.4f);
        System.out.println("Distancia recorreguda: "+niko.getDistanciaRecorreguda());


        System.out.println("------------------------------------------------------------------------------------------"); 
        Persona timur = new Persona(10, 0);
        timur.setDNI("NoTieneDni");
        timur.mostrarInfo();

        timur.recorreXMetres(0.1f);
        System.out.println("Distancia recorreguda: "+timur.getDistanciaRecorreguda());


        

    }
}