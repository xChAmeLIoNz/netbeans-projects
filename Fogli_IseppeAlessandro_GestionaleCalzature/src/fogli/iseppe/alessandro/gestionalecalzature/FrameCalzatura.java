package fogli.iseppe.alessandro.gestionalecalzature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/* ********* INTERFACCIA GRAFICA FRAME AGGIUNTA o MODIFICA PRODOTTO ********* */
public class FrameCalzatura extends JFrame implements ActionListener
{
 //attributi
 private final java.util.List<JComponent> componenti;
 //attributi componenti grafici
 private JComboBox selettoreTipologia;
 private JTextField colore;
 private JTextField prezzo;
 private JButton pulsante;
 private FrameMagazzino framePadre;
 private boolean modo;
 private Articolo articolo;
 {
 componenti = new java.util.ArrayList<>();
 }
 //costruttore
 public FrameCalzatura(FrameMagazzino framePadre, String titoloFrame, 
         boolean modo, Articolo articolo)
 {
 //impostazioni iniziali
 setTitle(titoloFrame);
 setSize(295, 270);
 setResizable(false);
 setLocationRelativeTo(framePadre);
 //aggiunta pannello
 add(creaPannello());
 //impostazioni finali
 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 setVisible(true);
 this.framePadre = framePadre;
 this.modo = modo;
 if(this.modo == false) {
     this.articolo = articolo;
     impostaCampi();
 }
 }
 //creazione pannello principale
 private JPanel creaPannello()
 {
 JPanel panel = new JPanel(null);
 creaLabelStatiche("Tipologia:", 10);
 selettoreTipologia = creaSelettore();
 creaLabelStatiche("Colore:", 67);
 colore = creaCaselle(89);
 creaLabelStatiche("Prezzo:", 124);
 prezzo = creaCaselle(146);
 pulsante = creaPulsante();
 for (JComponent j : componenti)
 {
 panel.add(j);
 }
 return panel;
 }
 //creazione label statiche
 private JLabel creaLabelStatiche(String testo, int posizioneY)
 {
 JLabel label = new JLabel(testo);
 label.setBounds(40, posizioneY, 100, 20);
 componenti.add(label);
 return label;
 }
 //creazione selettore tipologia
 private JComboBox creaSelettore()
 {
 JComboBox combo = new JComboBox(new String[]{"Stivale","Mocassino","Tennis"});
 combo.setBounds(40, 32, 200, 25);
 combo.setBackground(Color.WHITE);
 componenti.add(combo);
 return combo;
 }
 //creazione caselle di input
 private JTextField creaCaselle(int posizioneY)
 {
 JTextField field = new JTextField();
 field.setBounds(40, posizioneY, 200, 25);
 componenti.add(field);
 return field;
 }
 //creazione pulsante
 private JButton creaPulsante()
 {
 JButton button = new JButton("Registra");
 button.setBounds(95, 191, 90, 25);
 button.addActionListener(this);
 componenti.add(button);
 return button;
 }
 //metodo per aggiungere articoli
 private void aggiungiArticoli() {
     if(Articolo.controlloDati(colore.getText(), prezzo.getText()
             .replace(",", "."))) {
         if(modo == true) { //aggiungi
            Articolo articolo = new Articolo((String)selettoreTipologia
                    .getSelectedItem(), colore.getText().substring(0, 1)
                            .toUpperCase()+colore.getText().substring(1),
                    Double.parseDouble(prezzo.getText().replace(",", ".")));
            Archivio.getInstance().getElencoArticoli().add(articolo);              
         }else { //modifica
            articolo.setTipologia((String)selettoreTipologia.getSelectedItem());
            articolo.setColore(colore.getText().substring(0, 1)
                            .toUpperCase()+colore.getText().substring(1));
            articolo.setPrezzo(Double.parseDouble(prezzo.getText()
                     .replace(",", ".")));
         }
         framePadre.aggiornaTabella();
         this.dispose();
     }
 }
 //metodo per impostare i campi in mod. modifica
 private void impostaCampi() {
     colore.setText(articolo.getColore());
     prezzo.setText(String.valueOf(articolo.getPrezzo()));
     selettoreTipologia.setSelectedItem(articolo.getTipologia());
 }
 //gestione eventi
 @Override
 public void actionPerformed(ActionEvent e)
 {
 //click sul pulsante
 if (e.getSource() == pulsante)
 {
     aggiungiArticoli();
 }
 }
}

