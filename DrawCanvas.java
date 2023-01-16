import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

/**
* <h2> This is the documentation of the Draw Canvas Class" </h2>
* <p> This class contains the Canvas where all the paint works done by the language is Drawn. It is a 500 x 500 piece of canvas
* and it is created using Java swing AWT. It comprises of a CANVAS.
* 
* @author Damilola Anasanwo
* 
*/


public class DrawCanvas extends JPanel {

/**

* <p> Thses are some of the fields created that are used by most of the shapes and give more context to how the drawings happen. </p>
* 
* @author Damilola Anasanwo
* 
*/

    public Integer posX = 0;
    public Integer posY = 0;
    public String shapeColour = "#000000";
    public Boolean fillOn = false;
    public Boolean isIfTrue = true;

    public Boolean getIsIfTrue() {
        return isIfTrue;
    }

    public void setIsIfTrue(Boolean isIfTrue) {
        this.isIfTrue = isIfTrue;
    }


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

 /**
 * <p> The PAINT method is where the hardcore graphics work is initiated. It can fill, draw and delete several shapes in differemnt colors.
 * </p>
 * @since 1.0
 */
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

                    // variables 
                    if (each[1].equals("=")){
                        setVar(each[0]);
                        setVar(each[2]);

                    }

                    firstPart = each[0];
                    secondPart = each[1];
                    thirdPart = each[2];
                    fourthPart = each[3];

                    if (myVariables.contains(secondPart)) {
                        int pos = myVariables.indexOf(secondPart);
                        
                        secondPart = myVariables.get(pos + 1);
                    }
       
                    // if 
                    if (firstPart.equals("if")) {
                        // reconstruct 

                        if (myVariables.contains(each[1])) {

                            int pos = myVariables.indexOf(each[1]);
                            int ifcarrier = 0;
                            String sign = thirdPart;
                            ifcarrier = Integer.parseInt(myVariables.get(pos + 1));



                            if (sign.equals(">")) {
                                System.out.println(">");
                                if (ifcarrier <= Integer.parseInt(fourthPart)) {
                                    System.out.println(false + ">");
                                    setIsIfTrue(false);

                                }
                            }

                            if (sign.equals("<")) {
                                System.out.println("<");
                                if (ifcarrier >= Integer.parseInt(fourthPart)) {
                                    System.out.println(false + "<");
                                    setIsIfTrue(false);

                                }
                            }
                        }

                    }

                    // for 
                    if (firstPart.equals("while")) {
                        if (myVariables.contains(each[1])) {

                            int pos = myVariables.indexOf(each[1]);
                            int forCarrier = 0;
                            String sign = thirdPart;
                            forCarrier = Integer.parseInt(myVariables.get(pos + 1));
                         }
                    }
                    // SYNTAX 

                    if (getIsIfTrue()) {

                        // move to
                        if (firstPart.equals("moveto")) {
                            setPosX(Integer.parseInt(secondPart));
                            setPosY(Integer.parseInt(thirdPart));
                        }
            
                        // draw to
            
                        if (firstPart.equals("drawto")) {
                            graphicsDrawer.drawLine(getPosX(), getPosY(), Integer.parseInt(secondPart),
                                    Integer.parseInt(thirdPart));
                            setPosX(Integer.parseInt(secondPart));
                            setPosY(Integer.parseInt(thirdPart));
                        }
            
                        // cursor
                        if (firstPart.equals("")) {
                            graphicsDrawer.fillRect(0, 0, 2, 2);
                        }

                        // reset 
                        if (firstPart.equals("reset")) {
                            setPosX(0);
                            setPosY(0);
                            graphicsDrawer.drawOval(0, 0, 25, 25);

                        }
                        
                        // clear 
                        if (firstPart.equals("clear")) {
                            setPosX(getPosX());
                            setPosY(getPosY());
                            graphicsDrawer.drawOval(0, 0, 0, 0);

                        }
            
                        // pen colour
            
                        if (firstPart.equals("pen")) {
                            setColour(secondPart);
                        }
            
                        // fill shape
                        if (firstPart.equals("fill")) {
                            setFillOn(secondPart);
                        }
            
                        if (fillOn) {
            
                            // rectangle
                            if (firstPart.equals("rectangle")) {
                                graphicsDrawer.fillRect(getPosX(), getPosY(), Integer.parseInt(secondPart),
                                        Integer.parseInt(thirdPart));
            
                            }
            
                            // circle
                            if (firstPart.equals("circle")) {
            
                                graphicsDrawer.fillOval(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(secondPart));
            
                            }
            
                            // square
            
                            if (firstPart.equals("square")) {
                                graphicsDrawer.fillRect(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(secondPart));
                            }
            
                            // Triangle
            
                            if (firstPart.equals("triangle")) {
            
                                // x coordinates of vertices
                                int x[] = { (getPosX() +  (Integer.parseInt(secondPart)/ 2)), getPosX() , getPosX() + Integer.parseInt(secondPart) };
                
                                // y coordinates of vertices
                                int y[] = { getPosY(), (getPosY() + Integer.parseInt(thirdPart)), (getPosY() + Integer.parseInt(thirdPart))};
            
                                // draw the polygon using drawPolygon function
                                graphicsDrawer.fillPolygon(x, y, 3);
                                
                            }
            
                            // pentagon
                            if (firstPart.equals("pentagon")) {
            
                                // x coordinates of vertices
                                int x[] = { (getPosX() +  (Integer.parseInt(secondPart) * 309 / 1000)), (getPosX() + (Integer.parseInt(secondPart) * 309 / 1000) + (Integer.parseInt(secondPart))) ,
                                    (getPosX() +  (Integer.parseInt(secondPart) * 2 * 309 / 1000) + (Integer.parseInt(secondPart))), ((getPosX() +  (Integer.parseInt(secondPart) * 2 * 309 / 1000) + (Integer.parseInt(secondPart))) / 2),
                                    getPosX()};
                        
                                // y coordinates of vertices
                                int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(secondPart) * 951/1000)),
                                    (getPosY() + (Integer.parseInt(secondPart) * 951/1000) + (Integer.parseInt(secondPart) * 588/1000)), 
                                    (getPosY() + (Integer.parseInt(secondPart) * 951/1000))};
            
