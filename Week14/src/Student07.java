public class Student07 {

    String nim;
    String name;
    String className;
    double ipk;

    public Student07() {

    }

    public Student07(String nim, String name, String className, double ipk) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.ipk = ipk;
    }

    public void print() {
        System.out.printf("%s - %s - %s - %.2f%n", nim, name, className, ipk);
    }
}