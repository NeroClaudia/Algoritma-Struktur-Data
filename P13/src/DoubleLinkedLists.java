public class DoubleLinkedLists {

    Node head, tail;
    int size;

    DoubleLinkedLists() {
        head = null;
        tail = null;
        size = 0;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addFirst(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    void addLast(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    void insertAfter(String key, Student data) {
        Node newNode = new Node(data);
        Node temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.data.nim.equalsIgnoreCase(key)) {
                found = true;
                if (temp == tail) {
                    addLast(data);
                } else {
                    newNode.next = temp.next;
                    newNode.prev = temp;
                    temp.next.prev = newNode;
                    temp.next = newNode;
                    size++;
                }
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Insertion failed. Data (" + key + ") not found!!");
        }
    }

    void removeFirst() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!");
        }else if (head == tail) {
            head = tail = null;
            size--;
        }else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    void removeLast() {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!");
        } else if (head.next == null) {
            head = null;
            size--;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.prev.next = null;
            size--;
        }
    }

    void remove(int index) {
        if (isEmpty()) {
            System.out.println("Double linked list is currently empty!");
        } else if (index < 0) {
            System.out.println("Removal failed. Index (" + index + ") cannot be negative!");
        } else if (index >= size) {
            System.out.println("Removal failed. Index (" + index + ") exceeds list size (" + size + ")!");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            if (temp == tail) {
                removeLast();
            } else {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size--;
            }
        }
    }

    void print() {
        if (!isEmpty()) {
            Node temp = head;

            while (temp != null) {
                temp.data.print();
                temp = temp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Double linked list is currently empty!");
        }
    }
}
