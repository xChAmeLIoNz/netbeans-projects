package singleton;

public class Messaggio {

    private String testo;
    
    //costruttore

    public Messaggio(String testo) {
        this.testo = testo;
    }
    
    //metodo
    public String ritornaTestoCriptato(){
        
        return Cifratura.getInstance().cifra(testo);
    }
}
