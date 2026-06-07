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

    public void displayStudentWithIPKAbove(double threshold, int idxStart) {
        if (idxStart <= idxLast) {
            if (data[idxStart] != null) {
                displayStudentWithIPKAbove(threshold, 2 * idxStart + 1);
                if (data[idxStart].ipk > threshold) {
                    data[idxStart].print();
                }
                displayStudentWithIPKAbove(threshold, 2 * idxStart + 2);
            }
        }
    }

    public void add(Student07 data) {
        add(data, 0);
    }

    public void add(Student07 data, int idxCurrent) {
        if (this.data[idxCurrent] == null) {
            this.data[idxCurrent] = data;
            if (idxCurrent > idxLast) {
                idxLast = idxCurrent;
            }
        }else {
            if (data.ipk < this.data[idxCurrent].ipk) {
                add(data, 2 * idxCurrent + 1);
            }else if (data.ipk > this.data[idxCurrent].ipk) {
                add(data, 2 * idxCurrent + 2);
            }
        }
    }
}
