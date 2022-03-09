package auto.noleggio;

import java.util.regex.Pattern;

public class Automobile {
    //attributi
    private String marca;
    private String modello;
    private String targa;
    private double tariffaGiornaliera;
    private boolean noleggiata;
    
    //costruttore

    public Automobile(String marca, String modello, String targa, double tariffaGiornaliera) {
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.tariffaGiornaliera = tariffaGiornaliera;
        this.noleggiata = false;
    }
    
    //getter

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public String getTarga() {
        return targa;
    }

    public double getTariffaGiornaliera() {
        return tariffaGiornaliera;
    }

    public boolean isNoleggiata() {
        return noleggiata;
    }
    
    
    //setter
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setTariffaGiornaliera(double tariffaGiornaliera) {
        this.tariffaGiornaliera = tariffaGiornaliera;
    }

    public void setNoleggiata(boolean noleggiata) {
        this.noleggiata = noleggiata;
    }
    
    

    @Override
    public String toString() {
        return "Marca: " + marca + " - Modello: " + modello;
    }
    
    
    
    
    public static boolean controlloDati(String...dati) {
        
        boolean datiOk = false;
        final String ESPRESSIONE_STANDARD = "[a-zA-Z\\s]{1,}";
        final String ESPRESSIONE_ALFANUM = "[a-zA-Z\\s0-9-]{1,}";
        final String ESPRESSIONE_TARGA = "[a-zA-Z0-9]{7}";
        final String ESPRESSIONE_TARIFFA = "[0-9.]{1,}";
        
        if(Pattern.matches(ESPRESSIONE_STANDARD, dati[0]) &&
                Pattern.matches(ESPRESSIONE_ALFANUM, dati[1]) &&
                Pattern.matches(ESPRESSIONE_TARGA, dati[2]) &&
                Pattern.matches(ESPRESSIONE_TARIFFA, dati[3])) {
            
            datiOk = true;
            
            
        }
        
        
        return datiOk;
    }
    
}
