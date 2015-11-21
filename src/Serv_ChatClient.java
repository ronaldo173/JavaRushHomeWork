import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ���� on 22.07.2015.
 */
public class Serv_ChatClient {

    JTextField out;
    PrintWriter writer;
    Socket socket;
    JTextArea incom;
    BufferedReader reader;

    public static void main(String[] args) {
        new Serv_ChatClient().go();
    }

    public void go() {
        JFrame frame = new JFrame("Client");
        JPanel mainP = new JPanel();
        incom = new JTextArea(15, 50);
        incom.setLineWrap(true);
        incom.setWrapStyleWord(true);
        incom.setEditable(false);
        JScrollPane qScroll = new JScrollPane(incom);
        // qScroll.setVerticalScrollBar(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        out = new JTextField(20);
        JButton sendBut = new JButton("SEND");
        sendBut.addActionListener(new SendButttonListener());
        mainP.add(out);
        mainP.add(sendBut);
        frame.getContentPane().add(BorderLayout.CENTER, mainP);
        setUpNetworking();
        frame.setSize(500, 700);
        frame.setVisible(true);
        Thread readerThread = new Thread(new IncomingReader());

    }

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1", 5000);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(streamReader);

            writer = new PrintWriter(socket.getOutputStream());
            System.out.println("networking go go");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class SendButttonListener implements ActionListener {

        Object o = new float[20];

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                writer.println(out.getText());
                writer.flush();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

            out.setText("");
            out.requestFocus();
            //int i=new .valueOf(3);
        }
    }

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
