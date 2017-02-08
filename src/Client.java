import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by aldartron on 03.02.17.
 */
public class Client {

    private ClientUI ui;
    private String nickname;

    private ObjectOutputStream clientOut;
    private ObjectInputStream clientIn;

    Client() {
        ui = new ClientUI();
        ui.client = this;
    }

    void login(String nickname) {
        this.nickname = nickname;
        ui.setTitle("JChat | " + nickname);

        // Подключение к серверу
        try {
            Socket socket = new Socket("127.0.0.1", 2345);

            clientOut = new ObjectOutputStream(socket.getOutputStream());
            clientIn = new ObjectInputStream(socket.getInputStream());

            // Передаем приветственное сообщение
            send("[ Joined ]");

            new ClientMessageListener();

        } catch (Exception ex) {ex.printStackTrace();}
    }

    void send(String text) {
        Message message = new Message(this.nickname, new Date(), text);
        try {
            clientOut.writeObject(message);
        } catch (Exception ex) {ex.printStackTrace();}
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
                ex.printStackTrace();
            }
        }
    }
}

