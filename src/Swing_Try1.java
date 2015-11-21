import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Swing_Try1 implements ActionListener {
    JFrame jFrame;
    JLabel label;

    public static void main(String[] args) {
        Swing_Try1 gui = new Swing_Try1();
        gui.go();

    }

    private void go() {
        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("ЦВЕТ");
        button.addActionListener(new ColorListener());
        JButton buttonLabel = new JButton("ChangeLabel");
        buttonLabel.addActionListener(new LabelListener());

        label = new JLabel("LABEL");

        //MyDrawPanel
        MyDrawPanel drawPanel = new MyDrawPanel();
        jFrame.getContentPane().add(BorderLayout.AFTER_LAST_LINE, button);
        jFrame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        jFrame.getContentPane().add(BorderLayout.EAST, buttonLabel);
        jFrame.getContentPane().add(BorderLayout.WEST, label);
        //jFrame.getContentPane().add(BorderLayout.NORTH, button1);
        jFrame.setSize(700, 700);
        jFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
    }

    class MyDrawPanel extends JPanel {

        public void paint(Graphics g) {
            //g.setColor(Color.cyan);
            //g.fillArc(20,20,650,650, 50,550);
            //Image image=new ImageIcon("C:\\Users\\Саша\\Pictures\\Tank and Helicopter.jpg").getImage();
            //g.drawImage(image, 0,0, this);
            /*
            g.fillRect(0,0,this.getWidth(), this.getHeight());
            int red = (int)(Math.random()*255);
            int green= (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            Color randCol=new Color(red,green, blue);
            g.setColor(randCol);
            //g.fillOval(this.getWidth()/2, this.getHeight()/2, 100,100);
            */
            Graphics2D g2 = (Graphics2D) g;
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            Color startCol = new Color(red, green, blue);
            red = (int) (Math.random() * 255);
            green = (int) (Math.random() * 255);
            blue = (int) (Math.random() * 255);
            Color endCol = new Color(red, green, blue);
            GradientPaint gradient = new GradientPaint(this.getWidth() / 2 - 125, this.getHeight() / 2 - 125, startCol, 450, 450, endCol);
            g2.setPaint(gradient);
            g2.fillOval(this.getWidth() / 2 - 125, this.getHeight() / 2 - 125, 250, 250);

        }
    }

    class LabelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("PRESSE");

        }
    }

    class ColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jFrame.repaint();

        }
    }
}