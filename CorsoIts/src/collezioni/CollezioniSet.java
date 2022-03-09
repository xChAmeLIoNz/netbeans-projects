package collezioni;
import java.util.*;

public class CollezioniSet {

    public static void main(String[] args) {
        
        //dichiarazione e istanziazione
        Set<String> set = new TreeSet<>();
        
        //popolamento
        set.add("mondo");
        set.add("ciao");
        set.add("mondo");
        
        //Se usiamo SET tutti i duplicati verranno eliminati e verrà fatto il sort automatico.
        System.out.println(set);
        System.out.println(set.size());
        
        for(String s : set) { //ciclo for each per accedere agli elementi 
            
            System.out.println(s);
        }
        
    }
}
