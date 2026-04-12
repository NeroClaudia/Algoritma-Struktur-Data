public class fineSorting {

    bookLending[] lendings;
    int size;

    public fineSorting(bookLending[] lendings, int size) {
        this.lendings = lendings;
        this.size = size;
    }

    public void selectionSort() {
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (lendings[j].fine > lendings[minIndex].fine) {
                    minIndex = j;
                }
            }
            bookLending temp = lendings[minIndex];
            lendings[minIndex] = lendings[i];
            lendings[i] = temp;
        }
    }
}
