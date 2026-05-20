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