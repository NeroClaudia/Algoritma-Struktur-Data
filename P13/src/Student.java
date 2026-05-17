public class Student {

    String nim, name, className;
    double gpa;

    public Student() {
    }

    public Student(String nim, String name, String className, double gpa) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.gpa = gpa;
    }

    void print() {
        System.out.printf("\n%s - %s - %s - %.2f", nim, name, className, gpa);
    }
}