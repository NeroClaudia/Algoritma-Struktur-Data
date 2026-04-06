public class StudentDemo07 {
    public static void main(String[] args) {

        TopStudent07 topStudents = new TopStudent07(5);

        topStudents.add(new Student07("2201", "Alice", "A", 3.9));
        topStudents.add(new Student07("2202", "Bob", "B", 3.7));
        topStudents.add(new Student07("2203", "Charlie", "C", 3.8));
        topStudents.add(new Student07("2204", "David", "D", 3.6));
        topStudents.add(new Student07("2205", "Eve", "E", 4.0));

        System.out.println("Original student list:");
        topStudents.print();

        topStudents.insertionSort();
        System.out.println("Sorted student list (by GPA, ascending) using Insertion Sort:");
        topStudents.print();
    }
}