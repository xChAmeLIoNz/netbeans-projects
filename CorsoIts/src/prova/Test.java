package prova;

import java.util.Random;
import javax.swing.JOptionPane;


public class Test {

    public static void main(String[] args) {
        final int COSTANTE = new Random().nextInt((10-1)+1)+1;
        System.out.println(COSTANTE);
        int indovina = Integer.parseInt(JOptionPane.showInputDialog("Indovina il numero"
        + " da 1 a 10"));
        
        int contatore = 1;
        
        for(int i = 0; i < contatore; i++)
        {
            if(indovina < COSTANTE)
            {
                indovina = Integer.parseInt(JOptionPane.showInputDialog("Il numero da indovinare"
                + " è maggiore del numero inserito"));
                
                contatore++;
                
            }else if(indovina > COSTANTE)
            {
                indovina = Integer.parseInt(JOptionPane.showInputDialog("Il numero da indovinare"
                + " è minore del numero inserito"));
                contatore++;
            }else if(indovina == COSTANTE)
            {
                if(contatore == 1)
                {
                    JOptionPane.showMessageDialog(null, "Congrats, hai indovinato"
                            + " il numero dopo " + contatore + " tentativo!");
                }else
                {
                    JOptionPane.showMessageDialog(null, "Congrats, hai indovinato"
                            + " il numero dopo " + contatore + " tentativi!");
                }
            }
        }
    }
}
