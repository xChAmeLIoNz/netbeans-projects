package interfaccia;

public class Smartphone extends Telefono {
    
    //attributi
    private int numeroSim;

    public Smartphone(int durataBatteria, int numeroSim) {
        super(durataBatteria);
        this.numeroSim = numeroSim;
    }
    
    //getter

    public int getNumeroSim() {
        return numeroSim;
    }
    
    //implementazione metodo astratto
    @Override
    public void connettiALinea() {
        
        System.out.println("Inserisci SIM");
    }

    @Override
    public void inizializzazione() {
        
        System.out.println("Ricarica iniziale e imposta account Google");
    }

}
