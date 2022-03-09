package roulette;

import java.util.Random;
import java.util.Scanner;

public class Roulette {

    Scanner scan = new Scanner(System.in);
    double walletStart = 50.0d;
    double importoScommessa;
    double saldoAggiornato;
    //TO-DO: quando il giocatore perde e riprova deve avere il saldo aggiornato DONE
    //TO-DO: qualche bug nel metodo riprova() c'è di sicuro, da guardare
    //costruttore
    public Roulette() {
        
        System.out.print("Benvenuto, il tuo saldo attuale è di "
                + this.walletStart + " euro\n");
        System.out.print("--------------\n");
        
        //importo scommessa
        System.out.print("Inserisci l'importo da scommettere: " );        
        importoScommessa = scan.nextDouble();
        

        //se la scommessa supera il saldo, richiama il metodo noFunds()
        if(importoScommessa > walletStart) {
            
            noFunds();
            System.out.print("Desideri continuare? Y/N ");
            String continua = scan.next();
            if(continua.equalsIgnoreCase("y")) {
                
                new Roulette();
            }else {
                System.out.print("Arrivederci...\n");
            }
        }else {          
            saldoAggiornato = walletStart - importoScommessa;
            System.out.println("Il tuo saldo aggiornato è di " + (saldoAggiornato)
            + " euro");
            estrazione();
        }
                
        
    }
    
    public void noFunds() {
        
        System.out.print("Spiacente, saldo non sufficiente per completare "
                + "l'operazione\n");
        
    }
    
    public void riprova() {
        
        System.out.print("Bentornato, il tuo saldo attuale è di "
            + this.saldoAggiornato + " euro\n");
        System.out.print("--------------\n");
        
        //importo scommessa
        System.out.print("Inserisci l'importo da scommettere: " );        
        importoScommessa = scan.nextDouble();
        

        //se la scommessa supera il saldo, richiama il metodo noFunds()
        if(importoScommessa > saldoAggiornato) {
            
            noFunds();
            System.out.print("Desideri continuare? Y/N ");
            String continua = scan.next();
            if(continua.equalsIgnoreCase("y")) {
                
                new Roulette();
            }else {
                System.out.print("Arrivederci...\n");
            }
        }else {          
            saldoAggiornato = saldoAggiornato - importoScommessa;
            System.out.println("Il tuo saldo aggiornato è di " + (saldoAggiornato)
            + " euro");
            estrazione();
        }
    }
    
    public void estrazione() {
        
            System.out.print("Scegli un numero da 1 a 10: ");
            int numeroScelto = scan.nextInt();
            int numeroEstratto = new Random().nextInt((10-1)+1)+1;
            
            if(numeroScelto >= 1 && numeroScelto <= 10) {
                
                System.out.print("Estraggo un numero causale...\n");
                System.out.print("E' uscito il numero " + numeroEstratto + "\n");
                
                if(numeroScelto == numeroEstratto) {
                    
                    System.out.print("Congratulazioni, hai vinto " + (importoScommessa * 2) + " euro\n");
                    saldoAggiornato = saldoAggiornato + (importoScommessa * 2);
                    
                    System.out.print("Desideri continuare? Y/N ");
                    String continua = scan.next();
                    if(continua.equalsIgnoreCase("y")) {
                        System.out.flush();
                        riprova();
                    }
                }else {
                    
                    System.out.println("Hai perso! Ritenta e sarai più fortunato\n");
                    
                    System.out.print("Desideri continuare? Y/N ");
                    String continua = scan.next();
                    if(continua.equalsIgnoreCase("y")) {
                      //System.out.flush();  NON FUNZIONA
                        riprova();
                    }
                }
                
            }else {
                
                System.out.print("Attenzione: numero inserito non corretto, riprova\n");
                estrazione();
            }
    }
    
    public static void main(String[] args) {
        
        Roulette roulette = new Roulette();
    }
}
