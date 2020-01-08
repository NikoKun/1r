package app;

import java.util.Random;
import java.util.Scanner;

public class App {
    static final int numParaules = 3;
    static final int numLletresAbecedari = 26;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String arrayParaules[] = new String[numParaules];
        mostraBenvinguda();
        System.out.println("Introdueix la mida de les paraules: ");
        int mida = sc.nextInt();
        sc.nextLine();
        char arrayPanell[] = new char[mida];
        inicialitzaArrayPanell(arrayPanell); // L'inicialitza amb '_'
        char arrayLletresDites[] = new char[numLletresAbecedari];
        for (int i = 0; i < arrayParaules.length; i++) {
            boolean ok = false;
            while (!ok) {
                ok = true;
                System.out.println("Escriu una paraula número " + (i + 1));
                String paraula = sc.next();
                if (comprovaMidaParaula(paraula, mida)) {
                    arrayParaules[i] = paraula;

                } else {
                    System.out.println("Mida incorrecta. Has d'escriure paraules de " + mida + " caracters.");
                    ok = false;
                }
            }
        }

        String paraulaSecreta = triaParaulaSecretaRandom(arrayParaules);
        char arrayParaulaSecreta[] = deStringACharArray(paraulaSecreta); // Passa un String a array de chars

        int posicio = 0;
        int errors = 0;
        boolean estasPenjat = false;
        boolean hasTriunfat = false;
        while (!estasPenjat && !hasTriunfat) {
            char lletra;
            String valorEntrat;
            do {
                mostraPanell(arrayPanell);
                System.out.println("Introdueix una lletra");
                valorEntrat = sc.next();
                lletra = valorEntrat.charAt(0);

            } while (!(comprovaSiEsLletra(lletra) && comprovaSiNomesEsUnaSolaLletra(valorEntrat)
                    && comprovaSiJaHaDitLaLletra(lletra, arrayLletresDites)));

            afegeixLletraAArrayDeLletresDites(lletra, arrayLletresDites, posicio);
            posicio++;
            errors = actualitzaPanellAmbLletra(lletra, arrayParaulaSecreta, errors, arrayPanell);
            printaPenjat(errors);

            if (comprovaSiHasPalmat(errors)) {
                estasPenjat = true;
                sc.close();
            }

            if (comprovaSiHasGuanyat(arrayPanell)) {
                hasTriunfat = true;
                sc.close();
            }

        }

        if (hasTriunfat) {
            System.out.println("Felicitats! Has descobert la paraula amb " + errors + " errors.");
        } else {
            System.out.println("Collons.. No era tan difícil.. La paraula era: " + paraulaSecreta);
            System.out.println("Has palmat!");
        }
    }






    public static void mostraBenvinguda(){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("Benvingut a el millor joc a la faç de la terra!!!");
        System.out.println("--------------------------------------------------------------------------------------------");
    }



    public static void inicialitzaArrayPanell(char arrayPanell[]){
        for (int i=0; i<arrayPanell.length; i++){
            arrayPanell[i] = '-';
        }
    }



    public static boolean comprovaMidaParaula(String paraula, int mida){
        if (paraula.length()==mida){
            return true;
        }
        return false;
    }



    public static String triaParaulaSecretaRandom(String[] arrayParaules){
        return arrayParaules[(int)Math.random() * arrayParaules.length];
    }



    public static char[] deStringACharArray(String paraulaSecreta){
        char arrayParaulaSecreta[] = paraulaSecreta.toCharArray();
        return arrayParaulaSecreta;
    }



    public static void mostraPanell(char arrayPanell[]){
        System.out.println("--------------------------------------------------------------------------------------------");
        for (int i=0; i<arrayPanell.length; i++){
            System.out.print(arrayPanell[i]+" ");
        }
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------");
    }



    public static boolean comprovaSiEsLletra(char lletra){
        if( Character.isLetter(lletra)){
            return true;
        }
        else{
            return false;
        }
    }



    public static boolean comprovaSiNomesEsUnaSolaLletra(String valorEntrat){
        if(valorEntrat.length()!=1){
            return false;
        }
        else{
            return true;
        }
    }



    public static boolean comprovaSiJaHaDitLaLletra(char lletra, char arrayLletresDites[]){
        for (int i=0; i<arrayLletresDites.length; i++){
            if(lletra==arrayLletresDites[i]){
                System.out.println("REPEEEEEEEEEEE");
                return false;
            }
        }
        return true;
    }



    public static void afegeixLletraAArrayDeLletresDites(char lletra, char arrayLletresDites[], int posicio){
        arrayLletresDites[posicio] = lletra;
    }



    public static int actualitzaPanellAmbLletra(char lletra, char arrayParaulaSecreta[], int errors, char arrayPanell[]){
        boolean wala = false;
        for (int i=0; i<arrayParaulaSecreta.length; i++){
            if (lletra==arrayParaulaSecreta[i]){
                arrayPanell[i] = lletra;
                wala = true;
            }
        }

        if (wala == false){
            errors++;
        }

        return errors;
    }
    


    public static void printaPenjat(int errors){
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("-----");
        System.out.print("|");
        if (errors >= 1){
            System.out.print("   O ");
        }
        System.out.println("");

        System.out.print("|");
        if (errors >= 2){
            System.out.print("  / ");
            System.out.print(Character.toChars(92));
        }
        System.out.println("");

        System.out.print("|");
        if (errors >= 3){
            System.out.print("   | ");
        }
        System.out.println("");

        System.out.print("|");
        if (errors >= 4){
            System.out.print("  / ");
            System.out.print(Character.toChars(92));
        }
        System.out.println("");
    }



    public static boolean comprovaSiHasPalmat(int errors){
        if (errors > 3){
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean comprovaSiHasGuanyat(char[] arrayPanell){
        int coun = 0;
        for(int i=0; i<arrayPanell.length; i++){
            if(arrayPanell[i] =='-'){
                coun++;
            }
        }
        if (coun==0){
            return true;
        }
        else {
            return false;
        }
    }








}
