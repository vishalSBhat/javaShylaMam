import java.lang.Thread;

public class q10 extends Thread {
    String msg;
    int time;

    q10(String msg, int time) {
        this.msg = msg;
        this.time = time;
    }

    public void run() {
        this.print();
    }

    public synchronized void print() {
        while (true) {
            System.out.println(msg);
            try {
                Thread.sleep(time);
            } catch (Exception e) {
                System.out.println(e);
                System.exit(0);
            }
        }
    }

    public static void timeout() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        q10 t1 = new q10("Good Morning", 1000);
        q10 t2 = new q10("Hello", 2000);
        q10 t3 = new q10("Welcome", 3000);

        t1.start();
        timeout();

        t2.start();
        timeout();

        t3.start();
    }

}
