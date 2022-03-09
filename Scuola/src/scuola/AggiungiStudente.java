package scuola;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AggiungiStudente extends JFrame implements ActionListener {

    //attributi
    private JPanel pannello;
    private JTextField nomeStudente;
    private JTextField cognomeStudente;
    private JComboBox selettoreCorso;
    private JButton pulsante;
    //costruttore
    public AggiungiStudente(Scuola framePadre) {
        //impostazioni iniziali
        setTitle("Aggiungi Studente");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(framePadre);
        add(creaPannello());
        //impostazioni finali
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    //metodo creazione pannello
    private JPanel creaPannello() {
        pannello = new JPanel(null);
        pannello.add(creaTestiStatici("Nome:", 10));
        pannello.add(nomeStudente = creaCaselle(32));
        pannello.add(creaTestiStatici("Cognome:", 67));
        pannello.add(cognomeStudente = creaCaselle(89));
        pannello.add(creaTestiStatici("Corso:", 124));
        pannello.add(selettoreCorso = creaSelettoreCorso(146));
        pannello.add(pulsante = creaPulsante(201));
        
        return pannello;
    }
    
    //metodo creazione label statiche
    private JLabel creaTestiStatici(String testo, int posizioneY) {
        JLabel label = new JLabel(testo);
        label.setBounds(10, posizioneY, 100, 20);
        return label;
    }
    
    //metodo per creare caselle digitabili
    private JTextField creaCaselle(int posizioneY) {
        JTextField field = new JTextField();
        field.setBounds(10, posizioneY, 265, 25);
        return field;
    }
    
    //metodo creazione selettore corsi disponibili
    private JComboBox creaSelettoreCorso(int posizioneY) {
        JComboBox combo = new JComboBox(Corso.getElencoCorsi().toArray());
        combo.setBounds(10, posizioneY, 265, 25);
        combo.setBackground(Color.WHITE);
        return combo;
    }
    
    //metodo creazione pulsante
    private JButton creaPulsante(int posizioneY) {
        JButton button = new JButton("Salva");
        button.setBounds(95, posizioneY, 90, 25);
        button.addActionListener(this);
        return button;
    }
    
    //metodo per creare nuovo studente e aggiungerlo alla lista del rispettivo corso
    private void creaStudente() {
        if(Studente.controlloDatiStudente(nomeStudente.getText(), cognomeStudente.getText())) {
            Studente studente = new Studente(nomeStudente.getText(), cognomeStudente.getText());
            Corso.getElencoCorsi().get(selettoreCorso.getSelectedIndex())
                    .getElencoStudenti().add(studente);
            this.dispose();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pulsante) {
            creaStudente();
        }
    }

}
