package week5;

public class universityMain {
    public static void main(String[] args) {
        String nama[] = { "Ahmad", "Budi", "Cindy", "Dian", "Eko", "Fajar", "Gina", "Hadi" };
        String nim[] = { "220101001", "220101002", "220101003", "220101004", "220101005", "220101006", "220101007", "220101008" };
        int uts[] = { 78, 85, 90, 76, 92, 88, 80, 82 };
        int uas[] = { 82, 88, 87, 79, 95, 85, 83, 84 };

        int maxValue = university.findMax(uts, 0, uts.length - 1);
        for (int i = 0; i < uts.length; i++) {
            if (uts[i] == maxValue) {
                System.out.println("===== HIGHEST MIDTERM SCORE =====");
                System.out.println("Nama: " + nama[i]);
                System.out.println("NIM: " + nim[i]);
                System.out.println("Nilai: " + maxValue);
                break;
            }
        }

        int lowestValue = university.findMin(uts, 0, uts.length - 1);
        for (int i = 0; i < uts.length; i++) {
            if (uts[i] == lowestValue) {
                System.out.println("===== LOWEST MIDTERM SCORE =====");
                System.out.println("Nama: " + nama[i]);
                System.out.println("NIM: " + nim[i]);
                System.out.println("Nilai: " + lowestValue);
                break;
            }
        }
        
        System.out.println("===== AVERAGE FINAL SCORE =====");
        System.out.println("Average: " + university.calculateAverage(uas));
    }
}
