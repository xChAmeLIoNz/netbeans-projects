package interfaccia;

public class Desktop extends Computer {
    
    private boolean monitorCompreso;

    //costruttore
    public Desktop(String sistemaOperativo, boolean monitorCompreso) {
        super(sistemaOperativo);
        this.monitorCompreso = monitorCompreso;
    }
    
    //getter
    public boolean isMonitorCompreso() {
        return monitorCompreso;
        
    }

    //implementazione metodo astratto
    @Override
    public void sospendi() {
        
        System.out.println("Metti in sospensione da Start");
    }

    @Override
    public void inizializzazione() {
        
        System.out.println("Collega alimentazione e imposta account Microsoft");
    }

}
