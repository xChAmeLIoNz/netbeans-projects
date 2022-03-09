package eccezioni;
import java.io.*;

public class GestioneSemplice {
    public static void main(String[] args) {
        //generoEccezioneControllata();
        //System.out.println("Istruzione successiva");
        metodoDivisione(4, 2);
    }
    
    static void generoEccezioneControllata() {
        try { //qua vanno tutte le istruzioni che andranno eseguite
            throw new IOException();
        } 
        catch (IOException e) { //qua posso gestire l'eccezioni
            System.out.println("Ho gestito l'eccezione");
        }
    }
    
    static void metodoDivisione(int a, int b) {
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            
            System.out.println("Divisione impossibile");
        } finally {
            System.out.println("Sei comunque un cretino");
        }
        
    }
    
}
