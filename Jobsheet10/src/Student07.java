public class Student07 {

    String nim, name, className;
    int grade;

    public Student07(String nim, String name, String className) {
        this.nim = nim;
        this.name = name;
        this.className = className;
        this.grade = -1;
    }

    public void tugasDinilai(int grade) {
        this.grade = grade;
        System.out.println("Assignment grade of " + this.name + " is " + grade);
    }
}