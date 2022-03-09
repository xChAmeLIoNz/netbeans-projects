package file;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Scrittura {
    
    public static void main(String[] args) {
        //scriviSuFile(JOptionPane.showInputDialog("Scrivi qualcosa"));
        //aggiungiFile(JOptionPane.showInputDialog("Inserisci testo"));
        
        String testoCsv = "Mario, Rossi, 50\nGianni, Verdi, 32";
        creaCsv(testoCsv);
    }
    
    static void scriviSuFile(String testoDaScrivere) {
        
        PrintWriter writer = null; //oggetto che mi permette di scrivere su file esterni
        try {
            writer = new PrintWriter("nuovo_file.txt");
            writer.println(testoDaScrivere);
            writer.flush(); //controlla che tutti i dati siano arrivati a destinazione,
                            //prima di chiudere il flusso
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            writer.close(); 
            /*quando interagisco con risorsa esterna, devo chiuderla
            appena ho finito di scriverci dentro, al fine di evitare la corruzione del file,
            dato che viene aperto molteplici volte*/
        }
    }
    
    static void aggiungiFile(String testoDaScrivere) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("altro_file.txt", true));
            writer.println(testoDaScrivere);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(writer != null) {
                writer.close();
            }
            
        }
    }
    
    static void creaCsv(String testoDaScrivere) {
        try(PrintWriter writer = new PrintWriter("file_tabella.csv")) {
            writer.write(testoDaScrivere);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
