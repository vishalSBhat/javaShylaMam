import java.util.*;

class Student {
    String name, usn;
    float marks[];
    static String department;
    static int total;

    static {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Department");
        department = in.nextLine();
        System.out.println("Enter total number of students");
        total = in.nextInt();
    }

    Student() {
        marks = new float[6];
    }

    void getInfo() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name");
        name = in.nextLine();
        System.out.println("Enter USN");
        usn = in.nextLine();
        // System.out.println("Enter Department");
        // department = in.nextLine();
        for (int i = 1; i <= 6; ++i) {
            System.out.println("Enter mark " + i);
            marks[i - 1] = in.nextFloat();
        }
    }

    float avg() {
        float sum = 0.0f;
        for (int i = 0; i < 6; ++i)
            sum += marks[i];
        return sum / 6.0f;
    }

    public static void main(String[] args) {
        Student s[] = new Student[Student.total];
        for (int i = 0; i < Student.total; ++i) {
            s[i] = new Student();
            System.out.println("Enter student " + (i + 1) + " details :");
            s[i].getInfo();
            System.out.println("Average = " + s[i].avg());
        }

    }
}