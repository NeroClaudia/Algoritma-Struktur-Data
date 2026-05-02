import java.util.Scanner;

public class StudentDemo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StudentAssignmentStack stack = new StudentAssignmentStack(5);

        int pilih;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Submit Assignment");
            System.out.println("2. Grade Assignment");
            System.out.println("3. View Top Assignment");
            System.out.println("4. View All Assignments");
            System.out.println("5. Show the first student who submitted");

            System.out.print("Choose a menu: ");
            pilih = Integer.parseInt(scanner.nextLine());

            switch (pilih) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    System.out.print("Class Name: ");
                    String className = scanner.nextLine();

                    Student07 std = new Student07(nim, name, className);
                    stack.push(std);

                    System.out.println(std.name + "'s assignment has been successfully submitted!!");
                    break;

                case 2:
                    Student07 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Grading assignment from " + dinilai.name);
                        System.out.print("Input grade (0-100): ");
                        int nilai = Integer.parseInt(scanner.nextLine());

                        dinilai.tugasDinilai(nilai);

                        String binary = stack.convertToBinary(nilai);
                        System.out.printf("Assignment grade in binary is %s\n", binary);
                    }
                    break;

                case 3:
                    Student07 top = stack.peek();
                    if (top != null) {
                        System.out.println("The last assignment comes from " + top.name);
                    }
                    break;

                case 4:
                    stack.print();
                    break;

                case 5:
                    Student07 bottom = stack.peekBottom();
                    if (bottom != null) {
                        System.out.println("The first submitted comes from " + bottom.name);
                    }
                    break;
            }
        } while (pilih >= 1 && pilih <= 5);

        scanner.close();
    }
}