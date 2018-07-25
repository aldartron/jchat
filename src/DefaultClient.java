import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;

public class DefaultClient implements Client {

    private ClientUI ui;
    private String nickname;

    private ObjectOutputStream clientOut;
    private ObjectInputStream clientIn;

    DefaultClient() {}

    public void login(String nickname, Socket socket) throws IOException {

        this.nickname = nickname;

        clientOut = new ObjectOutputStream(socket.getOutputStream());
        clientIn = new ObjectInputStream(socket.getInputStream());

        // Передаем приветственное сообщение
        send("[ Joined ]");

        ui.setVisible();

        new DefaultClient.ClientMessageListener();

    }

    public void send(String text) {
        Message message = new Message(this.nickname, new Date(), text);
        try {
            clientOut.writeObject(message);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ошибка подключения");
        }
    }

    class ClientMessageListener extends Thread {

        ClientMessageListener() {
            this.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    ui.say((Message) clientIn.readObject());
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Потеряна связь с сервером");
            }
        }
    }

    public void setUI(ClientUI ui) {
        this.ui = ui;
    }
}
