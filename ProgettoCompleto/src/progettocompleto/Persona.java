package progettocompleto;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    
    private String nome;
    private String cognome;
    private int eta;
    private static List<Persona> persone;
    
    static {
        persone = new ArrayList<>();
    }

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public static List<Persona> getPersone() {
        return persone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public static void setPersone(List<Persona> persone) {
        Persona.persone = persone;
    }

    
    
}
