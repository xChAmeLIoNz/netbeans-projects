package auto.noleggio;

import java.util.ArrayList;
import java.util.List;

public class Archivio {
    //attributi
    private static Archivio istanza;
    private List<Automobile> elencoAutomobili;
    private List<Cliente> elencoClienti;
    private List<Noleggio> elencoNoleggi;
    
    //blocco inizializzazione d'istanza
    {
        
        elencoAutomobili = new ArrayList<>();
        elencoClienti = new ArrayList<>();
        elencoNoleggi = new ArrayList<>();
        
        //popolamento
        elencoAutomobili.add(new Automobile("Honda", "Civic", "FG456LS", 35));
        elencoAutomobili.add(new Automobile("Porsche", "Cayenne", "FF666DV", 82.5));
        elencoAutomobili.add(new Automobile("Fiat", "Panda", "AJ257AV", 22.8));
        elencoAutomobili.add(new Automobile("Lamborghini", "Huracan", "GG978JH", 115));
        
        elencoClienti.add(new Cliente("Mario", "Rossi", "MC12345678"));
        elencoClienti.add(new Cliente("Alex", "Spada", "FE52648795"));
        elencoClienti.add(new Cliente("Simone", "Zanetti", "AY42673229"));
        elencoClienti.add(new Cliente("Paolo", "Marchini", "UK74698316"));
    }
    
    //costruttore singleton

    private Archivio() {}

    public static Archivio getInstance() {
        if(istanza == null) {
            istanza = new Archivio();
        }
        return istanza;
    }
    
    //getter

    public List<Automobile> getElencoAutomobili() {
        return elencoAutomobili;
    }

    public List<Cliente> getElencoClienti() {
        return elencoClienti;
    }

    public List<Noleggio> getElencoNoleggi() {
        return elencoNoleggi;
    } 
    
}
