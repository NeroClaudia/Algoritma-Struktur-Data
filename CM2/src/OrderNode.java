public class OrderNode {
    
    private String orderCode;
    private String orderName;
    private double price;
    OrderNode next, prev;
    
    public OrderNode(String orderCode, String orderName, double price) {
        setOrderCode(orderCode);
        setOrderName(orderName);
        setPrice(price);
        this.next = null;
        this.prev = null;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getOrderName() {
        return orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setOrderCode(String orderCode) {
        if (orderCode != null && !orderCode.isEmpty()) {
            this.orderCode = orderCode;
        }
    }
    
    public void setOrderName(String orderName) {
        if (orderName != null && !orderName.isEmpty()) this.orderName = orderName;
            this.orderName = orderName;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}
