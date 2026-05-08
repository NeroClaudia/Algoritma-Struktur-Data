public class SLLMain {
    public static void main(String[] args) {

        SingleLinkedList00 sll = new SingleLinkedList00();

        Student00 std1 = new Student00("001", "Student 1", "TI-1I", 3.89);
        Student00 std2 = new Student00("002", "Student 2", "TI-1I", 3.45);
        Student00 std3 = new Student00("003", "Student 3", "TI-1I", 3.20);
        Student00 std4 = new Student00("004", "Student 4", "TI-1I", 3.00);

        sll.print();
        sll.addFirst(std4);
        sll.print();
        sll.addLast(std1);
        sll.print();
        sll.insertAfter(std3, "Student 4");
        sll.insertAt(2, std2);
        sll.print();

        System.out.println("Data at index 1 is:");
        Student00 data = sll.getData(1);
        data.print();

        int idx = sll.indexOf("Student 1");
        System.out.println("Student 1 is located at index: " + idx);

        sll.removeFirst();
        sll.removeLast();
        sll.print();
        sll.removeAt(0);
        sll.print();
    }
}
