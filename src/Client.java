import java.io.IOException;
import java.net.Socket;

public interface Client {

    void login(String nickname, Socket socket) throws IOException;
    void send(String text);

}
