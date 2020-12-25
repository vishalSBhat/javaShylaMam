import java.lang.*;

class ThreadPriority extends Thread {
    public void run() {
        System.out.println("Inside thread");
    }
}

public class q9 {

    static void print(ThreadPriority t1, ThreadPriority t2, ThreadPriority t3) {
        System.out.println("Thread 1 priority = " + t1.getPriority());
        System.out.println("Thread 2 priority = " + t2.getPriority());
        System.out.println("Thread 3 priority = " + t3.getPriority());
    }

    public static void main(String[] args) {
        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();
        ThreadPriority t3 = new ThreadPriority();

        System.out.println("Before setting priority :\n");
        print(t1, t2, t3);

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("\nAfter setting priority :\n");
        print(t1, t2, t3);

    }
}
