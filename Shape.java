
/**
* <h2> This is the documentation of the Factory Shape Class" </h2>
* <p> This class contains the basic framework for which other shapes are created as it has the basic properties for shapes on which peculiar shapes like circle, rectangles, triangles are built on 
* </p>
* @author Damilola Anasanwo
* 
*/
public class Shape {

    public Integer positionX;
    public Integer positionY;
    public String penColour;
    public String fillColour;
    public boolean colourShape = false;
    public boolean fillShape = false;

    public void drawShape() {
        System.out.println("Draw Shape");
    }

}