package agenzia;

public class Immobile {
    //attributi
    private static int codice;
    private double superficieImmobile;
    private double prezzo;
    
    //costruttore

    public Immobile(int codice, double superficieImmobile, double prezzo) {
        this.codice = codice;
        this.superficieImmobile = superficieImmobile;
        this.prezzo = prezzo;
    }
    
    //metodo per creazione codice numerico progressivo DA TESTARE
    public static int codiceProgressivo() {
        for(int i = 1; i < i + 1; i++) {
            codice = i;
        }
        return codice;
    }
    
    //getter

    public int getCodice() {
        return codice;
    }

    public double getSuperficieImmobile() {
        return superficieImmobile;
    }

    public double getPrezzo() {
        return prezzo;
    }
    
    //setter

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public void setSuperficieImmobile(double superficieImmobile) {
        this.superficieImmobile = superficieImmobile;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    
}
