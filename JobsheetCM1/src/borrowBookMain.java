import java.util.Scanner;

public class borrowBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student[] students = null;
        Book[] books = null;
        bookLending[] lendings = null;

        boolean running = true;
        int input;
        do {
            System.out.println("=== JTI LIBRARY BORROWING SYSTEM ===");
            System.out.println("1. Input Student Data");
            System.out.println("2. Input Books Data");
            System.out.println("3. Input Book Lending");
            System.out.println("4. Display Students");
            System.out.println("5. Display Books");
            System.out.println("6. Display Borrowing");
            System.out.println("7. Sort by Fines");
            System.out.println("8. Search by Student ID");
            System.out.println("0. Exit");

            System.out.print("Select Menu: ");
            input = Integer.parseInt(scanner.nextLine());

            switch (input) {

                case 1:
                    System.out.print("Input the amout of student: ");
                    int s = Integer.parseInt(scanner.nextLine());
                    students = new Student[s];

                    for (int i = 0; i < students.length; i++) {
                        System.out.println("Student no-" + (i + 1));
                        System.out.print("Input NIM: ");
                        String nim = scanner.nextLine();

                        System.out.print("Input Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Input Study Program: ");
                        String prodi = scanner.nextLine();

                        students[i] = new Student(nim, name, prodi);
                    }
                    break;

                case 2:
                    System.out.print("Input the amount of books: ");
                    int b = Integer.parseInt(scanner.nextLine());
                    books = new Book[b];

                    for (int i = 0; i < books.length; i++) {
                        System.out.println("Book no-" + (i + 1));
                        System.out.print("Input Book Code: ");
                        String code = scanner.nextLine();

                        System.out.print("Input Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Input Book Year: ");
                        int year = Integer.parseInt(scanner.nextLine());

                        books[i] = new Book(code, title, year);
                    }
                    break;

                case 3:
                    System.out.print("Input the Amount of Lending: ");
                    int l = Integer.parseInt(scanner.nextLine());
                    lendings = new bookLending[l];
                    for (int i = 0; i < lendings.length; i++) {
                        System.out.println("Lending " + (i + 1));
                        System.out.print("Student Name: ");
                        String stdName = scanner.nextLine();

                        System.out.print("Book Title: ");
                        String bookTitle = scanner.nextLine();

                        System.out.print("Loan Period (days): ");
                        int days = Integer.parseInt(scanner.nextLine());

                        Student foundStudent = null;
                        Book foundBook = null;

                        for (Student st : students)
                            if (st.name.equals(stdName))
                                foundStudent = st;
                        for (Book bk : books)
                            if (bk.title.equals(bookTitle))
                                foundBook = bk;

                        if (foundStudent != null && foundBook != null) {
                            lendings[i] = new bookLending(foundStudent, foundBook, days);
                        } else {
                            System.out.println("Student or book not found");
                            i--;
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < students.length; i++) {
                        students[i].printStudent();
                    }
                    break;
                case 5:
                    for (int i = 0; i < books.length; i++) {
                        books[i].printBook();
                    }
                    break;
                case 6:
                    for (int i = 0; i < lendings.length; i++) {
                        lendings[i].printLending();
                    }
                    break;
                case 7:
                    fineSorting sort = new fineSorting(lendings, lendings.length);
                    sort.selectionSort();
                    for (int i = 0; i < lendings.length; i++) {
                        lendings[i].printLending();
                    }
                    break;
                case 8:
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
