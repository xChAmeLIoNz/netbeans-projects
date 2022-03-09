package interfaccia;

public class Cordless extends Telefono{
    
    //attributi
    private int raggioAzione;

    //costruttore
    public Cordless(int durataBatteria, int raggioAzione) {
        
        super(durataBatteria);
        this.raggioAzione = raggioAzione;
    }
    
    //getter

    public int getRaggioAzione() {
        return raggioAzione;
    }
    
    //implementazione metodo astratto
    @Override
    public void connettiALinea() {
        
        System.out.println("Collega alla presa telefonica");
    }

    @Override
    public void inizializzazione() {
        
        System.out.println("Collega alla base e imposta numero telefono");
    }

    
}
