public class Order {

    private OrderNode head;
    private OrderNode tail;

    public Order() {
        head = null;
        tail = null;
    }

    public OrderNode getHead() {
        return head;
    }

    public void addItem(String orderCode, String orderName, double price) {
        OrderNode newNode = new OrderNode(orderCode, orderName, price);

        if (head == null) {
            head = tail = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public double calculateTotal() {
        double total = 0;
        OrderNode current = head;

        while (current != null) {
            total += current.price;
            current = current.next;
        }
        return total;
    }

    public void displayItems() {
        OrderNode current = head;

        while (current != null) {
            System.out.printf("$-15s %-20s %-10d%n",
                current.orderCode,
                current.orderName,
                (int) current.price);
            current = current.next;
        }
    }
}