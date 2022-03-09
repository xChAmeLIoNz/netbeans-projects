package banca;
import java.util.Scanner;

public class MainClass {
    
    public static void main(String[] args) {
        
        //istanziare strumento per input
        Scanner sc = new Scanner(System.in);
        
        //messaggio di ingresso e istruzione iniziale
        System.out.println("Benvenuto nella nostra banca... Digita N per aprire"
                + " un nuovo conto oppure E per uscire");
        
        //gestione input utente (aprire conto)
        if(sc.next().toUpperCase().equals("N")){
            
            //istruzioni apertura conto
            System.out.println("Digita il tuo nome");
            ContoCorrente cc = new ContoCorrente(sc.next());
            System.out.println("Complimenti " + cc.getIntestatario() +
                    "!\nL'Iban del tuo conto è: " + cc.getIban() + 
                    "\nIl tuo saldo è pari a: " + cc.getSaldo());
            
        //chiedo cosa vuole fare
        System.out.println("Digita O per effettuare operazioni, digita E per terminare");
        
        //l'utente vuole effettuare operazioni
        if(sc.next().toUpperCase().equals("O")){
            
            //gestisco le operazioni
            System.out.println("Inserisci le operazioni (0 per terminare)");
            while(sc.hasNextLine()){
                
                double importo = Double.parseDouble(sc.next().replace(",", "."));
                
                //l'utente effettua un'operazione
                if(importo != 0){
                    
                    cc.setSaldo(importo);
                    System.out.println("Hai registrato un'operazione di " + 
                            importo + "€ ed ora hai un saldo pari a " +
                            cc.getSaldo() + "€ \nRegistra un'altra operazione"
                                    + " o digita 0 per uscire");
                }
                else //l'utente non vuole continuare
                {
                    
                    System.out.println("Alla prossima " + cc.getIntestatario() + "...");
                    break;
                }
            }
        }
        else //l'utente ha aperto il conto ma non fa operazioni
        {
            System.out.println("Alla prossima " + cc.getIntestatario() + "...");
        }
        }
        //l'utente vuole abbandonare subito
        else{
            
            System.out.println("Alla prossima...");
        }

        
    }

}
