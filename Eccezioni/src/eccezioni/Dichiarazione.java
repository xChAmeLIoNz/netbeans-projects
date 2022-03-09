package eccezioni;

import java.io.IOException;

public class Dichiarazione {
    public static void main(String[] args) {
        //generoEccezioneControllata();
        //System.out.println("Hello World");
        generoEccezioneIncontrollata();
        
    }
    
    static void generoEccezioneControllata() throws IOException {
        throw new IOException();
        //checked exception
    }
    
    static void generoEccezioneIncontrollata() {
        throw new ArithmeticException(); 
        //unchecked exception
    }
    
}
