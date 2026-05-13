import java.util.Scanner;
public class MahasiswaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        MahasiswaQueue queue = new MahasiswaQueue();
        int choice;

        do {
            System.out.println("\n===== STUDENT SERVICE QUEUE =====");
            System.out.println("1. Join Queue");
            System.out.println("2. Call Next Student");
            System.out.println("3. Show Front Student");
            System.out.println("4. Show Rear Student");
            System.out.println("5. Show All Queue");
            System.out.println("6. Total Students in Queue");
            System.out.println("7. Check Queue Status");
            System.out.println("8. Clear Queue");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = Integer.parseInt(scanner.nextLine()); 

            switch (choice) {
                case 1:
                    System.out.println("===== REGISTER STUDENT =====");
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Purpose: ");
                    String purpose = scanner.nextLine();

                    Mahasiswa mhs = new Mahasiswa(nim, name, purpose);
                    queue.enqueue(mhs);
                    System.out.println(name + " has joined the queue");
                    break;

                case 2:
                    queue.dequeue();
                    break;

                case 3:
                    queue.getFront();
                    break;

                case 4:
                    queue.getRear();
                    break;

                case 5:
                    queue.print();
                    break;

                case 6:
                    queue.getSize();
                    break;
                
                case 7:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    }else if (queue.isFull()) {
                        System.out.println("Queue is Full");
                    }else {
                        System.out.println("Queue is Active. (" + queue.size + "/" + queue.maxSize + ")");
                    }
                    break;

                case 8:
                    queue.clear();
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }while (choice != 0);
        
        scanner.close();
    }
}
