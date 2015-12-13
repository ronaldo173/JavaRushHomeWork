import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Santer on 12.12.2015.
 */
public class TestSocketServer {

    public static void main(String[] args) {
        int port = 6666;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("got a client ");
            System.out.println();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            String line = null;

            while (true) {
                line = in.readUTF();
                System.out.println("client send me: " + line);
                System.out.println("sending back it to upper..");
                out.writeUTF(line.toUpperCase());
                out.flush();
                System.out.println("waiting for next line..\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
