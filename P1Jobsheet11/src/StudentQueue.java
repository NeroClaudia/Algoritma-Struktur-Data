public class StudentQueue {

    Student[] data;
    int front,rear, size, max;

    public StudentQueue(int n) {
        max = n;
        data = new Student[max];
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == max) {
            return true;
        }else {
            return false;
        }
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Front data: ");
            data[front].print();
        }else {
            System.out.println("Queue is empty!");
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        int i = front;
        while (i != rear) {
            data[i].print();
            i = (i + 1) % max;
        }
        data[i].print();
        System.out.println("Number of element: " + size);
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("All data has been successfully removed!");
        }else {
            System.out.println("Queue is already empty!");
        }
    }

    public void enqueue(Student dt) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = dt;
        size++;
        System.out.printf("%s is successfully added at index %d\n", dt.name, rear);
    }

    Student dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Student dt = data[front];
        front = (front + 1) % max;
        size--;
        return dt;
    }
}