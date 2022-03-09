package interfacce.grafiche.parte1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentiPrincipali extends JFrame implements ActionListener {

    private JPanel pannello;
    private JTextField input;
    private JButton pulsante;
    private JLabel output;
    
    //costruttore
    public ComponentiPrincipali() {
        setTitle("Il mio primo frame"); //titolo della finestra
        setSize(400, 400); //dimensioni finestra
        setResizable(false); //utente non puo ridimensionare la finestra
        setLocationRelativeTo(null); //in questo modo la finestra compare al centro dello schermo
        //aggiunta pannello
        pannello = creazionePannello();
        add(pannello);
        //impostazioni finali
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //metodo per creare il pannello
    private JPanel creazionePannello() {
        JPanel panel = new JPanel(null);
        input = creazioneInput();
        pulsante = creazionePulsante();
        output = creazioneOutput();
        
        panel.add(input);
        panel.add(pulsante);
        panel.add(output);
        return panel;
    }
    
    //creazione JTextField
    private JTextField creazioneInput() {
        JTextField field = new JTextField();
        field.setBounds(10, 10, 100, 25);
        
        return field;      
    }
    
    //creazione pulsante
    private JButton creazionePulsante() {
        JButton button = new JButton("Invia");
        button.setBounds(10, 45, 100, 25);
        button.addActionListener(this);
        return button;
    }
    
    //metodo creazione JLabel
    private JLabel creazioneOutput() {
        JLabel label = new JLabel();
        label.setBounds(10, 80, 300, 25);
        return label;
        
    }
    
    public static void main(String[] args) {
        new ComponentiPrincipali(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pulsante) {
            output.setText(input.getText());
        }
    }
}
