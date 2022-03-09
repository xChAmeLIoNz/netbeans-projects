package rubrica2;
import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/* ******************** STRUTTURA GRAFICA FRAME CONTATTO ******************** */
/* ***************** PER NUOVO CONTATTO E MODIFICA CONTATTO ***************** */
public class FrameContatto extends JFrame implements ActionListener
{
//attributi
private FrameRubrica framePadre;
private boolean modo;
private Contatto contatto;
    
    
private java.util.List<JComponent> componenti;
private JTextField campoNome,campoCognome,campoVia,campoCivico,campoCap,
campoComune,campoProvincia,campoTelefono,campoMail;
private JButton pulsante;
{
componenti = new java.util.ArrayList<>();
}
//costruttore
public FrameContatto(FrameRubrica framePadre, String titoloFrame, boolean modo, Contatto contatto)
{
//impostazioni iniziali
this.framePadre = framePadre; //abilitato al funzionamento
this.modo = modo;
setTitle(titoloFrame);
setSize(455, 385);
setResizable(false);
setLocationRelativeTo(framePadre);
//aggiunta pannello
add(creaPannello());
//imposto i valori dei campi in modalità modifica
if(this.modo == false) {
    this.contatto = contatto;
    modificaCampi();
}
//impostazioni finali
setDefaultCloseOperation(DISPOSE_ON_CLOSE);
setVisible(true);
}
//creazione pannello
private JPanel creaPannello()
{
JPanel panel = new JPanel(null);
creaLabelStatiche("Nome:", 10, 10);
campoNome = creaCampiInput(10, 32, 200);
creaLabelStatiche("Cognome:", 230, 10);
campoCognome = creaCampiInput(230, 32, 200);
creaLabelStatiche("Via:", 10, 67);
campoVia = creaCampiInput(10, 89, 300);
creaLabelStatiche("Civico:", 330, 67);
campoCivico = creaCampiInput(330, 89, 100);
creaLabelStatiche("Cap:", 10, 124);
campoCap = creaCampiInput(10, 146, 100);
creaLabelStatiche("Comune:", 130, 124);
campoComune = creaCampiInput(130, 146, 300);
creaLabelStatiche("Provincia:", 10, 181);
campoProvincia = creaCampiInput(10, 203, 200);
creaLabelStatiche("Telefono:", 230, 181);
campoTelefono = creaCampiInput(230, 203, 200);
creaLabelStatiche("Mail:", 10, 238);
campoMail = creaCampiInput(10, 260, 420);
pulsante = creaPulsante();
for (JComponent j : componenti)
{
panel.add(j);
}
return panel;
}
//creazione label statiche
private JLabel creaLabelStatiche(String testo, int posizioneX, int posizioneY)
{
JLabel label = new JLabel(testo);
label.setBounds(posizioneX, posizioneY, 100, 20);
componenti.add(label);
return label;
}
//creazione campi di input
private JTextField creaCampiInput(int posizioneX, int posizioneY, int larghezza)
{
JTextField field = new JTextField();
field.setBounds(posizioneX, posizioneY, larghezza, 25);
componenti.add(field);
return field;
}
//creazione pulsante
private JButton creaPulsante()
{
JButton button = new JButton("Registra");
button.setBounds(169, 305, 100, 25);
button.addActionListener(this);
componenti.add(button);
return button;
}

//metodo per registrare un contatto
private void registraContatto() {
    if(Contatto.controlloDati(campoNome.getText(),campoCognome.getText(),campoVia.getText(),campoCivico.getText(),
    campoCap.getText(),campoComune.getText(),campoProvincia.getText(),campoTelefono.getText(),campoMail.getText())) {
        
        Database db = new Database();
        if(modo == true) {
        contatto = new Contatto(campoNome.getText(), campoCognome.getText(), 
                new Indirizzo(campoVia.getText(), campoCivico.getText(), 
                        Integer.parseInt(campoCap.getText()), campoComune.getText(),
                        campoProvincia.getText()), campoTelefono.getText(), campoMail.getText());
        
        if(db.inserisciContatto(db.creaConnessione(), contatto) == 1) {
            
            int idContatto;
            if((idContatto = db.leggiIdUltimoContatto(db.creaConnessione())) > 0) {
                
                contatto.setId(idContatto);
                Contatto.getContatti().add(contatto);
            }
        }
        }else { //modalità modifica
            contatto.setNome(campoNome.getText());
            contatto.setCognome(campoCognome.getText());
            Indirizzo indirizzo = new Indirizzo(campoVia.getText(), campoCivico.getText(),
                    Integer.parseInt(campoCap.getText()), campoComune.getText(), 
                    campoProvincia.getText());
            contatto.setIndirizzo(indirizzo);
            contatto.setTelefono(campoTelefono.getText());
            contatto.setMail(campoMail.getText());
            db.modificaContatto(db.creaConnessione(), contatto);
        }
        framePadre.aggiornaTabella();
        this.dispose();
    }
}

//metodo per impostare valori dei campi in modalità modifica
private void modificaCampi() {
    
    campoNome.setText(contatto.getNome());
    campoCognome.setText(contatto.getCognome());
    campoVia.setText(contatto.getIndirizzo().getVia());
    campoCivico.setText(contatto.getIndirizzo().getCivico());
    campoCap.setText(String.valueOf(contatto.getIndirizzo().getCap()));
    campoComune.setText(contatto.getIndirizzo().getComune());
    campoProvincia.setText(contatto.getIndirizzo().getProvincia());
    campoTelefono.setText(contatto.getTelefono());
    campoMail.setText(contatto.getMail());
}


//gestione eventi
@Override
public void actionPerformed(ActionEvent e)
{
//click sul pulsante
if (e.getSource() == pulsante)
{
    registraContatto();
}
}
}
