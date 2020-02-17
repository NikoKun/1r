package app;

import java.util.ArrayList;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {

        String[] nikoOarnau = {"TeamNiko", "TeamArnau"};
        HashMap<Integer, String> equipNiko = new HashMap<Integer, String>();
        HashMap<Integer, String> equipArnau = new HashMap<Integer, String>();
        HashMap<Integer, ArrayList<Integer[]>> registroPunts = new HashMap<Integer, ArrayList<Integer[]>>();


        String sep = "----------------------------------------------------------------------------------------------------------------------------------------------------";
        boolean incorrecto = false;
        boolean acabado = false;

        int equipI = 0;
        String equipS;

        while (!acabado){
        menu(sep);
        int menu = Integer.parseInt(System.console().readLine());
        switch(menu){
            case 1:
                System.out.println(sep);
                System.out.println("Escribe el nombre del primer equipo:");
                nikoOarnau[0] = System.console().readLine();
                System.out.println();
                System.out.println("Escribe el nombre del segundo equipo:");
                nikoOarnau[1] = System.console().readLine();
            break;

            case 2:
                incorrecto = false;
                while (!incorrecto){
                    System.out.println(sep);
                    System.out.println("A que equipo quieres añadir jugadores? ("+nikoOarnau[0]+"/"+nikoOarnau[1]+")");
                    equipS = System.console().readLine();
                    if (equipS.equalsIgnoreCase(nikoOarnau[0])){
                        equipNiko.clear();
                        incorrecto = true;
                        equipI = 0;
                    }
                    else if (equipS.equalsIgnoreCase(nikoOarnau[1])){
                        equipArnau.clear();
                        incorrecto = true;
                        equipI = 1;
                    }
                    else{
                        System.out.println("Equipo incorrecto!!!!");
                    }
                }
                
                jugadores(sep, nikoOarnau, equipNiko, equipArnau, equipI);
            break;

            case 3:
                mostarPlantilla(sep, nikoOarnau, equipNiko, equipArnau);
            break;

            case 4:
                boolean seguracabat = false;
                while (!seguracabat){
                    menuSecundari(sep);
                    menu = Integer.parseInt(System.console().readLine());
                    switch (menu){
                    case 1:
                        System.out.println(sep);
                        int punts = 0;                        //1 2 3
                        boolean puntuacion = false;
                        String equip = "--";
                        int jugador = 0;
                        while (!puntuacion){
                            System.out.println("Cuantos puntos han anotado? (1-2-3)");
                            punts = Integer.parseInt(System.console().readLine());
                            if (punts<1 | punts>3){
                                System.out.println("Puntuación incorrecta!!!");
                            }
                            else{
                                puntuacion = true;
                            }
                        }
                        while (!comprovaEquip(nikoOarnau, equip)){
                            System.out.println(sep);
                            System.out.println("De que equipo es el jugador? ("+nikoOarnau[0]+"/"+nikoOarnau[1]+")");
                            equip = System.console().readLine();
                        }
                        while (!comprovaJugador(equip, equipNiko, equipArnau, nikoOarnau, jugador)){
                            mostarUnaPlantilla(sep, nikoOarnau, equipNiko, equipArnau, equip);
                            System.out.println(sep);
                            System.out.println("Que dorsal ha anotado?");
                            jugador = Integer.parseInt(System.console().readLine());
                            if (equip.equalsIgnoreCase(nikoOarnau[0])){
                                registroPunts.put(0,anotarPunts(registroPunts, sep, equip, punts, nikoOarnau, jugador));
                            }
                            else {
                                registroPunts.put(1,anotarPunts(registroPunts, sep, equip, punts, nikoOarnau, jugador));
                            }
                        }


                    break;
    
                    case 2:
                        System.out.println(sep);
                        System.out.println("PUNTUACIONES:");
                        System.out.println(sep);
                        System.out.println("El equipo "+nikoOarnau[0]+" tiene ");
                        puntos(registroPunts, 0);
                        System.out.print(" puntos.");
                        System.out.println();
                        registroPunts.forEach((una,dosa) ->{
                            if (una.equals(0)){
                                for (Integer[] wala:dosa){
                                    System.out.println("\t- Dorsal: "+wala[0]+" Nombre: "+equipNiko.get(wala[0])+" Puntos: "+wala[1]);
                                }
                            }
                        });

                        System.out.println();
                        System.out.println();
                        System.out.println("El equipo "+nikoOarnau[1]+" tiene ");
                        puntos(registroPunts, 1);
                        System.out.print(" puntos.");                        
                        System.out.println();
                        registroPunts.forEach((una,dosa) ->{
                            if (una.equals(1)){
                                for (Integer[] wala:dosa){
                                    System.out.println("\t- Dorsal: "+wala[0]+" Nombre: "+equipNiko.get(wala[0])+" Puntos: "+wala[1]);
                                }
                            }
                        });

                        

                        break;
                    case 3:
                        seguracabat = true;
                        acabado = true;
                    break;
                    }
    
                }


            break;


            }
        }
    }

    public static void menu(String sep){
        System.out.println(sep);
        System.out.println("BASKET GAME");
        System.out.println("Rellena la plantilla...");
        System.out.println(sep);
        System.out.println("1. Escojer nombre de los equipos");
        System.out.println("2. Nombrar a los jugadores");
        System.out.println("3. Mostrar plantilla");
        System.out.println("4. Comenzar a jugar");
        System.out.println(sep);
    }

    public static void menuSecundari(String sep){
        System.out.println(sep);
        System.out.println("Waw... Este partido es muy emocionante...");
        System.out.println(sep);
        System.out.println("1. Anotar puntos"); 
        System.out.println("2. Mostrar puntos"); //jugadores o equipos
        System.out.println("3. Acabar partido");
        System.out.println(sep);
    }


    public static void jugadores(String sep, String[] nikoOarnau, HashMap<Integer, String> equipNiko, HashMap<Integer, String> equipArnau, int equipI){
        for (int i=0; i<5; i++){
            System.out.println(sep);
            System.out.println("Escribe el numero del siguiente jugador.");
            int dorsal = Integer.parseInt(System.console().readLine());
            System.out.println("Escribe el nombre del jugador nº "+dorsal);
            if (nikoOarnau[equipI].equals(nikoOarnau[0])){
                equipNiko.put(dorsal, System.console().readLine()) ;
            }
            else {
                equipArnau.put(dorsal, System.console().readLine()) ;
            }
        }
    }

    public static void mostarPlantilla(String sep, String[] nikoOarnau, HashMap<Integer, String> equipNiko, HashMap<Integer, String> equipArnau){
        System.out.println(sep);
        System.out.println("Equipo "+nikoOarnau[0]);
        System.out.println();
        equipNiko.forEach((k,v) -> {
            System.out.println("Nª"+k+" - "+v);
        });


        System.out.println();
        System.out.println();
        System.out.println("Equipo "+nikoOarnau[1]);
        System.out.println();
        equipArnau.forEach((k,v) -> {
            System.out.println("Nª"+k+" - "+v);
        });
    }

    public static void mostarUnaPlantilla(String sep, String[] nikoOarnau, HashMap<Integer, String> equipNiko, HashMap<Integer, String> equipArnau, String equip){
        if (equip.equals(nikoOarnau[0])){
            System.out.println(sep);
            System.out.println("Equipo "+nikoOarnau[0]);
            System.out.println();
            equipNiko.forEach((k,v) -> {
                System.out.println("Nª"+k+" - "+v);
            });
        }

        else if (equip.equals(nikoOarnau[0])){
            System.out.println();
            System.out.println();
            System.out.println("Equipo "+nikoOarnau[1]);
            System.out.println();
            equipArnau.forEach((k,v) -> {
                System.out.println("Nª"+k+" - "+v);
            });
        }
    }

    public static boolean comprovaEquip(String[] nikoOarnau,String equip){
        if (equip.equals(nikoOarnau[0])){
            return true;
        }
        else if (equip.equals(nikoOarnau[1])){
            return true;
        }
        else if (equip.equals("--")){
            return false;
        }
        System.out.println("Equip incorrecte");
        return false;
    }


    public static boolean comprovaJugador(String equip,HashMap<Integer, String> equipNiko,HashMap<Integer, String> equipArnau, String[] nikoOarnau, int jugador){
        int[] siOno = {0};
        if (equip.equalsIgnoreCase(nikoOarnau[0])){
            equipNiko.forEach((k,v) -> {
                if (k.equals(jugador)){
                    siOno[0] = 1;
                }
            });

            if (siOno[0]==1){
                return true;
            }
        }

        if (equip.equalsIgnoreCase(nikoOarnau[1])){
            equipArnau.forEach((k,v) -> {
                if (k.equals(jugador)){
                    siOno[0] = 1;
                }
            });

            if (siOno[0]==1){
                return true;
            }
        }
        System.out.println("EXCUSE MUA.... WHA THE FUK");
        return false;
        
    }


    public static ArrayList<Integer[]> anotarPunts(HashMap<Integer, ArrayList<Integer[]>> registroPunts, String sep, String equip , int punts, String[] nikoOarnau, int jugador){
        ArrayList<Integer[]> puntua = new ArrayList<Integer[]>();
        Integer[] wala = {0,0};
        //DorsalJugador, punts
        wala[0] = jugador;
        wala[1] = punts;
        puntua.add(wala);
        return puntua;
    }


        public static void puntos(HashMap<Integer, ArrayList<Integer[]>> registroPunts, int equip){
            int end[] = {0};

            registroPunts.forEach((k,l) -> {
                if (k == equip){
                    for (Integer[] punts:l){
                        end[0] = end[0]+punts[1];
                    }
                }
            });
            System.out.print(end[0]);
        }


}