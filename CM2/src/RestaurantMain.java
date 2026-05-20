import java.util.Scanner;
public class RestaurantMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueLinkedList queue = new QueueLinkedList();

        int choice;
        do {
            System.out.println("================================");
            System.out.println("ROYAL DELISH QUEUE SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Queue");
            System.out.println("2. Print Queue");
            System.out.println("3. Remove Queue and Messages");
            System.out.println("4. Order Report");
            System.out.println("5. Remove Item");
            System.out.println("6. Search Buyer by Queue Number");
            System.out.println("0. Exit");

            System.out.print("Select Menu: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Buyer Name: ");
                    String pembeli = scanner.nextLine();

                    System.out.print("No HP: ");
                    String noHp = scanner.nextLine();

                    Buyer buyer = new Buyer(pembeli, noHp);
                    Order order = new Order();

                    queue.enqueue(buyer, order);
                    buyer.queueNumber = queue.queueCount;

                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + buyer.queueNumber);
                    break;

                case 2:
                    queue.displayQueue();
                    break;

                case 3:
                    QueueNode served = queue.dequeue();
                    if (served != null) {
                        System.out.print("Order Code: ");
                        String orderCode = scanner.nextLine();

                        System.out.print("Order Name: ");
                        String orderName = scanner.nextLine();

                        System.out.print("Price: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        served.order.addItem(orderCode, orderName, price);
                        System.out.println(served.buyer.name + " telah memesan " + orderName);
                    }
                    break;

                case 4:
                    queue.displayReport();
                    break;

                case 5:
                    System.out.print("Masukkan nama pesanan yang ingin dihapus: ");
                    String batal = scanner.nextLine();
                    
                    served.order.removeItem(batal);
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid input");
                    
            }
        }while (choice != 0);
        
        scanner.close();
    }
}
