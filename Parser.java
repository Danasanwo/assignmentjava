import java.util.Arrays;

public class Parser {
    public String instruction;

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
        String thirdPart = instructionParts[2];
        String fourthPart = instructionParts[3];

        // if the instruction has more than 4 characters, it is invalid
        if (instructionParts.length > 4) {
            System.out.println("intructions longer than 2");
            return;
        }

        // if the instruction matches any of the preset instruction set
        if (Arrays.stream(instructionSet).anyMatch(firstPart::equals)) {
            System.out.println("proceed");

        } else {
            System.out.println("koshidanu");
            return;
        }

        // }

    }

    Parser() {

    }
}
