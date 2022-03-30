package comunicazione;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Comunicazione comunicazione = new Comunicazione();
        List<Persona> lista = comunicazione.leggiDati();
        
        if(lista != null) {
            for(Persona p : lista) {
                System.out.println(p);
            }
        }
        
        //invio di nuova Persona al server
        Persona p = new Persona("Alessandro", "Fogli", 27);
        comunicazione.inviaDati(p);
        
    }
}
