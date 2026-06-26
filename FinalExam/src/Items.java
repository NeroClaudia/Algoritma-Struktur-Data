public class Items {

    String code, name;
    double price;
    int stock;
    
    public Items(String code, String name, double price, int stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void printItems() {
        System.out.printf("Item Code: %s, Name: %s, Item Price: %.2f, Item Stock: %d%n", code, name, price, stock);
    }
}