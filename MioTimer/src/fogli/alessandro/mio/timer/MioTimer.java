package fogli.alessandro.mio.timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * CLASSE PER ISTANZIARE UN TIMER
 * @author admin
 */
public class MioTimer extends JComponent implements ActionListener {

    //componenti grafici
    private JFrame window;
    private JLabel timerLabel;
    private JButton btnStart,btnStop,btnReset;
    
    //variabili necessarie per il timer
    private Timer timer;
    private long tempoTrascorso,tempoIniziale,tempoPrecedente;
    private int ore,minuti,secondi;
    
    /**
     * COSTRUTTORE 
     * @param parent JFrame padre 
     */
    public MioTimer(JFrame parent) {
        window = new JFrame("Timer");
        window.setSize(270, 130);
        window.setLocationRelativeTo(parent);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.add(createPanel());
        initTimer();
        window.setVisible(true);
    }
    
    private JLabel createLabel() {
        JLabel label = new JLabel("00:00:00");
        label.setBounds(100, 10, 50, 25);
        return label;
    }
    
    private JButton createButton(String text, int posX) {
        JButton button = new JButton(text);
        button.setBounds(posX, 50, 70, 20);
        button.setBackground(Color.LIGHT_GRAY);
        button.addActionListener(this);
        return button;
    }
    
    private JPanel createPanel() {
        JPanel panel = new JPanel (null);
        panel.setBackground(Color.WHITE);
        panel.add(timerLabel=createLabel());
        panel.add(btnStart=createButton("Start", 10));
        panel.add(btnStop=createButton("Stop", 90));
        panel.add(btnReset=createButton("Reset", 170));
        return panel;
    }
    
    private void initTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tempoTrascorso = System.currentTimeMillis()-tempoIniziale+tempoPrecedente;
                secondi = (int) (tempoTrascorso/1000%60);
                minuti = (int) (tempoTrascorso/60000%60);
                ore = (int) (tempoTrascorso/3600000%60);
                String timerText = String.format("%02d:%02d:%02d", ore, minuti, secondi);
                timerLabel.setText(timerText);
            }
        });
    }
    
    /**
     * METODO PER RITORNARE TEMPO TRASCORSO IN FORMATO STRINGA
     * @return String 
     */
    public String getTime() {
        return timerLabel.getText();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnStart) {
            tempoIniziale = System.currentTimeMillis();
            timer.start();
        }
        if (e.getSource() == btnStop) {
            tempoPrecedente = tempoTrascorso;
            timer.stop();
        }
        if (e.getSource() == btnReset) {
            timer.stop();
            tempoIniziale = 0;
            tempoPrecedente = 0;
            timerLabel.setText("00:00:00");
        }
    }

}
