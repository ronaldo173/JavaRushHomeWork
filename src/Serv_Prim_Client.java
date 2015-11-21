import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ���� on 21.07.2015.
 */
public class Serv_Prim_Client {
    public static void main(String[] args) {
        Serv_Prim_Client client = new Serv_Prim_Client();
        client.go();
    }

    public void go() {
        try {
            Socket s = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Today bla bla " + advice);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
