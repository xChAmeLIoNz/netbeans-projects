package interfaccia;

public interface Utilita {
    
    //attributi (costanti e statiche) costante comune a tutti i prodotti
    String MARCA = "Mia azienda";
    
    //metodo con una logica di default che venga utilizzato dai prodotti solo al bisogno
    //default = keyword utilizzabile solo nelle interfacce, senza obbligare a fare override
    //ma crea un'istruzione base
    default void livelloBatteria() {
        
        System.out.println("La batteria è quasi scarica");
    }
    
    //metodo astratto necessario a tutti ma con logica distinta
    //abstract è implicito per i metodi, salvo diversa specificazione
    void inizializzazione();
    }
