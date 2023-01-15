import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


import javax.swing.JPanel;

public class DrawCanvas extends JPanel {

    public Integer posX = 0;
    public Integer posY = 0;
    public String shapeColour = "#000000";
    public Boolean fillOn = false;
    ArrayList<String> myVariables = new ArrayList<String>();
       

    public ArrayList<String> getMyVariables() {
        return myVariables;
    }

    public void setMyVariables(ArrayList<String> myVariables) {
        this.myVariables = myVariables;
    }

    public void setVar(String variables) {
        myVariables.add(variables);
    }

    public void setColour(String colour) {
        if (colour.equals("black")) {
            this.shapeColour = "#000000";
        }
        if (colour.equals("blue")) {
            this.shapeColour = "#0000FF";
        }
        if (colour.equals("red")) {
            this.shapeColour = "#FF0000";
        }
        if (colour.equals("green")) {
            this.shapeColour = "#00FF00";
        }
        if (colour.equals("YELLO")) {
            this.shapeColour = "#FFFF00";
        }

    }

    public String getColour() {

        return shapeColour;
    }

    public Boolean getFillOn() {
        return fillOn;
    }

    public void setFillOn(String fillOn) {
        if (fillOn.equals("on")) {
            this.fillOn = true;
        }
        if (fillOn.equals("off")) {
            this.fillOn = false;
        }
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public String[][] GraphicsInstruction = { { "", "", "", "" } };

    public void setGraphicsInstruction(String[][] instruction) {
        this.GraphicsInstruction = instruction;
    }

    public String[][] getGraphicsInstruction() {
        return GraphicsInstruction;
    }

    DrawCanvas() {

        this.setBounds(500, 0, 500, 500);

    }

    public void paint(Graphics g) {

        Graphics2D graphicsDrawer = (Graphics2D) g;
        graphicsDrawer.setPaint(Color.decode(getColour()));
        graphicsDrawer.setStroke(new BasicStroke(3));


        try {

            Integer counter = 0;

            String firstPart = "";
            String secondPart = "";
            String thirdPart = "";
            String fourthPart = "";

            for (var each : getGraphicsInstruction()) {
                counter = counter + 1;

            
    
                if (Arrays.stream(each).anyMatch("incorrect"::equals)) {
                    graphicsDrawer.drawString( each[0] + " on line " + counter + " is not a correct syntax", 100, 200);
                    return;
    
                } else {

                if (each[1].equals("=")){
                    setVar(each[0]);
                    setVar(each[2]);

                    System.out.println(getMyVariables());
                }
    
                // move to
                if (each[0].equals("moveto")) {
                    setPosX(Integer.parseInt(each[1]));
                    setPosY(Integer.parseInt(each[2]));
                }
    
                // draw to
    
                if (each[0].equals("drawto")) {
                    graphicsDrawer.drawLine(getPosX(), getPosY(), Integer.parseInt(each[1]),
                            Integer.parseInt(each[2]));
                    setPosX(Integer.parseInt(each[1]));
                    setPosY(Integer.parseInt(each[2]));
                }
    
                // cursor
                if (each[0].equals("")) {
                    graphicsDrawer.fillRect(0, 0, 2, 2);
                }

                // reset 
                if (each[0].equals("reset")) {
                    setPosX(0);
                    setPosY(0);
                    graphicsDrawer.drawOval(0, 0, 25, 25);

                }
                
                // clear 
                if (each[0].equals("clear")) {
                    setPosX(getPosX());
                    setPosY(getPosY());
                    graphicsDrawer.drawOval(0, 0, 0, 0);

                }
    
                // pen colour
    
                if (each[0].equals("pen")) {
                    setColour(each[1]);
                }
    
                // fill shape
                if (each[0].equals("fill")) {
                    setFillOn(each[1]);
                }
    
                if (fillOn) {
    
                    // rectangle
                    if (each[0].equals("rectangle")) {
                        graphicsDrawer.fillRect(getPosX(), getPosY(), Integer.parseInt(each[1]),
                                Integer.parseInt(each[2]));
    
                    }
    
                    // circle
                    if (each[0].equals("circle")) {
    
                        graphicsDrawer.fillOval(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[1]));
    
                    }
    
                    // square
    
                    if (each[0].equals("square")) {
                        graphicsDrawer.fillRect(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[1]));
                    }
    
                    // Triangle
    
                    if (each[0].equals("triangle")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1])/ 2)), getPosX() , getPosX() + Integer.parseInt(each[1]) };
        
                        // y coordinates of vertices
                        int y[] = { getPosY(), (getPosY() + Integer.parseInt(each[2])), (getPosY() + Integer.parseInt(each[2]))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.fillPolygon(x, y, 3);
                        
                    }
    
