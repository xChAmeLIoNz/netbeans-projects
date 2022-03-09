package interfacce.grafiche.parte1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ComponentiVisualizzazione extends JFrame implements ActionListener {

    //attributi
    JPanel pannello;
    
    private JTable tabella;
    private DefaultTableModel modelloTabella;
    private JScrollPane pannelloTabella;
    private JTextPane output;
    private JScrollPane pannelloOutput;
    //costruttore
    public ComponentiVisualizzazione() {
        //impostazioni iniziali
        setTitle("Il mio terzo frame");
        setSize(400,600);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //aggiungere pannello
        pannello = creazionePannello();
        add(pannello);
        //aggiungere menu
        setJMenuBar(creazioneMenu());
        //impostazioni finali
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //metodo creazione barra menu
    private JMenuBar creazioneMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem item1 = new JMenuItem("Apri");
        item1.setActionCommand("Apri");
        item1.addActionListener(this);
        JMenuItem item2 = new JMenuItem("Visualizza");
        item2.setActionCommand("Visualizza"); //quando clicchi hai un comando univoco che lo identifica
        item2.addActionListener(this);
        menu.add(item1);
        menu.add(item2);
        barra.add(menu);
        return barra;
    }
    
    //metodo creazione pannello
    private JPanel creazionePannello() {
        JPanel panel = new JPanel(null);
        panel.add(creazioneTabella());
        panel.add(creazioneOutput());
        
        return panel;
    }
    
    //metodo creazione tabella
    private JScrollPane creazioneTabella() {
        modelloTabella = new DefaultTableModel(new String[] {"Nome","Cognome","Età"}, 0);
        tabella = new JTable(modelloTabella);
        tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pannelloTabella = new JScrollPane(tabella);
        pannelloTabella.setBounds(0,0,385,300);
        pannelloTabella.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pannelloTabella.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return pannelloTabella;
    }

    //metodo creazione struttura output
    private JScrollPane creazioneOutput() {
        output = new JTextPane();
        output.setContentType("text/html");
        pannelloOutput = new JScrollPane(output);
        pannelloOutput.setBounds(0, 300, 385, 300);
        pannelloOutput.setHorizontalScrollBar(null);
        return pannelloOutput;
    }
    
    //metodo per visualizzare dati nella tabella
    private void visualizzaInTabella() {
        String[][] persone = {
            {"Mario", "Rossi", "50"},
            {"Laura", "Bianchi", "32"}
        };
        
        for(int i = 0; i < persone.length; i++) {
            modelloTabella.addRow(persone[i]);
        }
        
    }
    
    //metodo per la visualizzazione in output la riga selezionata
    private void selezionaEVisualizza() {
        if(tabella.getSelectedRow() == 1) {
            int indiceRiga = tabella.getSelectedRow();
            String testo = "L'utente si chiama " + tabella.getValueAt(indiceRiga, 0) +
                    " " + tabella.getValueAt(indiceRiga, 1) + " ed ha " + tabella.getValueAt(indiceRiga, 2) +
                    " anni";
            output.setText(testo);
        }
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Apri")) {
            visualizzaInTabella();
        }
        if(e.getActionCommand().equals("Visualizza")) {
            selezionaEVisualizza();
        }
    }
    
    public static void main(String[] args) {
        new ComponentiVisualizzazione();
    }
}
