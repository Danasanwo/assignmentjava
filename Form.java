import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Form extends JFrame implements ActionListener {

    JTextField singleCommand;
    JTextArea multipleCommand;
    JTextArea errorCommand;
    JButton runButton;
    JButton clearButton;
    JButton resetButton;
    JButton saveButton;
    DrawCanvas canva;

    public void createFile(String content) {

        try {

            File myCode = new File("code.txt");
            if (myCode.createNewFile()) {
                System.out.println("File created: " + myCode.getName());
            } else {
                System.out.println("File already exists.");
            }

            writeToFile(content, "code.txt");
        } catch (IOException a) {
            System.out.println("An error occurred.");
            a.printStackTrace();
        }
    }

    public void writeToFile(String content, String fileName) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    Form() {
        // create panels for command and canvas
        JPanel commandPanel = new JPanel();
        commandPanel.setBackground(Color.white);
        commandPanel.setBounds(0, 0, 500, 500);
        canva = new DrawCanvas();

        // Error PANEL

        JPanel errorPanel = new JPanel();
        errorPanel.setBackground(Color.gray);
        errorPanel.setBounds(0, 500, 1000, 300);

        // create textfields
        singleCommand = new JTextField();
        singleCommand.setPreferredSize(new Dimension(400, 40));
        singleCommand.setBorder(new LineBorder(Color.GRAY, 2));

        multipleCommand = new JTextArea();
        multipleCommand.setPreferredSize(new Dimension(400, 240));
        multipleCommand.setBorder(new LineBorder(Color.GRAY, 2));

        errorCommand = new JTextArea();
        errorCommand.setPreferredSize(new Dimension(800, 200));
        errorCommand.setBorder(new LineBorder(Color.white, 5));

        // create buttons
        runButton = new JButton("Run");
        runButton.setPreferredSize(new Dimension(400, 40));
        runButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(400, 40));
        clearButton.addActionListener(this);

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(400, 40));
        resetButton.addActionListener(this);

        saveButton = new JButton("Save");
        saveButton.setPreferredSize(new Dimension(400, 40));
        saveButton.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setVisible(true);

        // add buttons and textfields

        this.add(commandPanel);
        this.add(canva);
        this.add(errorPanel);
        commandPanel.add(singleCommand);
        commandPanel.add(multipleCommand);
        commandPanel.add(runButton);
        commandPanel.add(clearButton);
        commandPanel.add(resetButton);
        commandPanel.add(saveButton);
        errorPanel.add(errorCommand);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Parser parse = new Parser();
        if (e.getSource() == runButton) {

            if (singleCommand.getText().length() > 0) {

                // SingleCommands
                try {
                    parse.setInstruction((singleCommand.getText()));
                    parse.parseInstruction();

                    String[][] parsedInstructionsArray = { { "", "", "", "" } };
                    int n = parsedInstructionsArray.length;
                    String[][] newparsedInstructionsArray = new String[n + 1][];
                    for (int i = 0; i < n; i++) {
                        newparsedInstructionsArray[i] = parsedInstructionsArray[i];
                    }

                    newparsedInstructionsArray[n] = parse.getParsedInstruction();

                    canva.setGraphicsInstruction(newparsedInstructionsArray);

                    canva.repaint();
                } catch (Exception a) {
                    System.out.println(a.getMessage());
                }

            }

            // MULTIPLE COMMANDS
            if (multipleCommand.getText().length() > 0) {
                try {
                    parse.setMultipleInstruction(multipleCommand.getText());
                    parse.createMultipleParsedInstruction();
                    canva.setGraphicsInstruction(parse.getRefinedParsedArray());

                    canva.repaint();

                } catch (Exception d) {
                    System.out.println(d.getMessage());
                }
            }

        }

        if (e.getSource() == saveButton) {
            createFile(multipleCommand.getText());
        }

        if (e.getSource() == resetButton) {

            String[][] newArr = { { "", "", "", "" } };
            canva.setGraphicsInstruction(newArr);
            canva.repaint();

        }

        if (e.getSource() == clearButton) {

            String[][] newArr = { { "", "", "", "" } };
            canva.setGraphicsInstruction(newArr);
            canva.repaint();

        }

    }
}
