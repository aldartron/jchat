import java.net.Socket;

/**
 * Created by aldartron on 02.02.17.
 */
public class ClientThread extends Thread {
    private Socket socket;

    ClientThread(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        try {

        } catch (Exception ex) {}
    }
}
