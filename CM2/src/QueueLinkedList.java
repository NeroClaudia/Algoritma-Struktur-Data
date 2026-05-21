public class QueueLinkedList {
    
    QueueNode head, tail;
    QueueNode headReport, tailReport;
    int queueCount;

    QueueLinkedList() {
        head = null;
        tail = null;
        headReport = null;
        tailReport = null;
        queueCount = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void enqueue(Buyer buyer, Order order) {
        QueueNode newNode = new QueueNode(buyer, order);
        if (isEmpty()) {
            head = tail = newNode;
        }else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        queueCount++;
    }

    QueueNode dequeue(String orderCode) {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        QueueNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.order != null && temp.order.head != null && temp.order.head.orderCode.equalsIgnoreCase(orderCode)) {
                found = true;
                break;
            }
            temp = temp.next;
        }

        if (!found || temp == null) {
            System.out.println("Pelanggan dengan Kode Pesanan '" + orderCode + "' tidak ditemukan di antrian aktif.");
            return null;
        }

        if (temp == head && temp == tail) {
            head = null;
            tail = null;
        }else if (temp == head) {
            head = head.next;
            head.prev = null;
        }else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        temp.next = null;
        temp.prev = null;

        if (headReport == null) {
            headReport = tailReport = temp;
        }else {
            temp.prev = tailReport;
            tailReport.next = temp;
            tailReport = temp;
        }
        return temp;
    }

    void searchBuyer(int key) {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        QueueNode current = head;
        boolean found = false;

        System.out.println("=====================================");
        System.out.println("HASIL PENCARIAN PEMBELI");
        System.out.println("=====================================");
        System.out.printf("%-15s %-20s %-15s%n", "No Antrian", "Nama", "No HP");

        while (current != null) {
            if (current.buyer.queueNumber == key) {
                System.out.printf("%-15s %-20s %-15s%n", 
                    current.buyer.queueNumber,
                    current.buyer.name,
                    current.buyer.mobileNumber);
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Data pembeli dengan nomor antrian '" + key + "' tidak ditemukan.");
        }
    }

    void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        System.out.println("===========================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("===========================");
        System.out.printf("%-15s %-20s %-15s%n", "No Antrian", "Nama", "No HP");

        QueueNode current = head;
        while (current != null) {
            System.out.printf("%-15d %-20s %-15s%n",
                current.buyer.queueNumber,
                current.buyer.name,
                current.buyer.mobileNumber);
            current = current.next;
        }
    }

    void displayReport() {
        if (headReport == null) {
            System.out.println("Belum ada pesanan");
            return;
        }

        OrderNode sortHead = null;
        OrderNode sortTail = null;

        QueueNode currentQueue = headReport;
        while (currentQueue != null) {
            if (currentQueue.order != null) {
                OrderNode currentItem = currentQueue.order.head;
                while (currentItem != null) {
                    OrderNode copy = new OrderNode(currentItem.orderCode, currentItem.orderName, currentItem.price);
                    if (sortHead == null) {
                        sortHead = sortTail = copy;
                    } else {
                        copy.prev = sortTail;
                        sortTail.next = copy;
                        sortTail = copy;
                    }
                    currentItem = currentItem.next;
                }
            }
            currentQueue = currentQueue.next;
        }

        boolean swapped;
        do {
            swapped = false;
            OrderNode current = sortHead;
            while (current != null && current.next != null) {
                if (current.orderName.compareTo(current.next.orderName) > 0) {
                    String tempCode = current.orderCode;
                    String tempName = current.orderName;
                    double tempPrice = current.price;

                    current.orderCode = current.next.orderCode;
                    current.orderName = current.next.orderName;
                    current.price     = current.next.price;

                    current.next.orderCode = tempCode;
                    current.next.orderName = tempName;
                    current.next.price     = tempPrice;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("===================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("===================================");
        System.out.printf("%-15s %-20s %-10s%n", "Kode Pesanan", "Nama Pesanan", "Harga");

        double totalPendapatanAll = 0;
        OrderNode current = sortHead;
        while (current != null) {
            System.out.printf("%-15s %-20s %-10d%n",
                current.orderCode,
                current.orderName,
                (int) current.price);
            
            totalPendapatanAll += current.price;
            current = current.next;
        }
        System.out.println("===================================");
        System.out.println("TOTAL PENDAPATAN RESTORAN: " + totalPendapatanAll);
    }
}