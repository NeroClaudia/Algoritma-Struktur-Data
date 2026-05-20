public class QueueNode {
    
    Buyer buyer;
    Order order;
    QueueNode next, prev;

    public QueueNode(Buyer buyer, Order order) {
        this.buyer = buyer;
        this.order = order;
        this.next = null;
        this.prev = null;
    }
}
