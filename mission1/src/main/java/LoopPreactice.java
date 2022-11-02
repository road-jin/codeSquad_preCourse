import java.util.Scanner;

public class LoopPreactice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        BaekJoon2438 baekJoon2438 = new BaekJoon2438();
        int length = scanner.nextInt();

        scanner.close();
        backJoon2438.printStar(length);
        */

        BaekJoon11720 baekJoon11720 = new BaekJoon11720();
        int length = scanner.nextInt();
        String numbers = scanner.next();

        scanner.close();
        System.out.println(baekJoon11720.getSumNumber(length, numbers));
    }

    public static class BaekJoon2438 {
        public void printStar(int length) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    public static class BaekJoon11720 {
        public int getSumNumber(int length, String numbers) {
            int sum = 0;

            for (int i = 0; i < length; i++) {
                sum += numbers.charAt(i) - 48;
            }

            return sum;
        }
    }
}
