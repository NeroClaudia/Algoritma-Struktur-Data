public class Student {
    
    String nim, name, studyProgram, className;

    public Student(String nim, String name, String studyProgram, String className) {
        this.nim = nim;
        this.name = name;
        this.studyProgram = studyProgram;
        this.className = className;
    }

    public void print() {
        System.out.printf("%s - %s - %s -%s\n", nim, name, studyProgram, className);
    }
}
