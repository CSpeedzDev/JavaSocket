import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;

    public void start() throws IOException {
         serverSocket = new ServerSocket(1337);
         while (true) {
             Socket socket = serverSocket.accept();
             InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             String t = bufferedReader.readLine();
             if (t.getBytes() == "Hallo".getBytes()){
                 System.out.println("Test");
                 PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                 printWriter.println("Hallo Client");

             }
         }
    }


    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}

