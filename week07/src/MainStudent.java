import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SearchStudents data = new SearchStudents();
        int amountStudent = 5;

        System.out.println("-------------------------------------");
        System.out.println("Input student data accordingly from smallest NIM");
        for (int i = 0; i < amountStudent; i++) {
            System.out.println("-------------------------------------");
            System.out.println("Student number-" + (i + 1));
            System.out.print("NIM\t:");
            int nim = Integer.parseInt(scanner.nextLine());

            System.out.print("Name\t:");
            String name = scanner.nextLine();

            System.out.print("Age\t:");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("GPA\t:");
            double gpa = Double.parseDouble(scanner.nextLine());

            Students std = new Students(nim, age, name, gpa);
            data.add(std);

        }

        System.out.println("--------------------------------------");
        System.out.println("Entire Student Data");
        System.out.println("--------------------------------------");
        data.display();
        System.out.println("______________________________________");
        System.out.println("______________________________________");
        System.out.print("Search student by NIM: ");
        int search = scanner.nextInt();

        System.out.println("Using Sequential Search");
        int position = data.findSeqSearch(search);

        data.showPosition(search, position);
        data.showData(search, position);

        System.out.println("========================================");
        System.out.print("Search student by NIM: ");
        System.out.println("Using binary search");
        int position1 = data.findBinarySearch(search, 0, amountStudent - 1);

        data.showPosition(search, position1);
        data.showData(search, position1);

        scanner.close();
    }
}
