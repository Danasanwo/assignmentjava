import java.awt.*;
import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

    // public Integer posX = 0;
    // public Integer posY = 0;

    // public Integer getPosX() {
    // return posX;
    // }

    // public void setPosX(Integer posX) {
    // this.posX = posX;
    // }

    // public Integer getPosY() {
    // return posY;
    // }

    // public void setPosY(Integer posY) {
    // this.posY = posY;
    // }

    public String GraphicsInstruction = "";

    public void setGraphicsInstruction(String instruction) {
        this.GraphicsInstruction = instruction;
    }

    public String getGraphicsInstruction() {
        return GraphicsInstruction;
    }

    DrawCanvas() {

        this.setBounds(500, 0, 500, 500);

    }

    public void paint(Graphics g) {
        Graphics2D graphicsDrawer = (Graphics2D) g;
        graphicsDrawer.setBackground(Color.BLUE);

        if (getGraphicsInstruction().equals("")) {
            graphicsDrawer.drawRect(0, 0, 2, 2);
        }

        if (getGraphicsInstruction().equals("moveto")) {
            graphicsDrawer.drawRect(100, 100, 2, 2);
        }
        if (getGraphicsInstruction().equals("rectangle")) {
            graphicsDrawer.drawRect(0, 0, 100, 50);
        }

        if (getGraphicsInstruction().equals("circle")) {

            graphicsDrawer.drawOval(0, 0, 50, 50);
            ;
        }

        if (getGraphicsInstruction().equals("square")) {
            graphicsDrawer.drawRect(0, 0, 100, 100);
        }

        if (getGraphicsInstruction().equals("triangle")) {
            graphicsDrawer.drawPolygon(null);
            ;
        }

        if (getGraphicsInstruction().equals("triangle")) {
            graphicsDrawer.drawRect(0, 0, 100, 50);
        }

        if (getGraphicsInstruction().equals("rectangle")) {
            graphicsDrawer.drawRect(0, 0, 100, 50);
        }

        if (getGraphicsInstruction().equals("drawto")) {
            graphicsDrawer.drawLine(10, 10, 200, 200);
        }

        // graphicsDrawer.setPaint(Color.blue);
        // graphicsDrawer.setStroke(new BasicStroke(2));
        // graphicsDrawer.setPaint(Color.green);
        // graphicsDrawer.drawLine(10, 10, 200, 200);

    }

}
