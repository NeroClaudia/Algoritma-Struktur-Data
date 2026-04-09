import java.util.Scanner;

public class StudentDemo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah siswa: ");
        int n = Integer.parseInt(scanner.nextLine());

        TopStudent07 topStudents = new TopStudent07(n);

        for (int i = 0; i < n; i++) {
            System.out.println("===== DATA MAHASISWA KE-" + (i + 1));

            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Student Class: ");
            String studentClass = scanner.nextLine();

            System.out.print("GPA: ");
            double gpa = Double.parseDouble(scanner.nextLine());

            topStudents.add(new Student07(nim, name, studentClass, gpa));
        }

        System.out.println("Original student list:");
        topStudents.print();

        topStudents.insertionSort();
        System.out.println("Sorted student list (by GPA, descending) using Insertion Sort:");
        topStudents.print();

        scanner.close();
    }
}