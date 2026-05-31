public class QueueLinkedList {
    
    private QueueNode head;
    private QueueNode tail;
    private QueueNode headReport;
    private QueueNode tailReport;
    private int queueCount;

    public QueueLinkedList() {
        head = null;
        tail = null;
        headReport = null;
        tailReport = null;
        queueCount = 0;
    }

    public int getQueueCount() {
        return queueCount;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Buyer buyer, Order order) {
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

    public QueueNode dequeue(String orderCode) {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }
        QueueNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.getOrder() != null && temp.getOrder().getHead() != null && temp.getOrder().getHead().getOrderCode().equalsIgnoreCase(orderCode)) {
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

    public void searchBuyer(int key) {
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
            if (current.getBuyer().getQueueNumber() == key) {
                System.out.printf("%-15s %-20s %-15s%n", 
                    current.getBuyer().getQueueNumber(),
                    current.getBuyer().getName(),
                    current.getBuyer().getMobileNumber());
                found = true;
                break;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Data pembeli dengan nomor antrian '" + key + "' tidak ditemukan.");
        }
    }

    public void displayQueue() {
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
                current.getBuyer().getQueueNumber(),
                current.getBuyer().getName(),
                current.getBuyer().getMobileNumber());
            current = current.next;
        }
    }

    public void displayReport() {
        if (headReport == null) {
            System.out.println("Belum ada pesanan");
            return;
        }

        OrderNode sortHead = null;
        OrderNode sortTail = null;

        QueueNode currentQueue = headReport;
        while (currentQueue != null) {
            if (currentQueue.getOrder() != null) {
                OrderNode currentItem = currentQueue.getOrder().getHead();
                while (currentItem != null) {
                    OrderNode copy = new OrderNode(currentItem.getOrderCode(), currentItem.getOrderName(), currentItem.getPrice());
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
                if (current.getOrderName().compareTo(current.next.getOrderName()) > 0) {
                    String tempCode = current.getOrderCode();
                    String tempName = current.getOrderName();
                    double tempPrice = current.getPrice();

                    current.setOrderCode(current.next.getOrderCode());
                    current.setOrderName(current.next.getOrderName());
                    current.setPrice(current.next.getPrice());

                    current.next.setOrderCode(tempCode);
                    current.next.setOrderName(tempName);
                    current.next.setPrice(tempPrice);

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
                current.getOrderCode(),
                current.getOrderName(),
                (int) current.getPrice());
            
            totalPendapatanAll += current.getPrice();
            current = current.next;
        }
        System.out.println("===================================");
        System.out.println("TOTAL PENDAPATAN RESTORAN: " + totalPendapatanAll);
    }
}