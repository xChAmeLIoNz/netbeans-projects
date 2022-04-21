package progettocompleto;
import it.gdapplicazioni.easy.gui.*;
import fogli.alessandro.mio.timer.MioTimer;
import java.awt.Color;
import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class FramePrincipale extends BasicFrame {

    //attributi
    private JButton timerButton, pdfButton;
    private Table table;
    
    public FramePrincipale(StringBuilder frameTitle, int width,
            int height, JFrame parentFrame, int closeOperation,
            Color frameBackground, Object[] args) {
        super(frameTitle, width, height, parentFrame, closeOperation,
                frameBackground, args);
    }

    @Override
    protected void frameInitialSettings(StringBuilder frameTitle,
            JFrame parentFrame, Color frameBackground, Object... args) {
    }

    @Override
    protected void beforeInstantiateComponentFrameSettings(StringBuilder frameTitle,
            JFrame parentFrame, Color frameBackground, Object... args) {
    }

    @Override
    protected void addMenuBarFrameItem(StringBuilder frameTitle, JFrame parentFrame,
            Color frameBackground, Object... args) {
    }

    @Override
    protected void addToolBarFrameComponents(StringBuilder frameTitle, JFrame parentFrame,
            Color frameBackground, Object... args) {
        timerButton = createToolBarJButton("Timer", 100, 20, Color.blue, 
                Color.WHITE, FONT_SANS_SERIF, FONT_STYLE_NORMAL, 12, CURSOR_HAND, true, true);
        pdfButton = createToolBarJButton("Crea PDF", 100, 20, Color.RED, Color.WHITE,
                FONT_SANS_SERIF , FONT_STYLE_NORMAL, 12, CURSOR_HAND, true, true);
        
        for(JComponent c : toolBarComponents) {
            frameToolbar.add(c);
        }
        toolBarComponents.forEach((c)->{frameToolbar.add(c);});
    }

    @Override
    protected void addPanelFrameComponents(StringBuilder frameTitle, 
            JFrame parentFrame, Color frameBackground, Object... args) {
        table = new Table(new String[]{"Nome","Cognome","Età"}, new int[]{250,250,185},
                new int[]{TEXT_LEFT,TEXT_LEFT,TEXT_CENTER}, 0, false, SELECTION_MONO, 30, TEXT_CENTER, frameBackground, frameBackground, HEIGHT, frameBackground, frameBackground, FONT_SERIF, FONT_STYLE_BOLD, SOMEBITS, ABORT, ABORT, WIDTH, HEIGHT)
    }

    @Override
    protected void afterInstantiateComponentFrameSettings(StringBuilder frameTitle,
            JFrame parentFrame, Object... args) {
    }

    @Override
    protected void frameSizeAdjustment(int frameWidth, int frameHeight,
            int frameInsetTop, int frameInsetBottom, int frameInsetLeft, 
            int frameInsetRight) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
