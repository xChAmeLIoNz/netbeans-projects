package negozio;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Negozio {
    //attributi
    private final int NUMERO_MASSIMO_CLIENTI = 2;
    private int clientiNelNegozio;
    
    //metodo per gestire l'ingresso dei clienti
    public synchronized void ingresso() {
        while(clientiNelNegozio == NUMERO_MASSIMO_CLIENTI) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        clientiNelNegozio++;
        System.out.println(Thread.currentThread() + " è entrato");
        

    }
    
    //metodo per gestire l'uscita di un cliente
    public synchronized void uscita() {
        clientiNelNegozio--;
        System.out.println(Thread.currentThread() + " è uscito");
        notifyAll();
    }
    
    
}
