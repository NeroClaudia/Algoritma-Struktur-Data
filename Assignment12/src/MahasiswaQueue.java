public class MahasiswaQueue {

    MahasiswaNode head;
    MahasiswaNode tail;
    int size = 0;
    int maxSize = 10;

    boolean isEmpty() {
        return head == null;
    }

    boolean isFull() {
        return size == maxSize;
    }

    void enqueue(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Queue is Full");
            return;
        }
        MahasiswaNode newNode = new MahasiswaNode(mhs, null);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Calling: ");
        head.data.print();
        head = head.next;
        
        if (head == null) {
            tail = null;
        }
        size--;

    }

    void getFront() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Student: ");
        head.data.print();
    }

    void getRear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Last Student: ");
        tail.data.print();
    }

    void getSize() {
        System.out.println("Total Student in Queue: " + size);
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("===== QUEUE LIST =====");
        MahasiswaNode tmp = head;
        int no = 1;

        while (tmp != null) {
            System.out.print(no + ". ");
            tmp.data.print();
            tmp = tmp.next;
            no++;
        }
    }

    void clear() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("Queue Cleared");
    }
}