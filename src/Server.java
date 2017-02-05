import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by aldartron on 02.02.17.
 */
public class Server {


    public static void main(String[] args) {
        try {
            ServerSocket socketListener = new ServerSocket(2345);

            while (true) {
                Socket client = null;
                while (client == null) {
                    client = socketListener.accept();
                }
                new ClientThread(client);
            }
        } catch (Exception ex) {ex.printStackTrace();}
    }
}
