import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public void sendMessage() throws IOException {
        Socket socket = ennew Socket("127.0.0.1", 1337);
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("Hallo");
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());
    }



    public static void main(String[] args) throws IOException {
        Client client = new Client();
        client.sendMessage();

    }
}
