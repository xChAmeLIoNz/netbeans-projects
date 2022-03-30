package negozio;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {
    //attributi
    private int numeroCliente;
    private Negozio negozio;
    
    //costruttore

    public Cliente(int numeroCliente, Negozio negozio) {
        this.numeroCliente = numeroCliente;
        this.negozio = negozio;
    }
    
    //rappresentazione testuale

    @Override
    public String toString() {
        return "Il cliente numero: " + numeroCliente;
    }

    @Override
    public void run() {
        //determino tempo di permanenza casuale
        int permanenza = new Random().nextInt((10-1)+1)+1;
        negozio.ingresso();
        try {
            Thread.sleep(permanenza * 1000);
        } catch (InterruptedException ex) {
        }
        negozio.uscita();
   }
    
    
    
    
    
}
