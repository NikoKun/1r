package app;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> hm = new HashMap<>();
        hm.put(1, "Te Mare");
        hm.put(2, "Te Pare");
        hm.put(3, "Te Avi");
        hm.put(4, "Te Tiet");
        hm.put(5, "Te Fill");
        hm.put(6, "Te Cosi");
        
        printTeMare(hm);
        System.out.println();
        printaTePare(hm);
    }

    public static void printTeMare(Map<Integer, String> hm) {
        for (Entry<Integer, String> e : hm.entrySet()) {
            System.out.println("Clau: "+e.getKey()+" Valor: "+e.getValue());
        }
    }

    public static void printaTePare(Map<Integer,String> hm ){
        hm.forEach((k,v) -> System.out.println("Clau: "+k+" Valor: "+v));
    }

}