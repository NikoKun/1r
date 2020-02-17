package app;

import java.util.HashMap;
import app.*;
import classes.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, Usuaris> usuaris = new HashMap<String, Usuaris>();

        String sep = "--------------------------------------------------------------------------------------";
        boolean fiPrograma = false;

        while (!fiPrograma){
            Printa.menu();
            String opcioM = System.console().readLine("   - ");

            System.out.println(sep);
            switch (opcioM){
                case "1":
                    boolean opcioCorrecta = false;
                    Object[] personaTemp = new Object[3];

                    personaTemp[0] = System.console().readLine("   - Nom d'usuari: ");
                    while (!opcioCorrecta){
                        personaTemp[1] = System.console().readLine("   - Correu: ");

                        if (personaTemp[1].toString().matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$")){
                            opcioCorrecta = true;
                        }
                        else {
                            System.out.println();
                            System.out.println("Correu introduit incorrecte!!!");
                        }
                    }


                    personaTemp[2] = System.console().readLine("   - Contrasenya: ");

                    if (Comprova.comprovaUsuaris(personaTemp, usuaris)){
                        Usuaris persona = new Usuaris(personaTemp[0].toString(), personaTemp[2].toString(), personaTemp[1].toString());

                        System.out.println(sep);
                        String decideix;
                        String opcionals;
                        int edatItel;
                        char sexe;

                        opcioCorrecta = false;
                        while (!opcioCorrecta){
                            decideix = System.console().readLine("   Vols especificar el teu nom personal en l'usuari? (si) ");
                            if (decideix.equalsIgnoreCase("si")){
                                opcionals = System.console().readLine("   - Nom real de l'usuari: ");
                                if (!opcionals.matches("\\d")){
                                    persona.setNom(opcionals);
                                    opcioCorrecta = true;
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Nom personal introduit incorrecte!!!");
                                }
                            }
                            else{
                                opcioCorrecta = true;
                            }
                        }

                        opcioCorrecta = false;
                        while (!opcioCorrecta){
                            System.out.println(sep);
                            decideix = System.console().readLine("   Vols especificar els teus cognoms en l'usuari? (si) ");
                            if (decideix.equalsIgnoreCase("si")){
                                opcionals = System.console().readLine("   - Cognoms reals de l'usuari: ");
                                if (!opcionals.matches("\\d")){
                                    persona.setCognom(opcionals);
                                    opcioCorrecta = true;
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Cognom personal introduit incorrecte!!!");
                                }                            
                            }
                            else{
                                opcioCorrecta = true;
                            }
                        }

                        opcioCorrecta = false;
                        while (!opcioCorrecta){
                            System.out.println(sep);
                            decideix = System.console().readLine("   Vols especificar la teva edat en l'usuari? (si) ");
                            if (decideix.equalsIgnoreCase("si")){
                                opcionals = System.console().readLine("   - Edat reals de l'usuari: ");
                                if (opcionals.matches("\\d{3}") || Integer.parseInt(opcionals)<200 || Integer.parseInt(opcionals)>0){
                                    edatItel = Integer.parseInt(opcionals);
                                    persona.setEdat(edatItel);
                                    opcioCorrecta = true;
                                }
                                else {
                                    System.out.println();
                                    System.out.println("Edat introduida incorrecte!!!");
                                }
                            }
                            else{
                                opcioCorrecta = true;
                            }
                        }

                        opcioCorrecta = false;
                        while (!opcioCorrecta){
                            System.out.println(sep);
                            decideix = System.console().readLine("   Vols especificar el teu telefòn en l'usuari? (si) ");
                            if (decideix.equalsIgnoreCase("si")){
                                opcionals = System.console().readLine("   - Telefòn reals de l'usuari: ");
                                if (opcionals.matches("\\d{9}")){
                                    edatItel = Integer.parseInt(opcionals);
                                    persona.setTel(edatItel);
                                    opcioCorrecta = true;
                                }
                                else{
                                    System.out.println();
                                    System.out.println("Telefòn introduit incorrecte!!!");
                                }
                            }
                            else{
                                opcioCorrecta = true;
                            }
                        }

                        opcioCorrecta = false;
                        while (!opcioCorrecta){
                            System.out.println(sep);
                            decideix = System.console().readLine("   Vols especificar el teu sexe en l'usuari? (si) ");
                            if (decideix.equalsIgnoreCase("si")){
                                opcionals= System.console().readLine("   - Sexe real de l'usuari: (M/F) ");
                                if (opcionals.equals("M") || opcionals.equals("F")){
                                    char sexeTemp[] = opcionals.toCharArray();
                                    sexe = sexeTemp[0];
                                    persona.setSexe(sexe);
                                    opcioCorrecta = true;
                                }
                                else{
                                    System.out.println();
                                    System.out.println("Sexe introduit incorrecte!!!");
                                }
                            }
                            else{
                                opcioCorrecta = true;
                            }
                        }

                        usuaris.put(personaTemp[0].toString(), persona);
                    }
                    else {
                        System.out.println(sep);
                        System.out.println("\t Aquest usuari ja existeix!!!");
                    }

                    System.out.println(sep);
                break;
                case "2":


                    System.out.println(sep);
                break;
                case "3":
                    Printa.usuaris(usuaris);
                System.out.println(sep);
                break;
                case "4":


                System.out.println(sep);
                break;
                case "5":


                System.out.println(sep);
                break;
                case "6":
                    fiPrograma = true;
                break;
                default:
                    System.out.println("Tu ets tontu...");
                break;

            }
        }


    }
}