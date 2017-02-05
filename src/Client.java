import java.io.*;
import java.net.Socket;

/**
 * Created by aldartron on 03.02.17.
 */
public class Client {

    private ClientUI ui;
    private String nickname;

    private BufferedWriter clientWriter;
    private BufferedReader clientReader;

    Client() {
        ui = new ClientUI();
    }

    void login(String nickname) {
        this.nickname = nickname;
        ui.setTitle("JChat | " + nickname);

        // Подключение к сервер
        try {
            Socket socket = new Socket("127.0.0.1", 2345);

            clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Передаем никнейм серверу
            clientWriter.write(this.nickname);

            clientWriter.close();
        } catch (IOException ioe) {ioe.printStackTrace();}
        finally {
            try {
                clientReader.close();
                clientWriter.close();
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }

}
