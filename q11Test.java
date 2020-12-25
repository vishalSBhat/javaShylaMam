import java.util.*;

public class q11Test extends Thread {
    static LinkedList<Integer> list;
    int which;
    static int val, capacity;

    static {
        list = new LinkedList<>();
        capacity = 2;
        val = 0;
    }

    q11Test(int which) {
        this.which = which;
    }

    public void run() {
        while (true)
            produceConsume();
    }

    public synchronized void produceConsume() {
        if (this.which == 1) {
            if (list.size() == capacity)
                return;
            else {
                System.out.println("Producer produced-" + val);
                list.add(val++);
            }
        } else {
            if (list.size() == 0)
                return;
            else {
                System.out.println("Consumer consumed-" + list.removeFirst());
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        q11Test obj1 = new q11Test(1);
        q11Test obj2 = new q11Test(0);

        obj1.start();
        obj2.start();
    }
}