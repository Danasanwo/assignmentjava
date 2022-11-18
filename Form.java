import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form extends JFrame implements ActionListener {

    JTextField singleCommand;
    JTextArea multipleCommand;
    JButton runButton;
    JButton clearButton;
    JButton resetButton;
    DrawCanvas canva;

    Form() {
        // create panels for command and canvas
        JPanel commandPanel = new JPanel();
        commandPanel.setBackground(Color.white);
        commandPanel.setBounds(0, 0, 500, 500);

        canva = new DrawCanvas();

        // create textfields
        singleCommand = new JTextField();
        singleCommand.setPreferredSize(new Dimension(400, 40));

        multipleCommand = new JTextArea();
        multipleCommand.setPreferredSize(new Dimension(400, 240));

        // create buttons
        runButton = new JButton("Run");
        runButton.setPreferredSize(new Dimension(400, 40));
        runButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(400, 40));

        resetButton = new JButton("Reset");
        resetButton.setPreferredSize(new Dimension(400, 40));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setVisible(true);

        // add buttons and textfields

        this.add(commandPanel);
        this.add(canva);
        commandPanel.add(singleCommand);
        commandPanel.add(multipleCommand);
        commandPanel.add(runButton);
        commandPanel.add(clearButton);
        commandPanel.add(resetButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == runButton) {
            var parse = new Parser();
            parse.setInstruction((singleCommand.getText()));
            parse.parseInstruction();

        }

    }
}
