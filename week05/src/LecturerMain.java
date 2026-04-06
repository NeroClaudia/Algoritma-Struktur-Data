public class LecturerMain {
    public static void main(String[] args) {

        LecturerData dataDosen = new LecturerData(10);

        dataDosen.add(new Lecturer("220001", "Budi Santoso", true, 42));
        dataDosen.add(new Lecturer("220002", "Siti Rahayu", false, 35));
        dataDosen.add(new Lecturer("220003", "Ahmad Fauzi", true, 55));
        dataDosen.add(new Lecturer("220004", "Dewi Kusuma", false, 28));
        dataDosen.add(new Lecturer("220005", "Rizky Pratama", true, 47));
        dataDosen.add(new Lecturer("220006", "Nurul Hidayah", false, 31));
        dataDosen.add(new Lecturer("220007", "Hendra Wijaya", true, 60));
        dataDosen.add(new Lecturer("220008", "Fitri Handayani", false, 39));
        dataDosen.add(new Lecturer("220009", "Dimas Ardiansyah", true, 52));
        dataDosen.add(new Lecturer("220010", "Lestari Wulandari", false, 44));

        System.out.println("Original Lecturer List:");
        dataDosen.print();
        System.out.println();

        dataDosen.bubbleSort();
        System.out.println("Lecturer list after sort (Using Bubble Sort, Descending):");
        dataDosen.print();
        System.out.println();

        dataDosen.selectionSort();
        System.out.println("Lecturer list after sort (Using Selection Sort, Ascending):");
        dataDosen.print();

    }
}
