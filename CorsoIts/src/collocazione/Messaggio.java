package collocazione;

import javax.swing.JOptionPane;

public class Messaggio {

    private String testo;
    
    public Messaggio(){
        
        this.testo = JOptionPane.showInputDialog("Digita messaggio");
    }
    
    public static void main(String[] args) {
        
        new Messaggio().new InviaMessaggio().criptaEInvia();
        //devo costruire prima un oggetto dalla classe principale
        //poi con il "." invoco la inner class (new) e poi invoco il suo metodo
    }
    
    //classe inner che cripta e invia (annidata)
    class InviaMessaggio{
        
        public void criptaEInvia(){
            
            String criptato = testo.replace("a", "@");
            System.out.println(criptato);
        }
    }
}
