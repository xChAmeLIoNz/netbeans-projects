package fogli.iseppe.alessandro.gestionalecalzature;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    //attributi
    private static Archivio instance;
    private List<Articolo> elencoArticoli;   
    //costruttore singleton
    private Archivio() {}
    //metodo statico per creazione istanza Singleton class 
    public static Archivio getInstance() {
        if(instance == null) {
            instance = new Archivio();
        }
        return instance;
    }  
    //blocco inizializzazione d'istanza
    {
        elencoArticoli = new ArrayList<>();        
        //popolamento
        elencoArticoli.add(new Articolo("Stivale", "Marrone", 150.40));
        elencoArticoli.add(new Articolo("Mocassino", "Nero", 90.10));
        elencoArticoli.add(new Articolo("Tennis", "Blu", 60.30));
        elencoArticoli.add(new Articolo("Stivale", "Rosso", 111.64));
    }   
    //getter
    public List<Articolo> getElencoArticoli() {
        return elencoArticoli;
    }
}
