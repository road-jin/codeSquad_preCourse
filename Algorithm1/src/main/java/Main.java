import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        /*
        BaekJoon1000 baekJoon1000 = new BaekJoon1000();
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon1000.sum(number1, number2));
        */

        /*
        BaekJoon1008 baekJoon1008 = new BaekJoon1008();
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon1008.divide(number1, number2));
        */

        /*
        BaekJoon2920 baekJoon2920 = new BaekJoon2920();
        String pitchNameArr = "";

        for (int i = 0; i < 8; i++) {
            pitchNameArr += scanner.nextInt();
        }

        scanner.close();
        System.out.println(baekJoon2920.getPlayStyle(pitchNameArr));
        */

        /*
        BaekJoon8958 baekJoon8958 = new BaekJoon8958();
        int length = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            String quizAnswer = scanner.next();
            stringBuilder.append(baekJoon8958.getScore(quizAnswer) + "\n");
        }

        scanner.close();
        System.out.println(stringBuilder);
        */

        BaekJoon11654 baekJoon11654 = new BaekJoon11654();
        char alphabet = scanner.next().charAt(0);
        System.out.println(baekJoon11654.getAsciiCode(alphabet));
    }
}