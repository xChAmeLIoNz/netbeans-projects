package eccezioni;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.*;

public class Logging {
    static FileHandler handler;
    
    public static void main(String[] args) throws Exception {
        handler = new FileHandler("myLogFile.log", true);
        handler.setFormatter(new SimpleFormatter());
        //lancioEccezione();
        divisione(4, 0);
    }
    
    static void lancioEccezione() {
        try {
            throw new IOException();
            
        } catch (IOException ex) {
            
            Logger logger = Logger.getLogger(Logging.class.getName());
            logger.addHandler(handler);
            logger.log(Level.SEVERE, "eccezione lanciato da lancioEccezione", ex);
        }
    }
    
    static void divisione(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (Exception e) {
            Logger logger = Logger.getLogger(Logging.class.getName());
            logger.addHandler(handler);
            logger.log(Level.SEVERE, "eccezione lanciata da divisione", e);
        }
    }
    
}
