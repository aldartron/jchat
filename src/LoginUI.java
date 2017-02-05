import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aldartron on 03.02.17.
 */
public class LoginUI extends JFrame {

    private JLabel label = new JLabel("What is your Nickname?");
    private JTextField nickField = new JTextField();
    private JButton loginButton = new JButton("Login");

    LoginUI() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(3,3,3,3),0,0);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        nickField.setHorizontalAlignment(SwingConstants.CENTER);
        nickField.setFont(new Font("Consolas", Font.PLAIN, 20));

        loginButton.addActionListener(new LoginListener());

        this.add(label, c);
        c.gridy = 1; c.weighty = 1.5;
        this.add(nickField, c);
        c.gridy = 2;
        this.add(loginButton, c);

        this.setMinimumSize(new Dimension(200,150));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocation(500,300);
        this.setTitle("JChat");
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            new Client().login(nickField.getText());
            dispose();
        }
    }
}
