package fogli.alessandro.esercizi.step3;

import javax.swing.JOptionPane;


public class Es06 {

    public static void main(String[] args) {
        
        String nome = JOptionPane.showInputDialog("Inserisci nome");
        String cognome = JOptionPane.showInputDialog("Inserisci cognome");
        if(controllaDati(nome, cognome)){
        System.out.println(generaMail(nome, cognome));
        System.out.println(generaPassword(nome, cognome));
        }else{
            System.out.println("lunghezza nome e cognome errata");
        }
    }
    
    static String generaMail(String nome, String cognome){
        
        return nome.substring(0, 1).concat(".").concat(cognome).concat("@gmail.com");
    }
    
    static String generaPassword(String nome, String cognome){
        
        return nome.substring(0, 3).concat(cognome.substring(cognome.length() - 3));
    }
    
    static boolean controllaDati(String nome, String cognome){
        
        return nome.length() >= 3 && cognome.length() >= 3;
    }
    
}
