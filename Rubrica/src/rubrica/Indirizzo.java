package rubrica;

public class Indirizzo {

    private String via;
    private String civico;
    private int cap;
    private String comune;
    private String provincia;

    public Indirizzo(String via, String civico, int cap, String comune, String provincia) {
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.comune = comune;
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public String getCivico() {
        return civico;
    }

    public int getCap() {
        return cap;
    }

    public String getComune() {
        return comune;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    
}
