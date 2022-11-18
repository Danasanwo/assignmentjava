import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Canvas extends JFrame {

    Canvas() {

        JPanel canvasPanel = new JPanel();
        canvasPanel.setBackground(Color.black);
        canvasPanel.setBounds(500, 0, 500, 500);
    }
}
