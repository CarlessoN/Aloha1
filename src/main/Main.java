import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Main{

    public static void main(String[] args) {
        //TODO pasar JFrame a una clase pantalla
        JFrame f = new JFrame("Aloha1");
        f.setSize(250, 250);
        f.setLocation(300,200);
        final JTextArea textAreInput = new JTextArea(10, 40);
        final JTextArea textAreOutput = new JTextArea(10, 40);
        f.getContentPane().add(BorderLayout.NORTH, textAreInput);
        final JButton button = new JButton("Execute");
        f.getContentPane().add(BorderLayout.CENTER, button);
        f.getContentPane().add(BorderLayout.SOUTH, textAreOutput);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CommandLineExecutor executor = new CommandLineExecutor();
                for (String line : textAreInput.getText().split("\\n")){
                    Command command = new Command();
                    String[] splited = line.split("\\s+");
                    command.setType(CommandType.valueOf(splited[0]));
                    List<String> descriptions = new LinkedList<>(Arrays.asList(splited));
                    descriptions.remove(0);
                    command.setDescription(descriptions);
                    executor.run(command);
                }
                textAreOutput.append(executor.getResponse());
            }
        });

        f.setVisible(true);

    }

}
