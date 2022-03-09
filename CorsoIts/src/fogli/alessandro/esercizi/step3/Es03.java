package fogli.alessandro.esercizi.step3;


public class Es03 {

    public static void main(String[] args) {
        
        String testo = "superc@lifr@gilistichespir@lidoso";
        char occorrenza = '@';
        char nuovaOccorrenza = 'a';
        
        System.out.println(new Es03().modifica(testo, occorrenza, nuovaOccorrenza));
    }
    
    String modifica(String testo, char occorrenza, char nuovaOccorrenza){
        
        return testo.replace(occorrenza, nuovaOccorrenza);
    }
    
    
}
