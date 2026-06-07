public class BinaryTreeArrayMain07 {
    public static void main(String[] args) {
        BinaryTreeArray07 bta = new BinaryTreeArray07();
        Student07 m1 = new Student07("244107020138", "Devin", "TI-1I", 3.57);
        Student07 m2 = new Student07("244107020023", "Dewi", "TI-1I", 3.85);
        Student07 m3 = new Student07("244107020225", "Wahyu", "TI-1I", 3.21);
        Student07 m4 = new Student07("244107020076", "Angelina", "TI-1I", 3.54);
        Student07 m5 = new Student07("244107020223", "Andhika", "TI-1I", 3.72);
        Student07 m6 = new Student07("244107020226", "Bima", "TI-1I", 3.37);
        Student07 m7 = new Student07("244107020181", "Eiyu", "TI-1I", 3.46);
        Student07[] data = {m1, m2, m3, m4, m5, m6, m7};
        bta.populateData(data, data.length-1);
        System.out.println("In-order traversal:");
        bta.traverseInOrder(0);
    }
}
