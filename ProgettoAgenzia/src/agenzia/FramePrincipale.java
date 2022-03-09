package agenzia;

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/* ****************** INTERFACCIA GRAFICA FRAME PRINCIPALE ****************** */
public class FramePrincipale extends JFrame implements ActionListener {
    //attributi

    DefaultTableModel modelloTabella;
    JTable tabella;
    //costruttore

    public FramePrincipale() {
        //impostazioni iniziali
        setTitle("Agenzia Immobiliare");
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        //aggiunta barra menù
        setJMenuBar(creaMenu());
        //aggiunta pannello
        add(creaPannello());
        //impostazioni finali
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //creazione barra menù

    private JMenuBar creaMenu() {
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Gestione");
        JMenuItem item = new JMenuItem("Aggiungi Immobile");
        item.setActionCommand("Aggiungi Immobile");
        item.addActionListener(this);
        menu.add(item);
        barraMenu.add(menu);
        return barraMenu;
    }
    //creazione pannello principale

    private JPanel creaPannello() {
        JPanel panel = new JPanel(null);
        panel.add(creaTabella());
        return panel;
    }
    //creazione tabella di visualizzazione immobili

    private JScrollPane creaTabella() {
        String[] colonne = {"Codice", "Tipologia", "Superficie", "Prezzo", "Piano",
            "Ascensore", "Giardino", "Piscina", "Posti Auto"};
        modelloTabella = new DefaultTableModel(colonne, 0);
        tabella = new JTable(modelloTabella);
        tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane pannello = new JScrollPane(tabella);
        pannello.setBounds(0, 0, 985, 700);
        pannello.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pannello.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return pannello;
    }
    
    //metodo per aggiornare la tabella
    void aggiornaTabella() {
        modelloTabella.setRowCount(0);
        for(Immobile i : Archivio.getInstance().getElencoImmobili()) {
            modelloTabella.addRow(new String[]{String.valueOf(i.getCodice()),
                String.valueOf(i.getPrezzo()),
                String.valueOf(i.getSuperficieImmobile())});
        }
    }
    //gestione eventi

    @Override
    public void actionPerformed(ActionEvent e) {
        //click sul menù aggiungi immobile
        if (e.getActionCommand().equals("Aggiungi Immobile")) {
            new FrameAggiungi(this);
        }
    }
    //metodo main

    public static void main(String[] args) {
        new FramePrincipale();
    }
}
