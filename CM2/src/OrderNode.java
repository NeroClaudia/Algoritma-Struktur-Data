public class OrderNode {
    
    String orderCode, orderName;
    double price;
    OrderNode next, prev;
    
    public OrderNode(String orderCode, String orderName, double price) {
        this.orderCode = orderCode;
        this.orderName = orderName;
        this.price = price;
        this.next = null;
        this.prev = null;
    }
}
