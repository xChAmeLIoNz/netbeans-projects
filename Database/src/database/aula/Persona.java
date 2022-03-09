package database.aula;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    //attributi
    private int id;
    private String nome;
    private String cognome;
    private int eta;
    private static List<Persona> persone;
    
    static {
        persone = new ArrayList<>();
    }
    
    //costruttori

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public Persona() {
    }
    
    //getter

    public int getId() {
        return id;
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
    
    //setter

    public void setId(int id) {
        this.id = id;
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
    
    //rappresentazione testuale

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }
    
    
}
