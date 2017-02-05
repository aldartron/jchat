import java.io.*;
import java.net.Socket;

/**
 * Created by aldartron on 02.02.17.
 */
public class ClientThread extends Thread {

    private Socket socket;
    private String nickname;

    private BufferedReader serverReader;
    private BufferedWriter serverWriter;

    ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        try {
            serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            serverWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // Принимаем никнейм подключившегося пользователя
            nickname = serverReader.readLine();
            System.out.println(nickname + " подключился");

        } catch (Exception ex) {ex.printStackTrace();}
        finally {
            try {
                serverReader.close();
                serverWriter.close();
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
}
