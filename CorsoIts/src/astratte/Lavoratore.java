package astratte;


public class Lavoratore extends Persona{

    private double reddito;
    
    public Lavoratore(String nome, int eta, double reddito) {
        super(nome, eta);
        this.reddito = reddito;
    }

    public double getReddito() {
        return reddito;
    }
    
    public void lavorare() {
        
        System.out.println(getNome() + " sta lavorando");
    }

    @Override
    public void tempoLibero() {
        
        System.out.println(getNome() + " sta facendo shopping");
    }

    
}