                                // draw the polygon using drawPolygon function
                                graphicsDrawer.fillPolygon(x, y, 5);
                            }
            
                            // hexagon
                            if (firstPart.equals("hexagon")) {
            
                                // x coordinates of vertices
                                int x[] = { (getPosX() +  (Integer.parseInt(secondPart) / 2)), (getPosX() + (Integer.parseInt(secondPart)/ 2) + (Integer.parseInt(secondPart))) ,
                                        (getPosX() +  (Integer.parseInt(secondPart) * 2)), (getPosX() + (Integer.parseInt(secondPart)/ 2) + (Integer.parseInt(secondPart))),
                                        (getPosX() +  (Integer.parseInt(secondPart) / 2)), getPosX()};
                        
                                // y coordinates of vertices
                                int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(secondPart) * 866/1000)),
                                    (getPosY() + (Integer.parseInt(secondPart) * 2 * 866/1000)), (getPosY() + (Integer.parseInt(secondPart) * 2 * 866/1000)),
                                    (getPosY() + (Integer.parseInt(secondPart) * 866/1000))};
            
                                // draw the polygon using drawPolygon function
                                graphicsDrawer.fillPolygon(x, y, 6);
                            }
            
                            //oval
            
                            if (firstPart.equals("oval")) {
                                graphicsDrawer.fillOval(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(thirdPart));
                            }
            
                        }
            
                        if (!fillOn) {
        
                        // rectangle
                        if (firstPart.equals("rectangle")) {
                            graphicsDrawer.drawRect(getPosX(), getPosY(), Integer.parseInt(secondPart),
                                    Integer.parseInt(thirdPart));
                            ;
                        }
        
                        // circle
                        if (firstPart.equals("circle")) {
                            graphicsDrawer.drawOval(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(secondPart));
        
                        }
        
                        // square
                        if (firstPart.equals("square")) {
                            graphicsDrawer.drawRect(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(secondPart));
                        }
        
                        // Triangle
                        if (firstPart.equals("triangle")) {
        
                            // x coordinates of vertices
                            int x[] = { (getPosX() +  (Integer.parseInt(secondPart)/ 2)), getPosX() , getPosX() + Integer.parseInt(secondPart) };
                    
                            // y coordinates of vertices
                            int y[] = { getPosY(), (getPosY() + Integer.parseInt(thirdPart)), (getPosY() + Integer.parseInt(thirdPart))};
        
                            // draw the polygon using drawPolygon function
                            graphicsDrawer.drawPolygon(x, y, 3);
                        }
        
                        // pentagon
                        if (firstPart.equals("pentagon")) {
        
                            // x coordinates of vertices
                            int x[] = { (getPosX() +  (Integer.parseInt(secondPart) * 309 / 1000)), (getPosX() + (Integer.parseInt(secondPart) * 309 / 1000) + (Integer.parseInt(secondPart))) ,
                                (getPosX() +  (Integer.parseInt(secondPart) * 2 * 309 / 1000) + (Integer.parseInt(secondPart))), ((getPosX() +  (Integer.parseInt(secondPart) * 2 * 309 / 1000) + (Integer.parseInt(secondPart))) / 2),
                                getPosX()};
                    
                            // y coordinates of vertices
                            int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(secondPart) * 951/1000)),
                                (getPosY() + (Integer.parseInt(secondPart) * 951/1000) + (Integer.parseInt(secondPart) * 588/1000)), 
                                (getPosY() + (Integer.parseInt(secondPart) * 951/1000))};
        
                            // draw the polygon using drawPolygon function
                            graphicsDrawer.drawPolygon(x, y, 5);
                        }
        
                        // hexagon
                        if (firstPart.equals("hexagon")) {
        
                            // x coordinates of vertices
                            int x[] = { (getPosX() +  (Integer.parseInt(secondPart) / 2)), (getPosX() + (Integer.parseInt(secondPart)/ 2) + (Integer.parseInt(secondPart))) ,
                                    (getPosX() +  (Integer.parseInt(secondPart) * 2)), (getPosX() + (Integer.parseInt(secondPart)/ 2) + (Integer.parseInt(secondPart))),
                                    (getPosX() +  (Integer.parseInt(secondPart) / 2)), getPosX()};
                    
                            // y coordinates of vertices
                            int y[] = { getPosY(), getPosY(), (getPosY() + (Integer.parseInt(secondPart) * 866/1000)),
                                (getPosY() + (Integer.parseInt(secondPart) * 2 * 866/1000)), (getPosY() + (Integer.parseInt(secondPart) * 2 * 866/1000)),
                                (getPosY() + (Integer.parseInt(secondPart) * 866/1000))};
        
                            // draw the polygon using drawPolygon function
                            graphicsDrawer.drawPolygon(x, y, 6);
                        }
        
                        //oval
        
                        if (firstPart.equals("oval")) {
                            graphicsDrawer.drawOval(getPosX(), getPosY(), Integer.parseInt(secondPart), Integer.parseInt(thirdPart));
                        }
        
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
