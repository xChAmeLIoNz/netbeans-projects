package composizione;

public class Indirizzo {

    //attributi
    private String via;
    private String civico;
    private int cap;
    
    //costruttore

    public Indirizzo(String via, String civico, int cap) {
        this.via = via;
        this.civico = civico;
        this.cap = cap;
    }
    
    //getter

    public String getVia() {
        return via;
    }

    public String getCivico() {
        return civico;
    }

    public int getCap() {
        return cap;
    }
    
    //metodo
    public void spedisci() {
        
        System.out.println("Spedisci a " + via + "," + civico + " - " + cap);
    }
}
