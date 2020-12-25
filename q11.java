import java.util.*;

class producer extends q11 implements Runnable {
    q11 obj;

    producer(q11 obj) {
        this.obj = obj;
    }

    public void run() {
        try {
            obj.produce();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class consumer extends q11 implements Runnable {
    q11 obj;

    consumer(q11 obj) {
        this.obj = obj;
    }

    public void run() {
        try {
            obj.consume();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class q11 {
    LinkedList<Integer> list;
    int capacity;

    q11() {
    }

    q11(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter size of production");
        int temp = in.nextInt();

        final q11 obj = new q11(temp);

        producer obj1 = new producer(obj);
        consumer obj2 = new consumer(obj);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        Thread.sleep(10);
        t2.start();

        t1.join();
        t2.join();
    }

    public void produce() throws Exception {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (list.size() == capacity)
                    wait();

                System.out.println("Producer produced-" + value);

                list.add(value++);

                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {

                while (list.size() == 0)
                    wait();

                int val = list.removeFirst();

                System.out.println("Consumer consumed-" + val);

                notify();
                Thread.sleep(1000);
            }
        }
    }
}