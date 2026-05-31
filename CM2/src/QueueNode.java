public class QueueNode {
    
    private Buyer buyer;
    private Order order;
    QueueNode next, prev;

    public QueueNode(Buyer buyer, Order order) {
        setBuyer(buyer);
        setOrder(order);
        this.next = null;
        this.prev = null;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Order getOrder() {
        return order;
    }

    public void setBuyer(Buyer buyer) {
        if (buyer != null) {
            this.buyer = buyer;
        }
    }

    public void setOrder(Order order) {
        if (order != null) {
            this.order = order;
        }
    }
}
