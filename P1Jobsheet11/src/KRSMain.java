import java.util.Scanner;

public class KRSMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        KRSQueue queue = new KRSQueue(10);

        int menu;
        do {
            queue.displayMenu();
            System.out.print("Choose menu: ");
            menu = Integer.parseInt(scanner.nextLine());

            switch (menu) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Study Program: ");
                    String studyProgram = scanner.nextLine();

                    System.out.print("Class: ");
                    String cls = scanner.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nim, name, studyProgram, cls);
                    queue.enqueue(mhs);
                    break;

                case 2:
                    if (queue.totalApproved >= 30) {
                        System.out.println("DPA has reached its maximum limit of 30 students!");
                    }else {
                        queue.dequeue();
                    }
                    break;

                case 3:
                    System.out.println("=== List of All Students");
                    queue.showAll();
                    break;

                case 4:
                    System.out.println("=== First Two Student in Queue ===");
                    queue.showFirstTwo();
                    break;

                case 5:
                    System.out.println("=== Last Student in Queue ===");
                    queue.showLast();
                    break;

                case 6:
                    queue.clear();
                    break;

                case 7:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    }else {
                        System.out.println("Queue is not Empty");
                    }
                    break;

                case 8:
                    if (queue.isFull()) {
                        System.out.println("Queue is Full");
                    }else {
                        System.out.println("Queue is Empty");
                    }
                    break;

                case 9:
                    System.out.println("=== List total Number of Students in the Queue ");
                    queue.printTotalAntrian();

                    break;

                case 10:
                    System.out.println("=== List Total Number of Approved KRS ===");
                    queue.printTotalApproved();
                    break;

                case 11:
                    System.out.println("=== List of Students Who Haven't Completed the KRS");
                    queue.printTotalBelumSelesai(30);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invald input");
            }

        }while (menu != 0);
        
        scanner.close();
    }
}