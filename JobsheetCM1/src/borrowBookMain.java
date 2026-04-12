import java.util.Scanner;

public class borrowBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = {
                new Student("22001", "Andi", "Informatics Engineering"),
                new Student("22002", "Budi", "Informatics Engineering"),
                new Student("22003", "Citra", "Business Information System")
        };

        Book[] books = {
                new Book("B001", "Algorithm", 2020),
                new Book("B002", "Database", 2019),
                new Book("B003", "Programming", 2021),
                new Book("B004", "Physics", 2024)
        };

        bookLending[] lendings = {
                new bookLending(students[0], books[0], 7),
                new bookLending(students[1], books[1], 3),
                new bookLending(students[2], books[2], 10),
                new bookLending(students[2], books[3], 6),
                new bookLending(students[0], books[1], 4),
        };

        boolean running = true;
        int input;
        do {
            System.out.println("=== JTI LIBRARY BORROWING SYSTEM ===");
            System.out.println("1. Display Students");
            System.out.println("2. Display Books");
            System.out.println("3. Display Borrowing");
            System.out.println("4. Sort by Fines");
            System.out.println("5. Search by Student ID");
            System.out.println("0. Exit");

            System.out.print("Select: ");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {

                case 1:
                    for (int i = 0; i < students.length; i++) {
                        students[i].printStudent();
                    }
                    break;
                case 2:
                    for (int i = 0; i < books.length; i++) {
                        books[i].printBook();
                    }
                    break;
                case 3:
                    for (int i = 0; i < lendings.length; i++) {
                        lendings[i].printLending();
                    }
                    break;
                case 4:
                    fineSorting sort = new fineSorting(lendings, lendings.length);
                    sort.selectionSort();
                    for (int i = 0; i < lendings.length; i++) {
                        lendings[i].printLending();
                    }
                    break;
                case 5:
                    System.out.print("Enter NIM: ");
                    String nim = scanner.nextLine();

                    searchStudentById search = new searchStudentById(lendings);
                    search.findSequentialSearch(nim);

                    break;
                case 0:
                    running = false;
                    break;
            }
            if (running) {
                System.out.print("\nPress Enter to Continue...");
                scanner.nextLine();
            }
        } while (running);

        scanner.close();

    }
}
