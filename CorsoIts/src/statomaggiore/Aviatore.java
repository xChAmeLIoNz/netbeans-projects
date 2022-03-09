package statomaggiore;


public class Aviatore extends Militare{

    private String aereoPilotato;

    public Aviatore(String aereoPilotato, String nome, String cognome, int matricola) {
        super(nome, cognome, matricola);
        this.aereoPilotato = aereoPilotato;
    }

    @Override
    void azioneSoldato() {
        
        System.out.println("L'aviatore vola");
    }

    @Override
    public String toString() {
        return super.toString() + " Aereo pilotato: " + aereoPilotato; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
}
