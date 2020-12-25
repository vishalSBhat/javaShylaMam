public class q2a {
    int a;
    float b;

    q2a() {
        a = 0;
        b = 0.0f;
        System.out.println("a = " + a + "; b = " + b);
    }

    q2a(int a) {
        this.a = a;
        b = 0.0f;
        System.out.println("a = " + a + "; b = " + b);
    }

    q2a(float b) {
        a = 0;
        this.b = b;
        System.out.println("a = " + a + "; b = " + b);
    }

    q2a(int a, float b) {
        this.a = a;
        this.b = b;
        System.out.println("a = " + a + "; b = " + b);
    }

    public static void main(String args[]) {
        q2a obj1 = new q2a();
        q2a obj2 = new q2a(10);
        q2a obj3 = new q2a(1.5f);
        q2a obj4 = new q2a(3, 9);
    }
}
