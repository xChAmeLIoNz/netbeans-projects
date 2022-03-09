package collezioni;
import java.util.*;

public class Mappe {

    public static void main(String[] args) {
        
        //dichiarazione e istanziazione
        Map<String, Integer> map = new TreeMap<>();
        
        //popolamento
        map.put("secondoNumero", 34);
        map.put("primoNumero", 21);   //<chiave, valore>
        map.put("secondoNumero", 18); //se ho chiavi uguali con valori diversi,
                                      //l'ultimo valore inserito sovrascrive quello precedente
        
        System.out.println(map);
        
        //accesso alle chiavi
        for(String s : map.keySet()) {
            
            System.out.println(s);
        }
        
        //accesso ai valori
        for(int i : map.values()) {
            
            System.out.println(i);
        }
        
        //accesso combinato
        for(String s : map.keySet()) {
            
            System.out.println(s + "=" + map.get(s)); //map.get(s) ritorna il valore associato alla chiave
        }
    }
}
