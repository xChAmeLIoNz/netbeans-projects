package agenzia;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    //attributi
    private static Archivio instance;
    private List<Immobile> elencoImmobili;
    
    //blocco inizializzazione d'istanza
    {
    elencoImmobili = new ArrayList<>();
    }

    //costruttore singleton
    private Archivio(){}
    
    public static Archivio getInstance() {
        if(instance == null) {
            instance = new Archivio();
        }
        return instance;
    }
    
    //getter

    public List<Immobile> getElencoImmobili() {
        return elencoImmobili;
    }
    
}
