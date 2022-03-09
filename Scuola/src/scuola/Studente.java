package scuola;

import java.util.regex.Pattern;

public class Studente implements Controllo {

    //attributi
    private String nome;
    private String cognome;
    
    //costruttore

    public Studente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }
    
    //rappresentazione testuale
    @Override
    public String toString() {
        return nome + " " + cognome;
    }
    
    //metodo controllo dati input
    static boolean controlloDatiStudente(String nome, String cognome) {
        return Pattern.matches(ESPRESSIONE_CONTROLLO_NOMINALE, nome) && 
                Pattern.matches(ESPRESSIONE_CONTROLLO_NOMINALE, cognome);
    }
    
}
