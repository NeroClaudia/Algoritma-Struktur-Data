package week5;

import java.util.Scanner;

public class powerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input element number: ");
        int elemen = scanner.nextInt();

        power[] png = new power[elemen];

        for (int i = 0; i < elemen; i++) {
            System.out.print("Input base number for " + (i + 1) + "th element: ");
            int basis = scanner.nextInt();

            System.out.print("Input exponent number for " + (i + 1) + "th element: ");
            int exp = scanner.nextInt();

            png[i] = new power(basis, exp);
        }

        System.out.println("POWER RESULT USING BRUTEFORCE:");
        for (power p : png) {
            System.out.println(p.baseNumber + "^" + p.exponent + ": " + p.powerBF(p.baseNumber, p.exponent));
        }
        System.out.println("POWER RESULT USING DIVIDE AND CONQUER:");
        for (power p : png) {
            System.out.println(p.baseNumber + "^" + p.exponent + ": " + p.powerDC(p.baseNumber, p.exponent));
        }
        scanner.close();
    }
}
