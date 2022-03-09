package fogl.alessandro.codicefiscale;

import javax.swing.JOptionPane;


public class TrovaCodiceFiscale {

    public static void main(String[] args) {
        
        String nomeUtente = JOptionPane.showInputDialog("Inserisci un nome");
        String cognomeUtente = JOptionPane.showInputDialog("Inserisci un cognome");
        String dataNascita = JOptionPane.showInputDialog("Inserisci una data di nascita\nFormato"
                + " dd-mm-yyyy");
        String comuneNascita = "Ferrara";
        String sesso = JOptionPane.showInputDialog("Sesso: M o F");
    }
}
