import java.util.Scanner;
public class accessories07 {
    public String name;
    public String category;
    public int price;
    public int sold;
    public int stock;

    public accessories07(String name, String category, int price, int sold, int stock) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.sold = sold;
        this.stock = stock;
    }

    public void display() {
        System.out.println("Name: " + this.name);
        System.out.println("Category: " + this.category);
        System.out.println("Price: " + this.price);   
        System.out.println("Sold: " + this.sold);
        System.out.println("Stock: " + this.stock);
    }

    public void inputDataAccessories(Scanner scanner) {
        System.out.print("Nama Accessories: ");
        this.name = scanner.nextLine();

        System.out.print("Category: ");
        this.category = scanner.nextLine();

        System.out.print("Price: ");
        this.price = Integer.parseInt(scanner.nextLine());

        System.out.print("Sold: ");                              
        this.sold = Integer.parseInt(scanner.nextLine());        
        System.out.print("Stock: ");
        this.stock = Integer.parseInt(scanner.nextLine());
    }

    public int calculateTotalSales(accessories07[] ArrayOfaccessories) {
        int totalSales = 0;
        for (accessories07 acc : ArrayOfaccessories) {
            totalSales += acc.price * acc.sold;
        }
        System.out.println("\n===== TOTAL SALES =====");
        System.out.println("Total Sales: " + totalSales);
        return totalSales;
    }

    public void checkStock(accessories07[] ArrayOfaccessories) {
        System.out.println("\n===== STOCK CHECK =====");
        for (accessories07 acc : ArrayOfaccessories) {
            if (acc.stock > 5) {
                System.out.println(acc.name + ": Many Stock");      
            } else {
                System.out.println(acc.name + ": Limited Stock");   
            }
        }
    }

    public void searchCheapestAccessories(accessories07[] ArrayOfaccessories) {
        accessories07 termurah = ArrayOfaccessories[0];
        for (accessories07 acc : ArrayOfaccessories) {
            if (acc.price < termurah.price) {
                termurah = acc;
            }
        }

        System.out.println("\n===== CHEAPEST ACCESSORY =====");
        termurah.display();
    }
}