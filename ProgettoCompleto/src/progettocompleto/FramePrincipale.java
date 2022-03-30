package progettocompleto;
import it.gdapplicazioni.easy.gui.*;
import fogli.alessandro.mio.timer.MioTimer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
    }

    @Override
    protected void addPanelFrameComponents(StringBuilder frameTitle, 
            JFrame parentFrame, Color frameBackground, Object... args) {
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
