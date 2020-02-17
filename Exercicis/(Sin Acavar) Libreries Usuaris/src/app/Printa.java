package app;

import java.util.HashMap;
import classes.Usuaris;

public class Printa {
    static String sep = "--------------------------------------------------------------------------------------";

    public static void menu() {
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|                Administració d'usuaris                |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("|     1 - Registrar Usuari                              |");
        System.out.println("|     2 - Iniciar Sessió                                |");
        System.out.println("|     3 - Mostrar usuaris                               |");
        System.out.println("|     4 - Modificar Usuari                              |");
        System.out.println("|     5 - Eliminar Usuari                               |");
        System.out.println("|     6 - Finalitzar programa                           |");
        System.out.println("|-------------------------------------------------------|");
    }

    public static void usuaris(HashMap<String, Usuaris> usuaris) {
        System.out.println(sep);
        System.out.println("\t USUARIS REGISTRATS");
        System.out.println(sep);
        usuaris.forEach((k,l) -> {
            System.out.println("Nom d'usuari: "+l.getNomUsuari());
            System.out.println("Correu d'usuari: "+l.getCorreu());
            if (!l.getNomUsuari().equals("null")){
                System.out.println("Nom personal de l'usuari: "+l.getNom());
            }
            if (!l.getCognom().equals("null")){
                System.out.println("Cognoms de l'usuari: "+l.getCognom());
            }
            if (!(l.getEdat() == 0)){
                System.out.println("Edat de l'usuari: "+l.getEdat());
            }
            if (l.getSexe() == 'M' || l.getSexe() == 'F' || l.getSexe() == 'm' || l.getSexe() == 'f'){
                System.out.println("Sexe de l'usuari: "+l.getSexe());
            }
            if (!(l.getTel() == 0)){
                System.out.println("Telefòn de l'usuari: "+l.getTel());
            }
            System.out.println();
            System.out.println();
        });
        
    }
}