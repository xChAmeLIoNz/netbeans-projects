package rubrica;

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/* ******************** STRUTTURA GRAFICA FRAME CONTATTO ******************** */
/* ***************** PER NUOVO CONTATTO E MODIFICA CONTATTO ***************** */
public class FrameContatto extends JFrame implements ActionListener
{
//attributi
private java.util.List<JComponent> componenti;
private FrameRubrica padre;
private JTextField campoNome,campoCognome,campoVia,campoCivico,campoCap,
campoComune,campoProvincia,campoTelefono,campoMail;
private JButton pulsante;
{
componenti = new java.util.ArrayList<>();
}
//costruttore
public FrameContatto(FrameRubrica framePadre, String titoloFrame, boolean modo)
{
//impostazioni iniziali
setTitle(titoloFrame);
setSize(455, 385);
setResizable(false);
setLocationRelativeTo(framePadre);
//aggiunta pannello
add(creaPannello());
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

private void creaContatto() {
    if(Contatto.controlloDati(campoNome.getText(), campoCognome.getText(),
            campoVia.getText(), campoCivico.getText(), WIDTH, campoComune.getText(), 
            campoProvincia.getText(), campoTelefono.getText(), campoMail.getText())) {
        Contatto c1 = new Contatto(campoNome.getText(), campoCognome.getText(),
                campoVia.getText(), campoCivico.getText(), Integer.parseInt(campoCap.getText()), 
                campoProvincia.getText(), campoComune.getText(), campoTelefono.getText(),
                campoMail.getText());
        
        Contatto.getElencoContatti().add(c1);
        
    }
}
//gestione eventi
@Override
public void actionPerformed(ActionEvent e)
{
//click sul pulsante
if (e.getSource() == pulsante)
{
    creaContatto();
}
}
}