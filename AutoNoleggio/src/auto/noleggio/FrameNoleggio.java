package auto.noleggio;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class FrameNoleggio extends JFrame implements ActionListener
{
//attributi
private DefaultTableModel modelloTabella;
private JTable tabella;
private FramePrincipale framePadre;
//costruttore
public FrameNoleggio(FramePrincipale framePadre)
{
//impostazioni iniziali
setTitle("Gestione Noleggi");
setSize(1000, 700);
setResizable(false);
setLocationRelativeTo(framePadre);
//aggiunta barra menù
setJMenuBar(creaMenu());
//aggiunta pannello
add(creaPannello());
//impostazioni finali
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setVisible(true);
this.framePadre = framePadre;
}
//creazione menu
private JMenuBar creaMenu()
{
JMenuBar barraMenu = new JMenuBar();
JMenu menu = new JMenu("Gestisci");
JMenuItem item1 = new JMenuItem("Nuovo Noleggio");
item1.setActionCommand("Nuovo Noleggio");
item1.addActionListener(this);
JMenuItem item2 = new JMenuItem("Termina Noleggio");
item2.setActionCommand("Termina Noleggio");
item2.addActionListener(this);
menu.add(item1);menu.add(item2);
barraMenu.add(menu);
return barraMenu;
}
//creazione pannello
private JPanel creaPannello()
{
JPanel panel = new JPanel(null);
panel.add(creaTabella());
return panel;
}
//creazione tabella di visualizzazione
private JScrollPane creaTabella()
{
String[] colonne = {"Data Noleggio","Automobile","Cliente"};
modelloTabella = new DefaultTableModel(colonne, 0);
tabella = new JTable(modelloTabella);
tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
JScrollPane scrollPane = new JScrollPane(tabella);
scrollPane.setBounds(0, 0, 985, 700);
scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
scrollPane.setHorizontalScrollBarPolicy
(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
return scrollPane;
}

//metodo per aggiornare elenco noleggi
public void aggiornaElencoNoleggi() {
    modelloTabella.setRowCount(0);
    for(Noleggio n : Archivio.getInstance().getElencoNoleggi()) {
        modelloTabella.addRow(new String[]{n.getDataInizioNoleggio().toString(), n.getAutomobile().toString(), n.getCliente().toString()});
    }
}

//metodo per avviare un noleggio
private void avviaNoleggio() {
    
    if(Archivio.getInstance().getElencoAutomobili().size() > Archivio.getInstance().getElencoNoleggi().size()) {
        java.util.List<Automobile> list = new ArrayList<>();
        for(Automobile a : Archivio.getInstance().getElencoAutomobili()) {
            if(a.isNoleggiata() == false) {
                list.add(a);                            
            }
        }
        JComboBox comboAuto = new JComboBox(list.toArray());
        JComboBox comboClienti = new JComboBox(Archivio.getInstance().getElencoClienti().toArray());
        Object[] componenti = {comboAuto, comboClienti};
        
        int dialogo = JOptionPane.showConfirmDialog(this, componenti, "Nuovo noleggio", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    
    if(dialogo == JOptionPane.OK_OPTION) {
      
        
        Noleggio n = new Noleggio(LocalDate.now(), (Automobile)comboAuto.getSelectedItem(), 
                (Cliente)comboClienti.getSelectedItem(), LocalDate.now());
        Archivio.getInstance().getElencoNoleggi().add(n);  
        n.getAutomobile().setNoleggiata(true);
        aggiornaElencoNoleggi();
    }
        
    }else {
        JOptionPane.showMessageDialog(this, "Spiacente, non ci sono più auto disponibili");
    }
}

//metodo per terminare il noleggio
private void terminaNoleggio() {
    
    if(tabella.getSelectedRowCount() == 1) {
        
        Noleggio noleggio = Archivio.getInstance().getElencoNoleggi().get(tabella.getSelectedRow());
        noleggio.setDataFineNoleggio(LocalDate.now());
        Archivio.getInstance().getElencoNoleggi().remove(noleggio);
        noleggio.getAutomobile().setNoleggiata(false);
        Period p = Period.between(noleggio.getDataInizioNoleggio(), noleggio.getDataFineNoleggio());
        int giorni = p.getDays();
        if(giorni == 0) {
            giorni += 1;
        }
        JOptionPane.showMessageDialog(this, "La tariffa di noleggio è " + (noleggio.getAutomobile().getTariffaGiornaliera() * giorni));
       
        
        aggiornaElencoNoleggi();
        framePadre.aggiornaElencoAutomobili();
        
    }
}

//gestione eventi
@Override
public void actionPerformed(ActionEvent e)
{
//click nuovo noleggio
if (e.getActionCommand().equals("Nuovo Noleggio"))
{
    avviaNoleggio();
}
//click termina noleggio
if (e.getActionCommand().equals("Termina Noleggio"))
{
    terminaNoleggio();
}
}
}