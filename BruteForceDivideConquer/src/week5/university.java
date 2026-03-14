package week5;

public class university {

    public static int findMax(int[] arr, int left, int right) {
        int mid, maxKiri, maxKanan;
        if (left == right) {
            return arr[left];
        } else {
            mid = (left + right) / 2;
            maxKiri = findMax(arr, left, mid);
            maxKanan = findMax(arr, mid + 1, right);
        }
        if (maxKiri > maxKanan) {
            return maxKiri;
        } else {
            return maxKanan;
        }
    }

    public static int findMin(int[] arr, int left, int right) {
        int mid, minKiri, minKanan;
        if (left == right) {
            return arr[left];
        } else {
            mid = (left + right) / 2;
            minKiri = findMin(arr, left, mid);
            minKanan = findMin(arr, mid + 1, right);
        }
        if (minKiri < minKanan) {
            return minKiri;
        } else {
            return minKanan;
        }
    }

    public static double calculateAverage(int[] arr) {
        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total / arr.length;
    }
}