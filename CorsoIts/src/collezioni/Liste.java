package collezioni;
import java.util.*;

public class Liste {

    public static void main(String[] args) {
        
        //dichiarazione ed istanziazione
        //List è un'interfaccia, quindi non ha costruttore. Istanzio una delle sue classi: ArrayList
        List lista = new ArrayList();
        
        
        //popolamento
        lista.add("Ciao");
        lista.add(1); //stessa cosa di sotto, non posso mettere direttamente valori primitivi, 
                      //ma vengono convertiti
        lista.add(true); //autoboxing - convertito nella corrispondente classe boolean
        
        //stampa completa
        System.out.println(lista);
        
        //stampa dimensione lista
        System.out.println(lista.size());
        
        //stampa singoli elementi
        for(int i = 0; i < lista.size(); i++) {
            
            System.out.println(lista.get(i));
        }
        
        //aggiungere un elemento
        lista.add('d'); //oggetto (wrapper) Character
        System.out.println(lista.size());
        
        //modifica di un elemento esistente (da intero a stringa)
        lista.set(1, "bello");
        System.out.println(lista);
        
        //rimuovere un elemento
        lista.remove(1);
        
        System.out.println(lista);
        System.out.println(lista.size());
        
        for(int i = 0; i < lista.size(); i++) {
            
            //System.out.println(lista.get(i).length());
        }
        
        //Collections.sort(lista);
        
        /* ******CON GENERICS ****** */
        
        //dichiarazione e istanziazione
        List<String> lista2 = new ArrayList<>(); //le brackets devono essere uguali
                                                 //sia prima che dopo l'uguale,
                                                 //altrimenti le ometto a destra dell'uguale
                                                 //List<String> lista2 = new ArrayList();
                                                 
        //popolamento
        lista2.add("mondo");
        lista2.add("ciao");
        
        for(String s : lista2) {  //ciclo for each. Solo per ArrayList e Array
                                  //for(quello che deve cercare/iterare : dove andare a cercarlo
            System.out.println(s.length());
        }
        
        System.out.println(lista2);
        Collections.sort(lista2);
        System.out.println(lista2);
        
    }
}
