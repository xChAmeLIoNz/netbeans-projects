/*
package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {

    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    
    int count = 0;
    
    public GUI() {
        
        frame = new JFrame();
        
        button = new JButton("Click me!");
        button.addActionListener(this);
        
        
        label = new JLabel("Number of clicks: 0");
        
        panel = new JPanel();
        
        
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Java GUI");
        frame.pack();
        frame.setVisible(true);
        
        
        
        
        
    }
    
    public static void main(String[] args) {
        
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}
*/