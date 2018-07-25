import javax.swing.*;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {

    private Socket socket;
    private LoginUI loginUI;
    private Client client;
    private ClientUI ui;

    public static void main(String[] args) {

        ClientApp app = new ClientApp();
        app.start();

    }

    private void start() {

        try {
            socket = new Socket("127.0.0.1", 2345);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Ошибка подключения");
            System.exit(0);
        }

        client = new DefaultClient();
        ui = new DefaultClientUI();

        // Внедрение через сеттер
        ((DefaultClient) client).setUI(ui);
        ((DefaultClientUI) ui).setClient(client);

        // Внедрение через конструктор
        LoginUI login = new LoginUI(client, socket);
    }

}
