import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;

/**
 * Created by aldartron on 02.02.17.
 */
public class ClientUI extends JFrame {
    JTextArea chatArea = new JTextArea();
    JTextArea messageArea = new JTextArea("Text your message here...");
    JButton sendButton = new JButton("Send");

    Client client;

    ClientUI() {
        GridBagConstraints c = new GridBagConstraints(0,0,2,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0);
        this.setLayout(new GridBagLayout());

        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        messageArea.setLineWrap(true);
        this.add(chatArea, c);
        c.gridwidth = 1; c.gridy = 1; c.weighty = 0.25;

        JScrollPane sp = new JScrollPane(messageArea);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(sp ,c);
        c.gridx = 1; c.weightx = 0.2;
        this.add(sendButton, c);
        sendButton.addActionListener(new SendListener());

        this.setMinimumSize(new Dimension(600,480));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    class SendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            client.send(messageArea.getText());
            messageArea.setText("");
        }
    }

    void say(Message message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("(HH:mm)");
        chatArea.append(dateFormat.format(message.time) + " " + message.author + " : " + message.text + "\n");
    }

}
