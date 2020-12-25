class square extends q4 {
    int side;

    square() {
        side = 4;
    }

    public void area() {
        System.out.println("Area is " + side * side);
    }
}

class rectangle extends q4 {
    int l, b;

    rectangle() {
        l = 4;
        b = 5;
    }

    public void area() {
        System.out.println("Area is " + l * b);
    }
}

class triangle extends q4 {
    int b, h;

    triangle() {
        b = 4;
        h = 6;
    }

    public void area() {
        System.out.println("Area is " + b * h * 0.5);
    }
}

class circle extends q4 {
    int rad;

    circle() {
        rad = 4;
    }

    public void area() {
        System.out.println("Area is " + rad * rad * 3.14);
    }
}

public class q4 {
    public void area() {
        System.out.println("Area is null");
    }

    public static void main(String args[]) {
        square obj1 = new square();
        rectangle obj2 = new rectangle();
        triangle obj3 = new triangle();
        circle obj4 = new circle();

        obj1.area();
        obj2.area();
        obj3.area();
        obj4.area();
    }
}