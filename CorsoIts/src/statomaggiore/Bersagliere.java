package statomaggiore;


public class Bersagliere extends Militare{
    
    private double velocitaDiCorsa;

    public Bersagliere(String nome, String cognome, int matricola, double velocitaDiCorsa) {
        super(nome, cognome, matricola);
        this.velocitaDiCorsa = velocitaDiCorsa;
    }

    @Override
    void azioneSoldato() {
        
        System.out.println("Il bersagliere corre");
    }

    @Override
    public String toString() {
        return super.toString() + " Velocità di corsa = " + velocitaDiCorsa; 
    }

    
    

    
}
