public class CashierDoubleLinkedList {
    
    NodeItems headItems, tailItems;
    NodeTransactions headTrans, tailTrans;
    int size;

    public CashierDoubleLinkedList() {
        headItems = null;
        tailItems = null;
        headTrans = null;
        tailTrans = null;
    }

    public boolean isEmptyItems() {
        return headItems == null;
    }

    public boolean isEmptyTrans() {
        return headTrans == null;
    }

    public void addItems(Items data) {
        NodeItems newNode = new NodeItems(data);
        if (isEmptyItems()) {
            headItems = tailItems = newNode;
        }else {
            newNode.prev = tailItems;
            tailItems.next = newNode;
            tailItems = newNode;
        }
        size++;
    }

    public void addTransaction(Transactions data) {
        NodeTransactions newNode = new NodeTransactions(data);
        if (isEmptyTrans()) {
            headTrans = tailTrans = newNode;
        }else {
            newNode.prev = tailTrans;
            tailTrans.next = newNode;
            tailTrans = newNode;                                                                                
        }
        size++;
    }

    public NodeItems searchItemByCode(String key) {
        NodeItems temp = headItems;

        while (temp != null) {
            if (temp.data.code.equalsIgnoreCase(key)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean checkStock(String code, int quantity) {
        NodeItems targetNode = searchItemByCode(code);

        if (targetNode != null) {
            if (targetNode.data.stock >= quantity && targetNode.data.stock > 0) {
                return true;
            } else {
                System.out.println("Gagal: Stok barang tidak mencukupi atau sudah habis!");
                return false; 
            }
        }
        return false;
    }

    public void printAllItems() {
        if (isEmptyItems()) {
            System.out.println("Daftar barang kosong");
            return;
        }
        System.out.println("===== DAFTAR BARANG =====");
        NodeItems temp = headItems;

        while (temp != null) {
            temp.data.printItems();
            temp = temp.next;
        }
    }

    public void printAllTransactions() {
        if (isEmptyTrans()) {
            System.out.println("Belum ada transaksi");
            return;
        }
        System.out.println("===== RIWAYAT TRANSAKSI =====");
        NodeTransactions temp = headTrans;
        double totalTransaksi = 0;

        while (temp != null) {
            System.out.printf("Kode: %s | Nama Barang: %s | Harga: %.2f | Jumlah: %d | Total Harga: %.2f%n", temp.transaction.code, temp.transaction.item.name, temp.transaction.item.price, temp.transaction.quantity, temp.transaction.totalPrice);
            totalTransaksi += temp.transaction.totalPrice;

            temp = temp.next;
        }
        System.out.printf("Total Pendapatan: %.2f%n", totalTransaksi);
    }

    public void sortTransactionsByName() {
        if (isEmptyTrans() || headTrans.next == null) {
            System.out.println("Transaksi masih kosong atau belum cukup untuk diurutkan");
            return;
        }

        boolean swapped;
        NodeTransactions current;

        do {
            swapped = false;
            current = headTrans;

            while (current.next != null) {
                String a = current.transaction.item.name;
                String b = current.next.transaction.item.name;

                if (a.compareToIgnoreCase(b) > 0) {
                    Transactions temp = current.transaction;
                    current.transaction = current.next.transaction;
                    current.next.transaction = temp;

                    swapped = true;
                }
                
                current = current.next;
            }
        } while (swapped); 
    }

}
