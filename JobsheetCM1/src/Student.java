public class Student {

    String nim, name, study_program;

    public Student() {

    }

    public Student(String nim, String name, String study_program) {
        this.nim = nim;
        this.name = name;
        this.study_program = study_program;
    }

    public void printStudent() {
        System.out.printf("\nNIM: %s | Name: %s | Study Program: %s", nim, name, study_program);
    }
}