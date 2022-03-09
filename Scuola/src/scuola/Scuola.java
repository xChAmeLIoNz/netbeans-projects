package scuola;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class Scuola extends JFrame implements ActionListener{

    private JPanel pannello;
    private DefaultTableModel modelloTabella;
    private JTable tabella;
    private JScrollPane pannelloTabella;
    private JTextPane schedaCorso;
    private JScrollPane pannelloSchedaCorso;
    //costruttore
    public Scuola() {
        //impostazioni iniziali frame
        setTitle("Scuola");
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        
        //impostazione menu
        setJMenuBar(creaMenu());
        //aggiunta pannello
        add(creaPannello());
        //aggiorna tabella corsi
        aggiornaTabellaCorsi();
        
        //impostazioni finali
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //metodo per creare il menu
    private JMenuBar creaMenu() {
        JMenuBar barra = new JMenuBar();
        JMenu menu1 = new JMenu("Gestione Corsi");
        JMenuItem item1 = new JMenuItem("Aggiungi Corso");
        item1.setActionCommand("Aggiungi Corso");
        item1.addActionListener(this);
        JMenuItem item2 = new JMenuItem("Scheda Corso");
        item2.setActionCommand("Scheda Corso");
        item2.addActionListener(this);
        menu1.add(item1);
        menu1.add(item2);
        
        JMenu menu2 = new JMenu("Gestione Studenti");
        JMenuItem item3 = new JMenuItem("Aggiungi Studente");
        item3.setActionCommand("Aggiungi Studente");
        item3.addActionListener(this);
        menu2.add(item3);
        barra.add(menu1);
        barra.add(menu2);
        return barra;
        
    }
    
    //metodo per creare pannello
    private JPanel creaPannello() {
        pannello = new JPanel(null);
        pannello.add(creaTabella());
        pannello.add(creaSchedaCorso());
        
        return pannello;
    }
    
    //metodo per creare la tabella
    private JScrollPane creaTabella() {
        modelloTabella = new DefaultTableModel(new String[]{"CODICE", "MATERIA"}, 0);
        tabella = new JTable(modelloTabella);
        tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        pannelloTabella = new JScrollPane(tabella);
        pannelloTabella.setBounds(0, 0, 485, 650);
        pannelloTabella.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pannelloTabella.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return pannelloTabella;
    }
    
    //metodo per creare scheda corso
    private JScrollPane creaSchedaCorso() {
        schedaCorso = new JTextPane();
        pannelloSchedaCorso = new JScrollPane(schedaCorso);
        schedaCorso.setBounds(500, 0, 500, 650);
        pannelloSchedaCorso.setHorizontalScrollBar(null); //non compare la barra ma scrollo col mouse
        return pannelloSchedaCorso;
    }
    
    //metodo per aggiungere un corso
    private void creaNuovoCorso() {
        JLabel label1 = new JLabel("Codice corso");
        JTextField codiceCorso = new JTextField();
        JLabel label2 = new JLabel("Materia corso");
        JTextField materiaCorso = new JTextField();
        Object[] grafica = {label1, codiceCorso, label2, materiaCorso};
        int dialogo = JOptionPane.showConfirmDialog(this, grafica, "Crea nuovo corso", 
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if(dialogo == JOptionPane.OK_OPTION) {
            if(Corso.controlloDatiCorso(codiceCorso.getText(), materiaCorso.getText())) {
                Corso corso = new Corso(codiceCorso.getText(), materiaCorso.getText());
                Corso.getElencoCorsi().add(corso);
                aggiornaTabellaCorsi();
            }
        }
    }
    
    //metodo per aggiornare lo stato della tabella corsi
    private void aggiornaTabellaCorsi() {
        modelloTabella.setRowCount(0);
        for(Corso c : Corso.getElencoCorsi()) {
            modelloTabella.addRow(new String[]{c.getCodice(),c.getMateria()});
        }
    }
    
    //metodo per visualizzare la scheda completa di un corso
    private void visualizzazioneSchedaCorso() {
        if(tabella.getSelectedRowCount() == 1) {
            schedaCorso.setText("");
            Corso c = Corso.getElencoCorsi().get(tabella.getSelectedRow());
            StringBuilder testo = new StringBuilder();
            
            testo.append("SCHEDA CORSO \n\n");
            testo.append("Codice: ").append(c.getCodice()).append("\n");
            testo.append("Materia: ").append(c.getMateria()).append("\n");
            testo.append("Elenco studenti: \n");
            for(Studente s : c.getElencoStudenti()) {
                testo.append(s).append("\n");
            }
            schedaCorso.setText(testo.toString());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Aggiungi Corso")) {
            creaNuovoCorso();
        }
        if(e.getActionCommand().equals("Scheda Corso")) {
            visualizzazioneSchedaCorso();
        }
        if(e.getActionCommand().equals("Aggiungi Studente")) {
            if(Corso.getElencoCorsi().size() > 0) {
            new AggiungiStudente(this);
            }
        }
    }
    
    public static void main(String[] args) {
        new Scuola();
    }

}
