package auto.noleggio;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class FramePrincipale extends JFrame implements ActionListener
{
//attributi
DefaultTableModel modelloTabellaAuto;
JTable tabellaAuto;
JScrollPane pannelloTabellaAuto;
DefaultTableModel modelloTabellaClienti;
JTable tabellaClienti;
JScrollPane pannelloTabellaClienti;
//costruttore
public FramePrincipale()
{
//impostazioni iniziali
setTitle("Autonoleggio");
setSize(1000, 700);
setResizable(false);
setLocationRelativeTo(null);
//aggiunta barra menù
setJMenuBar(creaMenu());
//aggiunta pannello
add(creaPannello());
//aggiorna elenco automobili
//aggiornaElencoAutomobili();
//impostazioni finali
setDefaultCloseOperation(EXIT_ON_CLOSE);
setVisible(true);
}
//creazione menu
private JMenuBar creaMenu()
{
JMenuBar barraMenu = new JMenuBar();
JMenu menu1 = new JMenu("Gestione Parco Auto");
JMenuItem item1 = new JMenuItem("Visualizza Parco Auto");
item1.setActionCommand("Visualizza Parco Auto");
item1.addActionListener(this);
JMenuItem item2 = new JMenuItem("Aggiungi Automobile");
item2.setActionCommand("Aggiungi Automobile");
item2.addActionListener(this);
menu1.add(item1);menu1.add(item2);
JMenu menu2 = new JMenu("Gestione Clienti");
JMenuItem item3 = new JMenuItem("Visualizza Lista Clienti");
item3.setActionCommand("Visualizza Lista Clienti");
item3.addActionListener(this);
JMenuItem item4 = new JMenuItem("Aggiungi Cliente");
item4.setActionCommand("Aggiungi Cliente");
item4.addActionListener(this);
menu2.add(item3);menu2.add(item4);
JMenu menu3 = new JMenu("Gestione Noleggi");
JMenuItem item5 = new JMenuItem("Visualizza Noleggi");
item5.setActionCommand("Visualizza Noleggi");
item5.addActionListener(this);
menu3.add(item5);
barraMenu.add(menu1);barraMenu.add(menu2);barraMenu.add(menu3);
return barraMenu;
}
//creazione pannello principale
private JPanel creaPannello()
{
JPanel panel = new JPanel(null);
panel.add(creaTabellaAuto());
panel.add(creaTabellaClienti());
return panel;
}
//creazione tabella auto
private JScrollPane creaTabellaAuto()
{
String[] array = {"Marca","Modello","Targa","Tariffa/Giorno","Disponibile"};
modelloTabellaAuto = new DefaultTableModel(array, 0);
tabellaAuto = new JTable(modelloTabellaAuto);
tabellaAuto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
pannelloTabellaAuto = new JScrollPane(tabellaAuto);
pannelloTabellaAuto.setBounds(0, 0, 985, 700);
pannelloTabellaAuto.setVerticalScrollBarPolicy
(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
pannelloTabellaAuto.setHorizontalScrollBarPolicy
(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
pannelloTabellaAuto.setVisible(false);
return pannelloTabellaAuto;
}
//creazione tabella clienti
private JScrollPane creaTabellaClienti()
{
String[] array = {"Nome","Cognome","Numero Patente"};
modelloTabellaClienti = new DefaultTableModel(array, 0);
tabellaClienti = new JTable(modelloTabellaClienti);
tabellaClienti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
pannelloTabellaClienti = new JScrollPane(tabellaClienti);
pannelloTabellaClienti.setBounds(0, 0, 985, 700);
pannelloTabellaClienti.setVerticalScrollBarPolicy
(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
pannelloTabellaClienti.setHorizontalScrollBarPolicy
(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
pannelloTabellaClienti.setVisible(false);
return pannelloTabellaClienti;
}

//metodo per visualizzare e aggiornare elenco automobili
void aggiornaElencoAutomobili() {
    
    modelloTabellaAuto.setRowCount(0);
    for(Automobile a : Archivio.getInstance().getElencoAutomobili()) {
        String disponibile;
        if(a.isNoleggiata() == true) {
            disponibile = "No";
        }else {
            disponibile = "Si";
        }
        
        modelloTabellaAuto.addRow(new String[]{a.getMarca(),a.getModello(),a.getTarga(), 
            String.valueOf(a.getTariffaGiornaliera()), disponibile});
        
    }
}

//metodo per aggiornare e visualizzare elenco clienti
void aggiornaElencoClienti() {
    
    modelloTabellaClienti.setRowCount(0);
    for(Cliente c : Archivio.getInstance().getElencoClienti()) {
        modelloTabellaClienti.addRow(new String[]{c.getNome(),c.getCognome(),c.getNumeroPatente()});
    }
}

//metodo per aggiungere automobili
private void aggiungiAuto() {
    JLabel labelMarca = new JLabel("Marca");
    JTextField fieldMarca = new JTextField();
    JLabel labelModello = new JLabel("Modello");
    JTextField fieldModello = new JTextField();
    JLabel labelTarga = new JLabel("Targa");
    JTextField fieldTarga = new JTextField();
    JLabel labelTariffa = new JLabel("Tariffa");
    JTextField fieldTariffa = new JTextField();
    Object[] grafica = {labelMarca, fieldMarca, labelModello, fieldModello,
                            labelTarga, fieldTarga, labelTariffa, fieldTariffa};
    int dialogo = JOptionPane.showConfirmDialog(this, grafica, "Aggiungi automobile", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    
    if(dialogo == JOptionPane.OK_OPTION) {
        if(Automobile.controlloDati(fieldMarca.getText(), fieldModello.getText(),
                fieldTarga.getText(), fieldTariffa.getText().replace(",", "."))) {
            
            
            Automobile automobile = new Automobile(fieldMarca.getText(), 
                    fieldModello.getText(), fieldTarga.getText(), Double.parseDouble(fieldTariffa.getText().replace(",", ".")));
            Archivio.getInstance().getElencoAutomobili().add(automobile);
            aggiornaElencoAutomobili();
            
        }
    }
    
}

private void aggiungiCliente() {
    
    JLabel labelNome = new JLabel("Nome");
    JTextField fieldNome = new JTextField();
    JLabel labelCognome = new JLabel("Cognome");
    JTextField fieldCognome = new JTextField();
    JLabel labelPatente = new JLabel("Numero patente");
    JTextField fieldPatente = new JTextField();
    Object[] grafica = {labelNome, fieldNome, labelCognome, fieldCognome,
                            labelPatente, fieldPatente};
    int dialogo = JOptionPane.showConfirmDialog(this, grafica, "Aggiungi cliente", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    
    if(dialogo == JOptionPane.OK_OPTION) {
        if(Cliente.controlloDati(fieldNome.getText(), fieldCognome.getText(), fieldPatente.getText())) {
            
            Cliente cliente = new Cliente(fieldNome.getText(), fieldCognome.getText(), fieldPatente.getText());
            Archivio.getInstance().getElencoClienti().add(cliente);
            aggiornaElencoClienti();
        }
    }
}



//gestione eventi
@Override
public void actionPerformed(ActionEvent e)
{
//click visualizza parco auto
if (e.getActionCommand().equals("Visualizza Parco Auto"))
{
    pannelloTabellaAuto.setVisible(true);
    aggiornaElencoAutomobili();
}
//click aggiungi automobile
if (e.getActionCommand().equals("Aggiungi Automobile"))
{
    aggiungiAuto();
}
//click visualizza lista clienti
if (e.getActionCommand().equals("Visualizza Lista Clienti"))
{
    pannelloTabellaAuto.setVisible(false); 
    pannelloTabellaClienti.setVisible(true);
    aggiornaElencoClienti();
}
//click aggiungi cliente
if (e.getActionCommand().equals("Aggiungi Cliente"))
{
    aggiungiCliente();
}
//click visualizza noleggi
if (e.getActionCommand().equals("Visualizza Noleggi"))
{
    FrameNoleggio nolo = new FrameNoleggio(this);
    nolo.aggiornaElencoNoleggi();
    
}
}
//metodo main
public static void main(String[] args)
{
new FramePrincipale();
}
}