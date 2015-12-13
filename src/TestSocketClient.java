import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Santer on 12.12.2015.
 */
public class TestSocketClient {

    public static void main(String[] args) {
        int serverPort = 6666;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddres = InetAddress.getByName(address);


            Socket socket = new Socket(ipAddres, serverPort);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = "";

            while ((line = reader.readLine()) != null) {
                System.out.println("\nSending line to server..." + line);
                dataOutputStream.writeUTF(line);
                dataOutputStream.flush();

                line = dataInputStream.readUTF();
                System.out.println("Get from server: " + line);
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
