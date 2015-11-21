import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ���� on 22.07.2015.
 */
public class Serv_Prim_Server {
    static ServerSocket servers = null;
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat",
            "One word: inappropriate", "Just for today, be honest.  Tell your boss what you *really* think",
            "You might want to rethink that haircut"};

    public static void connect() {
        try {
            servers = new ServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    public static void main(String[] args) {
        Serv_Prim_Server server = new Serv_Prim_Server();
        //connect();
        server.go();
    }

    public void go() {
        try {
            connect();

            //ServerSocket serverSock = new ServerSocket(4444);
            while (true) {
                Socket sock = servers.accept();
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        } catch (IOException ex) {
            System.out.println("Bla bla");
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

}