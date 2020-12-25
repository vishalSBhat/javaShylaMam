import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class q14 extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    static String message;

    static {
        f = new JFrame("Signal Simulator");
        l = new JTextField(15);
        message = "";
    }

    public static void main(String args[]) {

        q14 obj = new q14();

        f.setVisible(true);
        l.setEditable(false);

        JPanel p = new JPanel();
        p.setBackground(Color.black);

        JButton b1, b2, b3;

        b1 = new JButton("Red");
        b2 = new JButton("Yellow");
        b3 = new JButton("Green");

        b1.addActionListener(obj);
        b2.addActionListener(obj);
        b3.addActionListener(obj);

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(l);

        f.add(p);
        f.setSize(250, 250);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s == "Red")
            message = "STOP";
        else if (s == "Yellow")
            message = "READY";
        else if (s == "Green")
            message = "GO";

        l.setText(message);
    }
}
