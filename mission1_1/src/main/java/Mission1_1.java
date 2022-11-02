import java.util.Scanner;

public class Mission1_1 {
    public static void main(String[] args) {
        MiddleNumber middleNumber = new MiddleNumber();
        middleNumber.printMiddleNumber();

        /*
        Game369 game369 = new Game369();
        game369.run();
        */

        /*
        Rectangle rectangle = new Rectangle();
        rectangle.run();
        */

        /*
        Rectangle2 rectangle2 = new Rectangle2();
        rectangle2.run();
        */

        /*
        Calculate calculate = new Calculate();
        calculate.run();
        */
    }

    public static class MiddleNumber {
        public void printMiddleNumber() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("정수 3개 입력>> ");

            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();
            int number3 = scanner.nextInt();

            scanner.close();
            System.out.println(get(number1, number2, number3));
        }

        public int get(int number1, int number2, int number3) {
            if (number1 >= number2) {
                if (number2 >= number3) {
                    return number2;
                }

                if (number1 <= number3){
                    return number1;
                }

                return number3;
            }

            if (number1 > number3) {
                return number1;
            }

            if (number2 > number3) {
                return number3;
            }

            return number2;
        }
    }

    public static class Game369 {
        private final Scanner scanner = new Scanner(System.in);

        public void run() {
            while(true) {
                String inputNumber = getInputNumber();

                if (inputNumber.equals("Quit")){
                    System.out.println("게임 종료");
                    scanner.close();
                    return;
                }

                printClap(inputNumber);
            }
        }

        private void printClap(String inputNumber) {
            String result = "";

            for (int i = 0; i < inputNumber.length(); i++) {
                int number = inputNumber.charAt(i) - 48;

                if (number % 3 == 0) {
                    if (i == 1 && result.length() == 3) {
                        result = "박수짝짝";
                        break;
                    }

                    result = "박수짝";
                }
            }

            System.out.printf("%s \n\n", result);
        }

        private String getInputNumber() {
            System.out.print("1~99 사이의 정수를 입력하시오>> ");
            String number = scanner.next();

            return number;
        }
    }

    public static class Rectangle {
        private final Scanner scanner = new Scanner(System.in);
        private final int x1 = 100;
        private final int y1 = 100;
        private final int x2 = 200;
        private final int y2 = 200;

        public void run() {
            while(true) {
                System.out.print("점 (x, y)의 좌표를 입력하시오>> ");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                if (isInRectangle(x, y)) {
                    System.out.printf("(%d, %d)는 안에 있습니다.\n\n", x, y);
                    continue;
                }

                System.out.printf("(%d, %d)는 밖에 있습니다.\n\n", x, y);
            }
        }

        private boolean isInRectangle(int x, int y) {
            if ((x >= x1 && x <= x2) &&
                    (y >= y1 && y <= y2)) {
                return true;
            }

            return false;
        }
    }

    public static class Rectangle2 {
        private final Scanner scanner = new Scanner(System.in);
        private final int x1 = 100;
        private final int y1 = 100;
        private final int x2 = 200;
        private final int y2 = 200;

        public void run() {
            while(true) {
                System.out.print("점 (x1, y1) (x2, y2)의 좌표를 입력하시오>> ");

                int inputX1 = scanner.nextInt();
                int inputY1 = scanner.nextInt();
                int inputX2 = scanner.nextInt();
                int inputY2 = scanner.nextInt();

                if (isInRectangle(inputX1, inputY1, inputX2, inputY2)) {
                    System.out.printf("충돌 하였습니다. \n\n");
                    continue;
                }

                System.out.printf("충돌하지 않습니다. \n\n");
            }
        }

        private boolean isInRectangle(int inputX1, int inputY1, int inputX2, int inputY2) {
            if ((inputX1 >= x1 && inputX2 <= x2) &&
                    (inputY1 >= y1 && inputY2 <= y2)) {
                return true;
            }

            return false;
        }
    }

    public static class Calculate {
        private final Scanner scanner = new Scanner(System.in);

        public void run() {
            System.out.print("연산>> ");

            float number1 = Float.valueOf(scanner.next());
            String operatorSymbol = scanner.next();
            float number2 = Float.valueOf(scanner.next());

            System.out.printf("%.1f %s %.1f의 계산 결과는 %.1f\n", number1, operatorSymbol, number2,
                    calculate(number1, operatorSymbol, number2));
        }

        private float calculate(float number1, String operatorSymbol, float number2) {
            if (operatorSymbol.equals("+")) {
                return number1 + number2;
            }

            if (operatorSymbol.equals("-")) {
                return number1 - number2;
            }

            if (operatorSymbol.equals("*")) {
                return number1 * number2;
            }

            return number1 / number2;
        }

        private float calculate2(float number1, String operatorSymbol, float number2) {
            switch (operatorSymbol) {
                case "+" :
                    return number1 + number2;
                case "-" :
                    return number1 - number2;
                case "*" :
                    return number1 * number2;
                default :
                    return number1 / number2;
            }
        }
    }
}
