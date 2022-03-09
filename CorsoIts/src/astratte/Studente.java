package astratte;


public class Studente extends Persona {

    private double mediaVoti;
    
    public Studente(String nome, int eta, double mediaVoti) {
        super(nome, eta);
        this.mediaVoti = mediaVoti;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }
    
    public void studiare(){
        
        System.out.println(getNome() + " sta studiando");
    }

    @Override
    public void tempoLibero() {
        
        System.out.println(getNome() + " sta giocando");
    }

    
}
