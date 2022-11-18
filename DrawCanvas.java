import java.awt.*;
import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

    DrawCanvas() {

        this.setBounds(500, 0, 500, 500);

    }

    public void paint(Graphics g) {
        Graphics2D graphicsDrawer = (Graphics2D) g;
        graphicsDrawer.setBackground(Color.BLUE);

        // graphicsDrawer.setPaint(Color.blue);
        // graphicsDrawer.setStroke(new BasicStroke(2));
        graphicsDrawer.drawRect(0, 0, 100, 50);
        // graphicsDrawer.setPaint(Color.green);
        // graphicsDrawer.drawLine(10, 10, 200, 200);
    }
}
