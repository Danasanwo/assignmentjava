import java.util.Arrays;

public class Parser {
    public String instruction;
    public String[] multipleInstruction;

    // list of possible instructions
    public String[] instructionSet = { "clear", "moveto", "reset", "pen", "line", "draw", "circle", "triangle",
            "rectangle", "fill", "square", "drawto" };

    // set instruction
    public void setInstruction(String command) {
        instruction = command.toLowerCase();
    }

    // get instruction
    public String getInstruction() {
        return instruction;
    }

    // check if the syntax is correct
    public void parseInstruction() {

        // split instruction into several part
        String[] instructionParts = getInstruction().split(" ");
        String firstPart = instructionParts[0];

        String secondPart = instructionParts[1];

        if (secondPart.equals(null)) {
            System.out.println("Put a value");
        }

        String thirdPart = "";
        String fourthPart = "";

        // if the instruction has more than 4 characters, it is invalid
        if (instructionParts.length > 4) {
            System.out.println("intructions longer than 2");
            return;
        }

        // if the instruction matches any of the preset instruction set
        if (Arrays.stream(instructionSet).anyMatch(firstPart::equals)) {
            System.out.println("proceed");
            setParsedInstruction(firstPart, secondPart, thirdPart, fourthPart);
        } else {
            System.out.println("incorrect");
            return;
        }

        if (firstPart.equals("rectangle")) {
            System.out.println("rectangle");
            thirdPart = instructionParts[2];
            Rectangle rectangle = new Rectangle();
            rectangle.width = Integer.parseInt(instructionParts[1]);
            rectangle.height = Integer.parseInt(instructionParts[2]);
        }

        if (firstPart.equals("circle")) {
            System.out.println("circle");
            Circle circle = new Circle();

            circle.setRadius(Integer.parseInt(instructionParts[1]));
        }

        if (firstPart.equals("triangle")) {
            System.out.println("triangle");
        }

        if (firstPart.equals("square")) {
            System.out.println("square");
            thirdPart = instructionParts[1];
            Rectangle rectangle = new Rectangle();
            rectangle.width = Integer.parseInt(instructionParts[1]);
            rectangle.height = Integer.parseInt(instructionParts[1]);
        }

        if (firstPart.equals("moveto")) {
            System.out.println("Move to");
            thirdPart = instructionParts[2];
            Shape shape = new Shape();
            shape.positionX = Integer.parseInt(instructionParts[1]);
            shape.positionY = Integer.parseInt(instructionParts[2]);
        }

        if (firstPart.equals("drawto")) {
            System.out.println("Draw to");
            DrawTo drawTo = new DrawTo();
            thirdPart = instructionParts[2];
            drawTo.newPositionX = Integer.parseInt(instructionParts[1]);
            drawTo.newPositionY = Integer.parseInt(instructionParts[2]);
        }

        if (firstPart.equals("pen")) {
            System.out.println("pen");
        }

        setParsedInstruction(firstPart, secondPart, thirdPart, fourthPart);

    }

    // single parsed instruction
    String[] parsedInstruction = { "", "", "", "" };

    public void setParsedInstruction(String firstPart, String secondPart, String thirdPart, String fourthPart) {
        this.parsedInstruction[0] = firstPart;
        this.parsedInstruction[1] = secondPart;
        this.parsedInstruction[2] = thirdPart;
        this.parsedInstruction[3] = fourthPart;

    }

    public String[] getParsedInstruction() {
        return parsedInstruction;
    }

    public void setMultipleInstruction(String command) {
        multipleInstruction = command.toLowerCase().split("\\r?\\n|\\r");
    }

    public String[] getMultipleInstruction() {
        return multipleInstruction;
    }

    public String[][] refinedParsedArray;

    public String[][] getRefinedParsedArray() {
        return refinedParsedArray;
    }

    public void createMultipleParsedInstruction() {
        Integer count = getMultipleInstruction().length;

        String[][] parsedMultipleArray = new String[count][];

        Integer counter = 0;
        for (var each : getMultipleInstruction()) {
            counter = counter + 1;

            String[] instructionParts = each.split(" ");
            String firstPart = instructionParts[0];
            String secondPart = instructionParts[1];
            String thirdPart = "";
            String fourthPart = "";

            // if the instruction has more than 4 characters, it is invalid
            if (instructionParts.length > 4) {
                System.out.println("intructions longer than 2");
                return;
            }

            // if the instruction matches any of the preset instruction set
            if (Arrays.stream(instructionSet).anyMatch(firstPart::equals)) {
                // System.out.println("proceed");
            } else {
                System.out.println("incorrect");
                return;
            }

            if (firstPart.equals("rectangle")) {
                thirdPart = instructionParts[2];
            }

            if (firstPart.equals("triangle")) {
                System.out.println("triangle");
            }

            if (firstPart.equals("square")) {
                thirdPart = instructionParts[1];
            }

            if (firstPart.equals("moveto")) {
                thirdPart = instructionParts[2];

            }

            if (firstPart.equals("drawto")) {
                thirdPart = instructionParts[2];

            }

            String[] newAr = { firstPart, secondPart, thirdPart, fourthPart };
            parsedMultipleArray[counter - 1] = newAr;
        }

        refinedParsedArray = parsedMultipleArray;

    }
}
