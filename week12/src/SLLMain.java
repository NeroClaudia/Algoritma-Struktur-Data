import java.util.Scanner;

public class SLLMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SingleLinkedList00 sll = new SingleLinkedList00();
        int menu;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Add First Data at the beginning");
            System.out.println("2. Add Last Data at the end");
            System.out.println("3. Insert Data");
            System.out.println("4. Cetak Data");
            System.out.println("5. Remove First Data");
            System.out.println("0. Exit");

            System.out.print("Select Menu: ");
            menu = Integer.parseInt(scanner.nextLine());

            if (menu >= 1 && menu <= 3) {
                System.out.print("Add NIM: ");
                String nim = scanner.nextLine();

                System.out.print("Add Name: ");
                String name = scanner.nextLine();

                System.out.print("Add Class Name: ");
                String classN = scanner.nextLine();

                System.out.print("Add GPA: ");
                double ipk = Double.parseDouble(scanner.nextLine());

                Student00 siswa = new Student00(nim, name, classN, ipk);

                if (menu == 1) {
                    sll.addFirst(siswa);
                    System.out.println("Data successfully added at the beginning\n");
                } else if (menu == 2) {
                    sll.addLast(siswa);
                    System.out.println("Data successfully added at the end!\n");
                } else if (menu == 3) {
                    System.out.print("Enter the Student Name as a reference (insert after): ");
                    String keyName = scanner.nextLine();
                    sll.insertAfter(siswa, keyName);
                    System.out.println("Data was successfully inserted after " + keyName + "!\n");
                }
            } else if (menu == 4) {
                sll.print();
                System.out.println();
            } else if (menu == 5) {
                sll.removeFirst();
                System.out.println("The first data was successfully deleted!\n");
            } else if (menu == 0) {
                System.out.println("The program has finished running");
            } else {
                System.out.println("Invalid Input");
            }
        } while (menu != 0);

        scanner.close();
    }
}
