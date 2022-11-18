
public class Parser {
    public String instruction;
    public String[] instructionSet = { "clear", "moveto", "reset", "pen", "line", "draw", "circle", "triangle",
            "rectangle", "fill", "square", "drawto" };

    public void setInstruction(String command) {
        instruction = command.toLowerCase();
    }

    public String getInstruction() {
        return instruction;
    }

    // public void parseInstruction() {
    // String[] instructionParts = getInstruction().split(" ");

    // if (instructionParts.length > 2) {
    // System.out.println("intructions longer than 2");
    // return;
    // }

    // for (String set : instructionSet) {

    // if ((instructionParts[0]) != set) {
    // System.out.println("not a valid instruction");
    // }

    // }

    // }

    Parser() {

    }
}
