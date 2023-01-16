/**
* <h2> This is the documentation of the Draw Service Class" </h2>
* <p> This class contains the purposed draw service class used to draw all the shapes.
* </p>
* @author Damilola Anasanwo
* 
*/
public class DrawService {
    Shape shape = new Shape();

    public void moveTo(int x, int y) {

        shape.positionX = x;
        shape.positionY = y;
    }

    public void fill(String colour) {
        shape.fillColour = colour;
    }

    public void paint(String colour) {
        shape.penColour = colour;
    }

}
