package fogli.alessandro.esercizi.step3;

import javax.swing.JOptionPane;


public class Es05 {

    public static void main(String[] args) {
        
        String nomeUtenteRegistrato = "Alessandro";
        String passwordUtenteRegistrata = "Ciao1234";
        String username = JOptionPane.showInputDialog("Inserisci nome utente");
        String password = JOptionPane.showInputDialog("Inserisci password");
    
        
        String messaggio = controllaCredenziali(nomeUtenteRegistrato, username,
                passwordUtenteRegistrata, password) ? "Sei autorizzato" : "Non sei autorizzato";
        System.out.println(messaggio);
                
                
        /*if(controllaCredenziali(nomeUtenteRegistrato, username, passwordUtenteRegistrata, password) == true){
            System.out.println("Credenziali corrette");
        }else{
            
            System.out.println("Credenziali errate");
        }
        */
    }
    
    
    static boolean controllaCredenziali(String nomeUtente, String utente,
            String passUtente, String password){
        
        if(nomeUtente.equalsIgnoreCase(utente) && passUtente.equals(password)){
            return true;
            //ALTERNATIVA CORRETTA
            //return nomeUtente.equalsIgnoreCase(utente) && passUtente.equals(password)
            
        }else{
            
            return false;
        }
    }
}
