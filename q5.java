import java.util.*;

class queue {
    int front, rear, size, arr[];

    queue(int size) {
        front = rear = -1;
        this.size = size;
        arr = new int[size];
    }

    void insert(int value) {
        if (front + 1 == size)
            System.out.println("Queue overflow");
        else {
            if (front == -1)
                rear = 0;
            arr[++front] = value;
        }
    }

    int delete() {
        if (rear == -1)
            System.out.println("Queue empty");
        else {
            int temp = arr[rear++];
            if (rear > front)
                rear = front = -1;
            return temp;
        }
        return 0;
    }

    void display() {
        if (rear == -1) {
            System.out.println("Queue empty");
            return;
        }
        for (int i = rear; i <= front; ++i)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
    }
}

class doubleQueue extends queue {
    doubleQueue(int size) {
        super(size);
    }

    void insert(int side, int value) {
        if (side == 1)
            super.insert(value);
        else {
            if (rear == -1 || rear == 0)
                System.out.println("Cannot insert from rear end");
            else
                arr[--rear] = value;
        }
    }

    int delete(int side) {
        if (side == 1)
            return super.delete();

        if (front == -1) {
            System.out.println("Queue empty");
            return 0;
        } else if (front == 0) {
            int temp = arr[front];
            front = rear = -1;
            return temp;
        } else if (front == rear) {
            System.out.println("Cannot delete from front end");
            return 0;
        } else
            return arr[front--];
    }
}

public class q5 {
    public static void main(String[] args) {
        int size, value, ch = 0, q;
        Scanner in = new Scanner(System.in);
        System.out.println("1.Queue\n2.Double ended Queue");
        q = in.nextInt();
        System.out.println("Enter size of queue");
        size = in.nextInt();

        if (q == 1) {
            queue obj = new queue(size);

            do {
                System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
                ch = in.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter value");
                        value = in.nextInt();
                        obj.insert(value);
                        break;

                    case 2:
                        System.out.println("Deleted item is: " + obj.delete());
                        break;

                    case 3:
                        obj.display();
                }
            } while (ch != 4);
        } else {

            doubleQueue obj = new doubleQueue(size);
            do {
                int side;
                System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
                ch = in.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("0.Rear\n1.Front");
                        side = in.nextInt();
                        System.out.println("Enter value");
                        value = in.nextInt();
                        obj.insert(side, value);
                        break;

                    case 2:
                        System.out.println("0.Front\n1.Rear");
                        side = in.nextInt();
                        System.out.println("Deleted item is: " + obj.delete(side));
                        break;

                    case 3:
                        obj.display();
                }
            } while (ch != 4);
        }
    }
}
