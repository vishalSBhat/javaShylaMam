import java.util.*;

public class q7 {
    int a, b;

    void getInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Num1");
        try {
            a = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Only integers are allowed");
            throw e;
        }
        System.out.println("Enter Num2");
        try {
            b = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Only integers are allowed");
            throw e;
        }
    }

    void divide() {
        try {
            if (b == 0)
                throw new ArithmeticException();
            System.out.println(a + "/" + b + " is " + a / b);
        } catch (ArithmeticException e) {
            System.out.println("Num2 cannot be zero");
            throw e;
        }
    }

    public static void main(String args[]) throws InputMismatchException, ArithmeticException {
        q7 obj = new q7();
        try {
            obj.getInput();
            obj.divide();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
