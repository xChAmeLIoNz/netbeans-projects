package fogli.iseppe.alessandro.gestionalecalzature;

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
/* ****************** INTERFACCIA GRAFICA FRAME PRINCIPALE ****************** */
public class FrameMagazzino extends JFrame implements ActionListener
{
 //attributi
 private DefaultTableModel modelloTabella;
 private JTable tabella;
 //costruttore
 public FrameMagazzino()
 {
 //impostazioni iniziali
 setTitle("Azienda Calzature");
 setSize(700, 700);
 setResizable(false);
 setLocationRelativeTo(null);
 //aggiunta menù
 setJMenuBar(creaMenu());
 //aggiunta pannello
 add(creaPannello());
 //aggiornamento
 aggiornaTabella();
 //impostazioni finali
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setVisible(true);
 }
 //creazione menù
 private JMenuBar creaMenu()
 {
 JMenuBar barraMenu = new JMenuBar();
 JMenu menu = new JMenu("Gestione Magazzino");
 JMenuItem item1 = new JMenuItem("Aggiungi Articolo");
 item1.setActionCommand("Aggiungi Articolo");
 item1.addActionListener(this);
 JMenuItem item2 = new JMenuItem("Modifica Articolo");
 item2.setActionCommand("Modifica Articolo");
 item2.addActionListener(this);
 JMenuItem item3 = new JMenuItem("Elimina Articolo");
 item3.setActionCommand("Elimina Articolo");
 item3.addActionListener(this);
 menu.add(item1);menu.add(item2);menu.add(item3);
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
 //creazione tabella
 private JScrollPane creaTabella()
 {
 modelloTabella = new DefaultTableModel(new String[]{"Tipologia",
 "Colore","Prezzo"}, 0);
 tabella = new JTable(modelloTabella);
 tabella.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 JScrollPane scroll = new JScrollPane(tabella);
 scroll.setBounds(0, 0, 685, 700);
 scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 return scroll;
 }
 //metodo per aggiornare la tabella
 public void aggiornaTabella() {
     modelloTabella.setRowCount(0);
     for(Articolo a : Archivio.getInstance().getElencoArticoli()) {
         modelloTabella.addRow(new String[] {a.getTipologia(),
             a.getColore(), String.valueOf(a.getPrezzo())});
     }
 }
 //metodo per eliminare articoli
 private void eliminaArticoli() {
     if(tabella.getSelectedRowCount() == 1) {
         Archivio.getInstance().getElencoArticoli()
                 .remove(tabella.getSelectedRow());
         aggiornaTabella();
     }
 }
 //gestione eventi
 @Override
 public void actionPerformed(ActionEvent e)
 {
 //click menù aggiungi articolo
 if (e.getActionCommand().equals("Aggiungi Articolo"))
 {
    new FrameCalzatura(this, "Aggiungi Articolo", true, null);
 }
 //click menù modifica articolo
 if (e.getActionCommand().equals("Modifica Articolo"))
 {
     if(tabella.getSelectedRowCount() == 1) {
        new FrameCalzatura(this, "Modifica Articolo", false,
                Archivio.getInstance().getElencoArticoli()
                        .get(tabella.getSelectedRow()));
     }
 }
 
 //click menù elimina articolo
 if (e.getActionCommand().equals("Elimina Articolo"))
 {
     eliminaArticoli();
 }
 }
 
 //metodo main
 public static void main(String[] args)
 {
 new FrameMagazzino();
 }
}
