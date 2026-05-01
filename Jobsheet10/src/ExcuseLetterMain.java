import java.util.Scanner;

public class ExcuseLetterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the amount of Excuse Letter: ");
        int size = Integer.parseInt(scanner.nextLine());

        ExcuseLetterStack stack = new ExcuseLetterStack(size);

        int choose;
        do {
            System.out.println("\nMenu: ");
            System.out.println("1. Submit Excuse Letter");
            System.out.println("2. Process Excuse Letter");
            System.out.println("3. View Latest Excuse Letter");
            System.out.println("4. Search for Letter");

            System.out.print("Choose a menu: ");
            choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("NIM: ");
                    String id = scanner.nextLine();

                    System.out.print("Class Name: ");
                    String className = scanner.nextLine();

                    System.out.print("Type of Excuse (S/I): ");
                    char excuse = scanner.nextLine().charAt(0);

                    System.out.print("Duration (days): ");
                    int duration = Integer.parseInt(scanner.nextLine());

                    ExcuseLetter07 let = new ExcuseLetter07(id, name, className, excuse, duration);
                    stack.push(let);

                    System.out.println(let.name + "'s excuse letter has been successfully submitted!");
                    break;

                case 2:
                    ExcuseLetter07 process = stack.pop();
                    if (process != null) {
                        System.out.println("\nProcessing excuse letter from: " + process.name);
                        System.out.println("ID         : " + process.id);
                        System.out.println("Class      : " + process.className);
                        System.out.println("Type       : " + process.typeOfExcuse);
                        System.out.println("Duration   : " + process.duration + " day(s)");
                        System.out.println("Excuse letter has been processed successfully!");
                    }
                    break;

                case 3:
                    ExcuseLetter07 latest = stack.peek();
                    if (latest != null) {
                        System.out.println("\nLatest Excuse Letter:");
                        System.out.println("Name       : " + latest.name);
                        System.out.println("ID         : " + latest.id);
                        System.out.println("Class      : " + latest.className);
                        System.out.println("Type       : " + latest.typeOfExcuse);
                        System.out.println("Duration   : " + latest.duration + " day(s)");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();

                    ExcuseLetter07 found = stack.search(searchName);
                    if (found != null) {
                        System.out.println("\nExcuse Letter Found:");
                        System.out.println("Name       : " + found.name);
                        System.out.println("ID         : " + found.id);
                        System.out.println("Class      : " + found.className);
                        System.out.println("Type       : " + found.typeOfExcuse);
                        System.out.println("Duration   : " + found.duration + " day(s)");
                        System.out.println("Status     : " + (found.isProcessed ? "Already Processed" : "Waiting"));
                    } else {
                        System.out.println("Excuse letter for '" + searchName + "' not found!");
                    }
                    break;

                default:
                    System.out.println("Invalid menu choice!");
                    break;
            }
        } while (choose >= 1 && choose <= 4);

        scanner.close();
    }
}