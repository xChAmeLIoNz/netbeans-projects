package scuola;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Corso implements Controllo{
    //attributi
    private String codice;
    private String materia;
    private List<Studente> elencoStudenti;
    private static List<Corso> elencoCorsi;
    
    static{
        elencoCorsi = new ArrayList<>();
    }
    
    //costruttore

    public Corso(String codice, String materia) {
        this.codice = codice;
        this.materia = materia;
        elencoStudenti = new ArrayList<>();
    }
    
    //getter

    public String getCodice() {
        return codice;
    }

    public String getMateria() {
        return materia;
    }

    public List<Studente> getElencoStudenti() {
        return elencoStudenti;
    }

    public static List<Corso> getElencoCorsi() {
        return elencoCorsi;
    }
    
    //rappresentazione testuale

    @Override
    public String toString() {
        return codice + " - " + materia;
    }
    
    //metodo controllo dati input
    static boolean controlloDatiCorso(String codice, String materia) {
        return Pattern.matches(ESPRESSIONE_CONTROLLO_CODICE, codice) &&
                Pattern.matches(ESPRESSIONE_CONTROLLO_NOMINALE, materia);
    }
    
    
}
