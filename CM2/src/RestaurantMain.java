import java.util.Scanner;
public class RestaurantMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueLinkedList queue = new QueueLinkedList();

        QueueNode served = null;
        
        int choice;
        do {
            System.out.println("===================================");
            System.out.println("ROYAL DELISH QUEUE SYSTEM");
            System.out.println("===================================");
            System.out.println("1. Add Queue");
            System.out.println("2. Print Queue");
            System.out.println("3. Remove Queue and Messages");
            System.out.println("4. Order Report");
            System.out.println("0. Exit");

            System.out.print("Select Menu: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e) {
                System.out.println("Inpur tidak valid. Masukkan angka");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    System.out.print("Buyer Name: ");
                    String pembeli = scanner.nextLine();

                    if (pembeli.isEmpty()) {
                        System.out.println("Nama tidak boleh kosong");
                        break;
                    }

                    System.out.print("No HP: ");
                    String noHp = scanner.nextLine();

                    if (noHp.isEmpty()) {
                        System.out.println("No HP tidak boleh kosong");
                        break;
                    }

                    Buyer buyer = new Buyer(pembeli, noHp);
                    Order order = new Order();

                    queue.enqueue(buyer, order);
                    buyer.setQueueNumber(queue.getQueueCount());

                    System.out.println("Antrian berhasil ditambahkan dengan nomor: " + buyer.getQueueNumber());
                    break;

                case 2:
                    queue.displayQueue();
                    break;

                case 3:
                    queue.displayQueue();

                    if (queue.isEmpty()) {
                        System.out.println("Tidak ada antrian untuk dihapus");
                        break;
                    }

                    System.out.print("Masukkan index yang ingin dihapus: ");
                    String targetCode = scanner.nextLine();

                    served = queue.dequeue(targetCode);
                    
                    if (served != null) {
                        System.out.print("Order Code: ");
                        String orderCode = scanner.nextLine();

                        System.out.print("Order Name: ");
                        String orderName = scanner.nextLine();

                        System.out.print("Price: ");
                        double price;
                        try {
                            price = Double.parseDouble(scanner.nextLine());
                        }catch (NumberFormatException e) {
                            System.out.println("Input harga tidak valid. Masukkan angka");
                            break;
                        }

                        served.getOrder().addItem(orderCode, orderName, price);
                        System.out.println(served.getBuyer().getName() + " telah memesan " + orderName);
                    }
                    break;

                case 4:
                    if (served == null) {
                        System.out.println("Belum ada pesanan diproses");
                        break;
                    }
                    
                    double totalBelanja = served.getOrder().calculateTotal();
                    System.out.println("Total price for all orders: " + totalBelanja);
                    queue.displayReport();
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
