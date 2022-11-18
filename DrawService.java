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
