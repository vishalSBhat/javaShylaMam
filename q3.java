import java.util.*;

public class q3 {
    float area(float b, float h) {
        return 0.5f * b * h;
    }

    float area(float r) {
        return 3.14f * r * r;
    }

    int area(int b, int l) {
        return l * b;
    }

    int area(int s) {
        return s * s;
    }

    public static void main(String args[]) {
        float a, b;
        int c, d;
        Scanner in = new Scanner(System.in);
        q3 obj = new q3();
        System.out.println("Enter base and height of triangle");
        a = in.nextFloat();
        b = in.nextFloat();
        System.out.println("Area of triangle: " + obj.area(a, b));
        System.out.println("Enter radius of circle");
        a = in.nextFloat();
        System.out.println("Area of circle: " + obj.area(a));
        System.out.println("Enter length and breadth of rectangle");
        c = in.nextInt();
        d = in.nextInt();
        System.out.println("Area of rectangle: " + obj.area(c, d));
        System.out.println("Enter side of square");
        c = in.nextInt();
        System.out.println("Area of square: " + obj.area(c));
    }
}
