package banca;

import java.util.Random;

public class ContoCorrente {

    //attributi
    private final static String IBAN_FISSO;
    private String intestatario;
    private String numeroContoCorrente;
    private String iban;
    private double saldo;
    
    //blocco d'inizializzazione statico
    static{
        
        IBAN_FISSO = "IT 07 K 02008 13000 ";
    }
    
    //costruttore
    public ContoCorrente (String intestatario){
        
        this.intestatario = intestatario;
        this.saldo = 0;
        
        //genero numero conto corrente casuale di 8 cifre
        this.numeroContoCorrente = "";
        for(int i = 0; i < 7; i++){
            
            this.numeroContoCorrente += new Random().nextInt(10);
        }
        
        //genero iban completo
        this.iban = IBAN_FISSO + this.numeroContoCorrente;
    }
    
    //getter intestatario, iban completo, saldo

    public String getIntestatario() {
        return intestatario;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
    
    //setter saldo

    public void setSaldo(double importo) {
        this.saldo = this.saldo + importo;
    }
    
}
