package collezioni;
import java.util.*;

public class Code {

    public static void main(String[] args) {
        
        //dichiarazione e istanziazione
        Queue<String> coda = new LinkedList<>();
        
        //popolamento... add & offer si usa per inserire
        coda.offer("mondo");
        coda.offer("ciao");
        coda.add("al");
        
        System.out.println(coda);
        
        //accesso al primo elemento senza rimuoverlo (vedo sempre il primo elemento che è stato inserito)
        System.out.println(coda.peek()); //lo uso per "sbirciare" senza modificare
        System.out.println(coda.element());
        System.out.println(coda.peek());
        
        System.out.println(coda);
        
        //accedo al primo elemento con rimozione
        System.out.println(coda.poll());
        System.out.println(coda.remove()); //vedo sempre l'elemento in posizione 0 e lo elimino
                                           //quindi l'elemento che prima era in pos 1, ora slitta in pos 0.
        System.out.println(coda.poll());
        
        System.out.println(coda);
    }
}
