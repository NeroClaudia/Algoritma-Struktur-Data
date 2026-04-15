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

    public void bubbleSort() {
        for (int i = 0; i < size; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (lendings[j].fine > lendings[j + 1].fine) {
                    bookLending temp = lendings[j];
                    lendings[j] = lendings[j + 1];
                    lendings[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public void inseertionSort() {
        for (int i = 1; i < size; i++) {
            bookLending key = lendings[i];
            int j = i - 1;

            while (j >= 0 && lendings[j].fine < key.fine) {
                lendings[j + 1] = lendings[j];
                j--;
            }
            lendings[j + 1] = key;
        }
    }
}
