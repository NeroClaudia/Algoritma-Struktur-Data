public class Transactions {
    
    Items item;
    double totalPrice;
    String code;
    int quantity;

    public Transactions(Items item, String code, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.code = code;
        this.totalPrice = item.price * quantity;
    }
}
