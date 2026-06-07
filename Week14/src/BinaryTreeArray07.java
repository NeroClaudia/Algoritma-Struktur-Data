public class BinaryTreeArray07 {
    Student07[] data;
    int idxLast;

    public BinaryTreeArray07() {
        data = new Student07[10];
        idxLast = -1;
    }

    public void populateData(Student07[] data, int idxLast) {
        this.data = data;
        this.idxLast = idxLast;
    }

    public void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                data[idxStart].print();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
}
