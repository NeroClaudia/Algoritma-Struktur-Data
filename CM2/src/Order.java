public class Order {

    OrderNode head, tail;
    
    Order() {
        head = null;
        tail = null;
    }

    void addItem(String orderCode, String orderName, double price) {
        OrderNode newNode = new OrderNode(orderCode, orderName, price);

        if (head == null) {
            head = tail = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    double calculateTotal() {
        double total = 0;
        OrderNode current = head;

        while (current != null) {
            total += current.price;
            current = current.next;
        }
        return total;
    }
    
    void removeItem(String orderName) {
        if (head == null) {
            System.out.println("Pesanan Kosong");
            return;
        }
        OrderNode current = head;

        while (current != null) {
            if (current.orderName.equalsIgnoreCase(orderName)) {
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                }else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Item '" + current.orderName + "' berhasil dihapus dari daftar pesanan.");
                return;
            }
            current = current.next;
        }
        System.out.println("Item " + orderName + " tidak ditemukan");
    }
    
    void displayItems() {
        OrderNode current = head;
        while (current != null) {
            System.out.printf("%-15s %-20s %-10d%n",
                current.orderCode,
                current.orderName,
                (int) current.price);
            current = current.next;
        }
    }
}