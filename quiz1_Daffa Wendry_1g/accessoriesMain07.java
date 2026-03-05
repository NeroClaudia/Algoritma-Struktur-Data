import java.util.Scanner;
public class accessoriesMain07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        accessories07[] ArrayOfaccessories = new accessories07[5];

        for (int i = 0; i < ArrayOfaccessories.length; i++) {
            System.out.println("Masukkan data ke-" + (i + 1));
            ArrayOfaccessories[i] = new accessories07(null, null, 0, 0, 0);
            ArrayOfaccessories[i].inputDataAccessories(scanner);
        }

        accessories07 dataAksesoris = new accessories07(null, null, 0, 0, 0);
        dataAksesoris.calculateTotalSales(ArrayOfaccessories);
        dataAksesoris.checkStock(ArrayOfaccessories);
        dataAksesoris.searchCheapestAccessories(ArrayOfaccessories);
        scanner.close();
    }
}