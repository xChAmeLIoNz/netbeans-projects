package fogli.alessandro.esercizi.step3;

import javax.swing.JOptionPane;


public class Es01 {
    public static void main(String[] args) {
        
        String a = JOptionPane.showInputDialog("Inserisci qualcosa");
        String b = JOptionPane.showInputDialog("Inserisci qualcosa");
        
        System.out.println("La somma dei caratteri delle due\n" +
"frasi ricevute in input è: " + somma(a, b));
        
    }
    
    public static int somma(String a, String b){
        
        return a.length() + b.length();
    }

    
}
