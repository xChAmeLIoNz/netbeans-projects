package interfacce.grafiche.parte1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComponentiSelezione extends JFrame implements ActionListener {

    //attributi
    private JPanel pannello;
    private JComboBox selettore;
    private String[] arraySelettore = {"Milano", "Roma", "Napoli"};
    private String[] arrayCaselle = {"Cinema", "Musica", "Teatro"};
    private String[] arrayRadio = {"Uomo", "Donna"};
    private java.util.List<JCheckBox> listaCaselle;
    private java.util.List<JRadioButton> listaRadio;
    private ButtonGroup gruppoRadio;
    
    public ComponentiSelezione() {
        
        //initial settings
        setTitle("Il mio secondo frame");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //aggiunta pannello
        pannello = creazionePannello();
        add(pannello);
        
        //final settings
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        }
    
    private JPanel creazionePannello() {
        JPanel panel = new JPanel(null); //null = no layout preconfezionato di java
        selettore = creazioneSelettore();
        listaCaselle = creazioneCaselle();
        listaRadio = creazioneRadio();
        
        panel.add(selettore);
        for(JCheckBox j : listaCaselle) {
            panel.add(j);
        }
        
        for(JRadioButton j : listaRadio) {
            panel.add(j);
        }
        return panel;
    }
    
    //metodo creazione selettore
    private JComboBox creazioneSelettore() {
        JComboBox comboBox = new JComboBox(arraySelettore);
        comboBox.setBounds(10, 10, 150, 25);
        comboBox.addActionListener(this);
        
        return comboBox;
    }
    
    //metodo creazione caselle
    private java.util.List<JCheckBox> creazioneCaselle() {
        java.util.List<JCheckBox> list = new java.util.ArrayList<>();
        int primaPosizioneY = 45;
        
        for(String s : arrayCaselle) {
            JCheckBox checkBox = new JCheckBox(s);
            checkBox.setActionCommand(s);
            checkBox.setBounds(10, primaPosizioneY, 100, 25);
            primaPosizioneY += 25;
            checkBox.addActionListener(this);
            list.add(checkBox);
        }
        return list;
    }
    
    //metodo creazione radioButton
    private java.util.List<JRadioButton> creazioneRadio() {
        java.util.List<JRadioButton> list = new java.util.ArrayList<>();
        gruppoRadio = new ButtonGroup();
        int primaPosizioneY = 130;
        
        for(String s : arrayRadio) {
            JRadioButton radio = new JRadioButton(s);
            radio.setBounds(10, primaPosizioneY, 100, 25);
            primaPosizioneY += 25;
            radio.addActionListener(this);
            gruppoRadio.add(radio);
            list.add(radio);
        }
        return list;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==selettore) {
            String messaggio;
            switch((String)selettore.getSelectedItem()) {
                case "Milano":
                    messaggio = "L'utente viene da Milano";
                    break;
                case "Roma":
                    messaggio = "L'utente viene da Roma";
                    break;
                default:
                    messaggio = "L'utente viene da Napoli";
            }
            System.out.println(messaggio);
        }
        if(e.getActionCommand().equals("Cinema")) {
            System.out.println("L'utente ama il cinema");
        }
        if(e.getActionCommand().equals("Musica")) {
            System.out.println("L'utente ama la musica");
        }
        if(e.getActionCommand().equals("Teatro")) {
            System.out.println("L'utente ama il teatro");
        }
        
        if(e.getActionCommand().equals("Uomo")) {
            System.out.println("L'utente è un uomo");
        }
        if(e.getActionCommand().equals("Donna")) {
            System.out.println("L'utente è una donna");
        }
    }

    public static void main(String[] args) {
        new ComponentiSelezione();
    }
    
    
    
    
}
