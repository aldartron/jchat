import javax.swing.*;
import java.awt.*;

/**
 * Created by aldartron on 02.02.17.
 */
public class ServerUI extends JFrame{

    JTextArea usersList = new JTextArea();
    JButton startButton = new JButton("Start");

    ServerUI() {
        GridBagConstraints c = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);

        this.setLayout(new GridBagLayout());
        this.add(usersList, c);
        usersList.setEditable(false);
        c.gridy = 1; c.weighty = 0.1;
        this.add(startButton, c);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300,300));
        this.setLocation(800,500);
        this.setVisible(true);
        this.setTitle("JChat Server");
    }
}
