package interfaccia;

public abstract class Telefono implements Utilita{

    //attributi
    private int durataBatteria;
    
    //costruttore

    public Telefono(int durataBatteria) {
        this.durataBatteria = durataBatteria;
    }
    
    //getter

    public int getDurataBatteria() {
        return durataBatteria;
    }
    
    //metodo concreto con una logica adatta sia a smartphone che a cordless
    public void chiama(long numero) {
        
        System.out.println("Sto chiamando il numero " + numero);
    }
    
    //metodo astratto necessario a entrambi ma con logica distinta
    public abstract void connettiALinea();
}
