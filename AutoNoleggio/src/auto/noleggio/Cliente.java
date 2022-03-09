package auto.noleggio;

import java.util.regex.Pattern;

public class Cliente {
    //attributi
    private String nome;
    private String cognome;
    private String numeroPatente;
    
    //costruttore

    public Cliente(String nome, String cognome, String numeroPatente) {
        this.nome = nome;
        this.cognome = cognome;
        this.numeroPatente = numeroPatente;
    }
    
    //getter
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNumeroPatente() {
        return numeroPatente;
    }
    
    //setter
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumeroPatente(String numeroPatente) {
        this.numeroPatente = numeroPatente;
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " " + cognome;
    }
    
    
    
    //metodo controllo dati cliente
    public static boolean controlloDati(String...dati) {
        
        boolean datiOk = false;
        final String ESPRESSIONE_STANDARD = "[a-zA-Z\\s']{1,}";
        final String ESPRESSIONE_ALFANUM = "[a-zA-Z\\s0-9-]{1,}";
        
        if(Pattern.matches(ESPRESSIONE_STANDARD, dati[0])&&
                Pattern.matches(ESPRESSIONE_STANDARD, dati[1])&&
                Pattern.matches(ESPRESSIONE_ALFANUM, dati[2])) {
            datiOk = true;
        }
        return datiOk;
    }
    
    
}
