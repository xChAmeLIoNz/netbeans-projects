package reflection;

public class Persona {

    //attributi
    public String nome;
    public String cognome;
    public int eta;
    public double altezza;
    public double peso;
    public static Persona[] persone;
    
    //costruttori
    public Persona(String nome, String cognome, int eta, double altezza, double peso) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.altezza = altezza;
        this.peso = peso;
    }

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona() {
        
    }
    
    //metodi
    public void mangiare() {
        
        System.out.println(nome + " sta mangiando");
    }
    
    public void lavorare() {
        
        System.out.println(nome + " sta lavorando");
    }
    
    //getter

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public double getAltezza() {
        return altezza;
    }

    public double getPeso() {
        return peso;
    }

    public static Persona[] getPersone() {
        return persone;
    }
    
}
