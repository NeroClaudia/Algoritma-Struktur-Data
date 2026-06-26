import java.util.Scanner;

public class CashierMain {
    public static void main(String[] args) {
        CashierDoubleLinkedList list = new CashierDoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
        int transCounter = 1;

        list.addItems(new Items("B01", "Buku Tulis", 6000, 50));
        list.addItems(new Items("B02", "Pensil 2B", 4000, 30));
        list.addItems(new Items("B03", "Penghapus", 3000, 20));
        list.addItems(new Items("B04", "Spidol Hitam", 8000, 15));
        list.addItems(new Items("B05", "Kertas HVS A4 Box", 550000, 5));

        int menu;
        do {
            System.out.println("\n=======================================");
            System.out.println("      SISTEM KASIR DOUBLE LINKED LIST   ");
            System.out.println("=======================================");
            System.out.println("1. Tampilkan Daftar Barang");
            System.out.println("2. Input Transaksi Pembelian Baru");
            System.out.println("3. Tampilkan Riwayat Transaksi & Pendapatan");
            System.out.println("4. Urutkan Transaksi Berdasarkan Nama (A-Z)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    list.printAllItems();
                    break;

                case 2:
                    System.out.println("\n--- INPUT TRANSAKSI BARU ---");
                    System.out.print("Masukkan Kode Barang : ");
                    String itemCode = scanner.next();

                    NodeItems itemNode = list.searchItemByCode(itemCode);
                    if (itemNode == null) {
                        System.out.println("Gagal: Kode barang tidak ditemukan!");
                        break;
                    }

                    System.out.print("Masukkan Jumlah (Qty): ");
                    int qty = scanner.nextInt();

                    if (list.checkStock(itemCode, qty)) {
                        System.out.print("Apakah pembeli seorang Member? (y/n): ");
                        String isMemberStr = scanner.next();
                        boolean isMember = isMemberStr.equalsIgnoreCase("y");

                        double totalPayment = itemNode.data.price * qty;
                        double diskonMember = 0;
                        double diskonNominal = 0;

                        if (isMember) {
                            diskonMember = totalPayment * 0.02;
                            totalPayment -= diskonMember;
                        }

                        if (totalPayment > 500000) {
                            diskonNominal = totalPayment * 0.05;
                            totalPayment -= diskonNominal;
                        }
                        String transCode = "TR" + String.format("%03d", transCounter);

                        Transactions newTrans = new Transactions(itemNode.data, transCode, qty);
                        newTrans.totalPrice = totalPayment;

                        itemNode.data.stock -= qty;
                        list.addTransaction(newTrans);
                        transCounter++;

                        System.out.println("\n================ NOTA ================");
                        if (diskonMember > 0) {
                            System.out.printf("Diskon Member (2%%)       : -%.2f%n", diskonMember);
                        }
                        if (diskonNominal > 0) {
                            System.out.printf("Diskon Belanja >500rb (5%%): -%.2f%n", diskonNominal);
                        }
                        System.out.println("================================================");
                        System.out.printf("Kode Transaksi : %s%n", newTrans.code);
                        System.out.printf("Nama Barang    : %s%n", newTrans.item.name);
                        System.out.printf("Harga Satuan   : %.2f%n", newTrans.item.price);
                        System.out.printf("Quantity       : %d%n", newTrans.quantity);
                        System.out.printf("Total Bayar    : %.2f%n", newTrans.totalPrice);
                    }
                    break;

                case 3:
                    list.printAllTransactions();
                    break;

                case 4:
                    list.sortTransactionsByName();
                    list.printAllTransactions();
                    break;

                case 0:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Menu tidak valid! Silakan masukkan angka 1-5.");
            }
        } while (menu != 0);

        scanner.close();
    }
}