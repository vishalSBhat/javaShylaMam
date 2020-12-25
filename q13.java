import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class q13 extends JFrame implements MouseListener {
    static JFrame f;
    static JLabel l;

    static {
        f = new JFrame("Signal Simulator");
        l = new JLabel("No event");
    }

    public static void main(String args[]) {

        q13 obj = new q13();

        JPanel p = new JPanel();

        p.setLayout(new FlowLayout());
        p.setBackground(Color.black);
        p.add(l);

        f.addMouseListener(obj);

        f.setVisible(true);

        f.add(p);
        f.setSize(250, 250);
    }

    public void mousePressed(MouseEvent e) {
        l.setText("Mouse pressed");
    }

    public void mouseReleased(MouseEvent e) {
        l.setText("Mouse released");
    }

    public void mouseExited(MouseEvent e) {
        l.setText("Mouse exited");
    }

    public void mouseEntered(MouseEvent e) {
        l.setText("Mouse entered");
    }

    public void mouseClicked(MouseEvent e) {
        l.setText("Mouse clicked " + e.getClickCount() + " times.");
    }
}
