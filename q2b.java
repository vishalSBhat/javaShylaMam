public class q2b {
    int a;

    q2b(int a) {
        this.a = a;
    }

    q2b(q2b obj) {
        a = obj.a;
        System.out.println("I am constructor taking object as parameter and a = " + a);
    }

    public static void main(String args[]) {
        q2b obj1 = new q2b(10);
        q2b obj2 = new q2b(obj1);
    }
}
