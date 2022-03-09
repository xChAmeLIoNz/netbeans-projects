package statomaggiore;


public class Militare {

    private String nome;
    private String cognome;
    private int matricola;

    public Militare(String nome, String cognome, int matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
    }
    
    
    void azioneSoldato(){
        
        System.out.println("Il soldato combatte");
    }

    @Override
    public String toString() {
        return "Militare{" + "nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + '}';
    }
    
    
    
}


