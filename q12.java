import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class q12 extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    String s0, s1, s2;

    static {
        f = new JFrame("Simple Calculator");
        l = new JTextField(16);
    }

    q12() {
        s0 = s1 = s2 = "";
    }

    public static void main(String args[]) {

        q12 obj = new q12();

        f.setVisible(true);

        l.setEditable(false);

        JButton b[] = new JButton[10];
        JButton ba, bs, bd, bm, bDot, bcle, beq;

        for (int i = 0; i < 10; ++i)
            b[i] = new JButton("" + i);

        beq = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bd = new JButton("/");
        bm = new JButton("*");
        bcle = new JButton("C");

        bDot = new JButton(".");

        JPanel p = new JPanel();

        for (int i = 0; i < 10; ++i)
            b[i].addActionListener(obj);

        bm.addActionListener(obj);
        bd.addActionListener(obj);
        bs.addActionListener(obj);
        ba.addActionListener(obj);
        bDot.addActionListener(obj);
        beq.addActionListener(obj);
        bcle.addActionListener(obj);

        for (int i = 0; i < 10; ++i)
            p.add(b[i]);

        p.add(l);
        p.add(ba);
        p.add(bs);
        p.add(bm);
        p.add(bd);
        p.add(bDot);
        p.add(beq);
        p.add(bcle);

        p.setBackground(Color.black);
        f.add(p);

        f.setSize(250, 250);
    }

    public double compute() {
        double result;
        if (s1.equals("+"))
            result = (Double.parseDouble(s0) + Double.parseDouble(s2));
        else if (s1.equals("-"))
            result = (Double.parseDouble(s0) - Double.parseDouble(s2));
        else if (s1.equals("/"))
            result = (Double.parseDouble(s0) / Double.parseDouble(s2));
        else
            result = (Double.parseDouble(s0) * Double.parseDouble(s2));

        return result;
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";

            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {

            double result = compute();

            l.setText(s0 + s1 + s2 + "=" + result);

            s0 = Double.toString(result);

            s1 = s2 = "";
        } else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double result = compute();

                s0 = Double.toString(result);

                s1 = s;
                s2 = "";
            }
            l.setText(s0 + s1 + s2);
        }
    }
}
