abstract class shape {
    int a, b;

    public abstract void area();
}

class rectangle extends shape {
    rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void area() {
        System.out.println("Area of rectangle is " + a * b);
    }
}

class triangle extends shape {
    triangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void area() {
        System.out.println("Area of triangle is " + 0.5 * a * b);
    }
}

class circle extends shape {
    circle(int a) {
        this.a = a;
    }

    public void area() {
        System.out.println("Area of circle is " + 3.14 * a * a);
    }
}

public class q6 {
    public static void main(String[] args) {
        rectangle obj1 = new rectangle(2, 5);
        obj1.area();

        triangle obj2 = new triangle(2, 5);
        obj2.area();

        circle obj3 = new circle(5);
        obj3.area();
    }
}
