import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Input maximum number of data: ");
        int n = scanner.nextInt();

        Queue Q = new Queue(n);
        
        int choice = -1;
        do {
            System.out.println("Available Menu:");
            System.out.println("1. Enqueue:");
            System.out.println("2. Dequeue:");
            System.out.println("3. Print:");
            System.out.println("4. Peek:");
            System.out.println("5. Clear:");
            System.out.println("============================");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Input new data: ");
                    int newData = scanner.nextInt();
                    Q.enqueue(newData);
                    break;

                case 2:
                    int outData = Q.dequeue();
                    if (outData != 0) {
                        System.out.println("Removed data: " + outData);
                        break;
                    }

                case 3:
                    Q.print();
                    break;

                case 4:
                    Q.peek();
                    break;

                case 5:
                    Q.clear();
                    break;
            }
        } while (choice >= 1 && choice <= 5);
        scanner.close();
    }
}