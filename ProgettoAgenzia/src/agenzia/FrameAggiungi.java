package agenzia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/* ************* INTERFACCIA GRAFICA FRAME DI AGGIUNTA IMMOBILE ************* */
public class FrameAggiungi extends JFrame implements ActionListener {
    //attributi

    private final java.util.List<JComponent> listaComponenti;
    private int tipologiaSelezionata; // 0=Appartamento 1=Casa Indip. 2=Box Auto
    //attributi componenti grafici
    private JComboBox selettoreTipologia;
    private JTextField superficie;
    private JTextField prezzo;
    private JTextField piano;
    private JTextField supGiardino;
    private JTextField postiAuto;
    private JCheckBox ascensore;
    private JCheckBox piscina;
    private JButton pulsante;
    private int codice = 0;
    private FramePrincipale framePadre;

    {
        listaComponenti = new java.util.ArrayList<>();
    }
    //costruttore

    public FrameAggiungi(FramePrincipale framePadre) {
        //impostazioni iniziali
        setTitle("Aggiungi Immobile");
        setSize(425, 220);
        setResizable(false);
        setLocationRelativeTo(framePadre);
        //aggiunta pannello
        add(creaPannello());
        //impostazioni finali
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.framePadre = framePadre;
    }
    //creazione pannello

    private JPanel creaPannello() {
        JPanel panel = new JPanel(null);
        creaLabelStatiche("Tipologia:", 10, 10);
        selettoreTipologia = creaSelettore();
        creaLabelStatiche("Superficie:", 180, 10);
        superficie = creaCaselleInput(180, 32);
        creaLabelStatiche("Prezzo:", 300, 10);
        prezzo = creaCaselleInput(300, 32);
        creaLabelStatiche("Piano:", 10, 67);
        piano = creaCaselleInput(10, 89);
        creaLabelStatiche("Sup. Giardino:", 155, 67);
        supGiardino = creaCaselleInput(155, 89);
        supGiardino.setEnabled(false);
        creaLabelStatiche("Posti Auto:", 300, 67);
        postiAuto = creaCaselleInput(300, 89);
        postiAuto.setEnabled(false);
        ascensore = creaCaselleSelezionabili("Ascensore", 7, 137);
        piscina = creaCaselleSelezionabili("Piscina", 150, 137);
        piscina.setEnabled(false);
        pulsante = creaPulsante();
        for (JComponent j : listaComponenti) {
            panel.add(j);
        }
        return panel;
    }
    //creazione label

    private JLabel creaLabelStatiche(String testo, int posizioneX, int posizioneY) {
        JLabel label = new JLabel(testo);
        label.setBounds(posizioneX, posizioneY, 100, 20);
        listaComponenti.add(label);
        return label;
    }
    //creazione caselle di input

    private JTextField creaCaselleInput(int posizioneX, int posizioneY) {
        JTextField field = new JTextField();
        field.setBounds(posizioneX, posizioneY, 100, 25);
        listaComponenti.add(field);
        return field;
    }
    //creazione selettore tipologia immobile

    private JComboBox creaSelettore() {
        JComboBox combo = new JComboBox(new String[]{"Appartamento",
            "Casa Indipendente", "Box Auto"});
        combo.setBounds(10, 32, 150, 25);
        combo.setBackground(Color.WHITE);
        combo.addActionListener(this);
        listaComponenti.add(combo);
        return combo;
    }
    //creazione caselle di selezione

    private JCheckBox creaCaselleSelezionabili(String testo, int posizioneX,
            int posizioneY) {
        JCheckBox check = new JCheckBox(testo);
        check.setBounds(posizioneX, posizioneY, 100, 20);
        listaComponenti.add(check);
        return check;
    }
    //creazione pulsante

    private JButton creaPulsante() {
        JButton button = new JButton("Registra");
        button.setBounds(305, 135, 90, 25);
        button.addActionListener(this);
        listaComponenti.add(button);
        return button;
    }
    //metodo per gestire la selezione di categoria dell'immobile

    private void selezionaCategoriaImmobile() {
        tipologiaSelezionata = selettoreTipologia.getSelectedIndex();
        switch (tipologiaSelezionata) {
            case 0: //selezionato appartamento
                supGiardino.setEnabled(false);
                postiAuto.setEnabled(false);
                piscina.setEnabled(false);
                piano.setEnabled(true);
                ascensore.setEnabled(true);
                break;
            case 1: //selezionata casa indipendente
                supGiardino.setEnabled(true);
                postiAuto.setEnabled(false);
                piscina.setEnabled(true);
                piano.setEnabled(false);
                ascensore.setEnabled(false);
                break;
            case 2: //selezionato box auto
                supGiardino.setEnabled(false);
                postiAuto.setEnabled(true);
                piscina.setEnabled(false);
                piano.setEnabled(false);
                ascensore.setEnabled(false);
                break;
        }
    }
    //gestione eventi

    @Override
    public void actionPerformed(ActionEvent e) {
        //gestione selettore di categoria
        if (e.getSource() == selettoreTipologia) {
            selezionaCategoriaImmobile();
        }
        //click sul pulsante registra
        if (e.getSource() == pulsante) {
            Archivio.getInstance().getElencoImmobili().add(new Immobile(codice++, 55, 55));
            framePadre.aggiornaTabella();
        }
    }
}