                    // pentagon
                    if (each[0].equals("pentagon")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1]) * 309 / 1000)), (getPosX() + (Integer.parseInt(each[1]) * 309 / 1000) + (Integer.parseInt(each[1]))) ,
                            (getPosX() +  (Integer.parseInt(each[1]) * 2 * 309 / 1000) + (Integer.parseInt(each[1]))), ((getPosX() +  (Integer.parseInt(each[1]) * 2 * 309 / 1000) + (Integer.parseInt(each[1]))) / 2),
                            getPosX()};
                
                        // y coordinates of vertices
                        int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(each[1]) * 951/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 951/1000) + (Integer.parseInt(each[1]) * 588/1000)), 
                            (getPosY() + (Integer.parseInt(each[1]) * 951/1000))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.fillPolygon(x, y, 5);
                    }
    
                    // hexagon
                    if (each[0].equals("hexagon")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1]) / 2)), (getPosX() + (Integer.parseInt(each[1])/ 2) + (Integer.parseInt(each[1]))) ,
                                (getPosX() +  (Integer.parseInt(each[1]) * 2)), (getPosX() + (Integer.parseInt(each[1])/ 2) + (Integer.parseInt(each[1]))),
                                (getPosX() +  (Integer.parseInt(each[1]) / 2)), getPosX()};
                
                        // y coordinates of vertices
                        int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(each[1]) * 866/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 2 * 866/1000)), (getPosY() + (Integer.parseInt(each[1]) * 2 * 866/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 866/1000))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.fillPolygon(x, y, 6);
                    }
    
                    //oval
    
                    if (each[0].equals("oval")) {
                        graphicsDrawer.fillOval(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[2]));
                    }
    
                }
    
                if (!fillOn) {
    
                    // rectangle
                    if (each[0].equals("rectangle")) {
                        graphicsDrawer.drawRect(getPosX(), getPosY(), Integer.parseInt(each[1]),
                                Integer.parseInt(each[2]));
                        ;
                    }
    
                    // circle
                    if (each[0].equals("circle")) {
                        graphicsDrawer.drawOval(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[1]));
    
                    }
    
                    // square
                    if (each[0].equals("square")) {
                        graphicsDrawer.drawRect(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[1]));
                    }
    
                    // Triangle
                    if (each[0].equals("triangle")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1])/ 2)), getPosX() , getPosX() + Integer.parseInt(each[1]) };
                
                        // y coordinates of vertices
                        int y[] = { getPosY(), (getPosY() + Integer.parseInt(each[2])), (getPosY() + Integer.parseInt(each[2]))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.drawPolygon(x, y, 3);
                    }
    
                    // pentagon
                    if (each[0].equals("pentagon")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1]) * 309 / 1000)), (getPosX() + (Integer.parseInt(each[1]) * 309 / 1000) + (Integer.parseInt(each[1]))) ,
                             (getPosX() +  (Integer.parseInt(each[1]) * 2 * 309 / 1000) + (Integer.parseInt(each[1]))), ((getPosX() +  (Integer.parseInt(each[1]) * 2 * 309 / 1000) + (Integer.parseInt(each[1]))) / 2),
                             getPosX()};
                
                        // y coordinates of vertices
                        int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(each[1]) * 951/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 951/1000) + (Integer.parseInt(each[1]) * 588/1000)), 
                            (getPosY() + (Integer.parseInt(each[1]) * 951/1000))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.drawPolygon(x, y, 5);
                    }
    
                    // hexagon
                    if (each[0].equals("hexagon")) {
    
                        // x coordinates of vertices
                        int x[] = { (getPosX() +  (Integer.parseInt(each[1]) / 2)), (getPosX() + (Integer.parseInt(each[1])/ 2) + (Integer.parseInt(each[1]))) ,
                                (getPosX() +  (Integer.parseInt(each[1]) * 2)), (getPosX() + (Integer.parseInt(each[1])/ 2) + (Integer.parseInt(each[1]))),
                                (getPosX() +  (Integer.parseInt(each[1]) / 2)), getPosX()};
                
                        // y coordinates of vertices
                        int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(each[1]) * 866/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 2 * 866/1000)), (getPosY() + (Integer.parseInt(each[1]) * 2 * 866/1000)),
                            (getPosY() + (Integer.parseInt(each[1]) * 866/1000))};
    
                        // draw the polygon using drawPolygon function
                        graphicsDrawer.drawPolygon(x, y, 6);
                    }
    
                    //oval
    
                    if (each[0].equals("oval")) {
                        graphicsDrawer.drawOval(getPosX(), getPosY(), Integer.parseInt(each[1]), Integer.parseInt(each[2]));
                    }
    
                 }
              }
            }
    

         
        } catch ( Exception a) {
            graphicsDrawer.drawString("there is an error " + a.getLocalizedMessage(), 100, 200);
            a.printStackTrace();
        }

       
    }

}
