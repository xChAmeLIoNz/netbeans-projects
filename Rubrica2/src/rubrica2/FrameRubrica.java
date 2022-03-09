package rubrica2;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/* ******************* STRUTTURA GRAFICA FRAME PRINCIPALE ******************* */
public class FrameRubrica extends JFrame implements ActionListener
{
//attributi
private final String[] arrayTabella;
private DefaultTableModel modelloTabella;
private JTable tabella;
{
arrayTabella = new String[]
{
"Nome", "Cognome", "Via", "Civico", "Cap", "Comune", "Provincia",
"Telefono", "Mail"
};
}
//costruttore
public FrameRubrica()
{
//impostazioni iniziali
setTitle("Rubrica");
setSize(1000, 700);
setResizable(false);
setLocationRelativeTo(null);
//aggiunta barra menù
setJMenuBar(creaMenu());
//aggiunta pannello al frame
add(creaPannello());
//aggiornamento iniziale tabella
aggiornaTabella();
//impostazioni finali
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}
//metodo di creazione del menù
private JMenuBar creaMenu()
{
JMenuBar barraMenu = new JMenuBar();
JMenu menu = new JMenu("Gestione");
JMenuItem item1 = new JMenuItem("Nuovo Contatto");
item1.setActionCommand("Nuovo Contatto");
item1.addActionListener(this);
JMenuItem item2 = new JMenuItem("Modifica Contatto");
item2.setActionCommand("Modifica Contatto");
item2.addActionListener(this);
JMenuItem item3 = new JMenuItem("Elimina Contatto");
item3.setActionCommand("Elimina Contatto");
item3.addActionListener(this);
menu.add(item1);menu.add(item2);menu.add(item3);
barraMenu.add(menu);
return barraMenu;
}
//metodo di creazione del pannello contenitore
private JPanel creaPannello()
{
JPanel panel = new JPanel(null);
panel.add(creaTabella());
return panel;
}
//metodo di creazione della tabella
private JScrollPane creaTabella()
{
modelloTabella = new DefaultTableModel(arrayTabella, 0);
tabella = new JTable(modelloTabella);
tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
JScrollPane panel = new JScrollPane(tabella);
panel.setBounds(0, 0, 985, 700);
panel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
panel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
return panel;
}

//metodo per aggiornare la tabella
void aggiornaTabella() {
    modelloTabella.setRowCount(0);
    
    for(Contatto c : Contatto.getContatti()) {
        modelloTabella.addRow(new String[]{c.getNome(),c.getCognome(),c.getIndirizzo().getVia(),
        c.getIndirizzo().getCivico(), String.valueOf(c.getIndirizzo().getCap()),
        c.getIndirizzo().getComune(), c.getIndirizzo().getProvincia(), c.getTelefono(), c.getMail()});
    }
}


//gestione degli eventi
@Override
public void actionPerformed(ActionEvent e)
{
//click menù nuovo
if (e.getActionCommand().equals("Nuovo Contatto"))
{
    new FrameContatto(this, "Nuovo Contatto", true, null);
}
//click menù modifica
if (e.getActionCommand().equals("Modifica Contatto"))
{
    if(tabella.getSelectedRowCount() == 1) {
        
        new FrameContatto(this, "Modifica Contatto", false, Contatto.getContatti().get(tabella.getSelectedRow()));
    }
}
//click menù cancella
if (e.getActionCommand().equals("Elimina Contatto"))
{
    if(tabella.getSelectedRowCount() == 1) {
        Database db = new Database();
        db.cancellaContatto(db.creaConnessione(), 
                Contatto.getContatti().get(tabella.getSelectedRow()).getId());
        Contatto.getContatti().remove(tabella.getSelectedRow());
        aggiornaTabella();
    }
}
}
////metodo main
//public static void main(String[] args)
//{
//new FrameRubrica();
//}
}