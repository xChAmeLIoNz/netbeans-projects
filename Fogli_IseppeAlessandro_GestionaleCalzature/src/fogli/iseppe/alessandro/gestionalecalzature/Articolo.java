package fogli.iseppe.alessandro.gestionalecalzature;

import java.util.regex.Pattern;

public class Articolo {
    //attributi
    private String tipologia;
    private String colore;
    private double prezzo;   
    //costruttore
    public Articolo(String tipologia, String colore, double prezzo) {
        this.tipologia = tipologia;
        this.colore = colore;
        this.prezzo = prezzo;
    } 
    
    //getter
    public String getTipologia() {
        return tipologia;
    }
    public String getColore() {
        return colore;
    }
    public double getPrezzo() {
        return prezzo;
    }  
    
    //setter
    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }   
    //controllo dati
    public static boolean controlloDati(String...dati) {
        boolean datiOk = false;
        final String ESPRESSIONE_STANDARD = "[A-Za-z\\s']{1,}";
        final String ESPRESSIONE_PREZZO = "[0-9.]{1,}";
        
        if(Pattern.matches(ESPRESSIONE_STANDARD, dati[0]) &&
                Pattern.matches(ESPRESSIONE_PREZZO, dati[1])) {
            datiOk = true;
        }
        return datiOk;               
    }    
}
