package interfaccia;

public class Laptop extends Computer{
    
    private boolean schermoTouch;

    //costruttore
    public Laptop(String sistemaOperativo, boolean schermoTouch) {
        super(sistemaOperativo);
        this.schermoTouch = schermoTouch;
    }

    //getter
    public boolean isSchermoTouch() {    
        return schermoTouch;
        
    }

    //implementazione del metodo astratto
    @Override
    public void sospendi() {
        
        System.out.println("Chiudi schermo");
    }

    @Override
    public void inizializzazione() {
        
        System.out.println("Ricarica iniziale e imposta account Microsoft");
    }

}
