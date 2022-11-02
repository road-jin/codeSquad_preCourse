import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintStar {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        /*
        BaekJoon2439 baekJoon2439 = new BaekJoon2439();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2439.printStar(length);
         */

        /*
        BaekJoon2440 baekJoon2440 = new BaekJoon2440();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2440.printStar(length);
        */

        /*
        BaekJoon2441 baekJoon2441 = new BaekJoon2441();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2441.printStar(length);
        */

        /*
        BaekJoon2442 baekJoon2442 = new BaekJoon2442();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2442.printStar(length);
        */

        /*
        BaekJoon2443 baekJoon2443 = new BaekJoon2443();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2443.printStar(length);
        */

        /*
        BaekJoon2444 baekJoon2444 = new BaekJoon2444();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2444.printStar(length);
        */

        /*
        BaekJoon2445 baekJoon2445 = new BaekJoon2445();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2445.printStar(length);
        */

        /*
        BaekJoon2446 baekJoon2446 = new BaekJoon2446();
        int length = scanner.nextInt();

        scanner.close();
        baekJoon2446.printStar(length);
        */

        BaekJoon2447 baekJoon2447 = new BaekJoon2447();
        int length = Integer.parseInt(bufferedReader.readLine());

        baekJoon2447.printStar(length);
    }

    public static class BaekJoon2439 {
        public void printStar(int length) {
            for (int i = 1; i <= length; i++) {
                for(int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2440 {
        public void printStar(int length) {
            for (int i = length; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2441 {
        public void printStar(int length) {
            for (int i = length; i > 0; i--) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = i; j > 0; j--) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2442 {
        public void printStar(int length) {
            for (int i = 1; i <= length; i++) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2443 {
        public void printStar(int length) {
            for (int i = length; i > 0; i--) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2444 {
        public void printStar(int length) {
            for (int i = 1; i <= length; i++) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2445 {
        public void printStar(int length) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }

                for (int j = (length - i - 1) * 2; j > 0; j--) {
                    System.out.print("-");
                }

                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            for (int i = length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }

                for (int j = (length - i) * 2; j > 0; j--) {
                    System.out.print("-");
                }

                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2446 {
        public void printStar(int length) {
            for (int i = length; i > 0; i--) {
                for (int j = 0; j < length - i; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < i * 2 -1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }

            for (int i = 1; i < length; i++) {
                for (int j = 0; j < (i * -1) + length - 1; j++) {
                    System.out.print(" ");
                }

                for (int j = 0; j < i * 2 + 1; j++) {
                    System.out.print("*");
                }

                System.out.println();
            }
        }
    }

    public static class BaekJoon2447 {
        static String[][] coordinate;

        public void printStar(int length) {
            coordinate = new String[length][length];

            coordinateInit();
            factorialSetCoordinate(0, 0, length);
            printCoordinate();
        }

        private void printCoordinate() {
            StringBuilder stringBuilder = new StringBuilder();

            for (int x = 0; x < coordinate.length; x++) {
                for (int y = 0; y < coordinate[0].length; y++) {
                    stringBuilder.append(coordinate[x][y]);
                }

                stringBuilder.append('\n');
            }

            System.out.print(stringBuilder);
        }

        private void coordinateInit() {
            for (int x = 0; x < coordinate.length; x++) {
                for (int y = 0; y < coordinate[0].length; y++) {
                    coordinate[x][y] = " ";
                }
            }
        }

        private void factorialSetCoordinate(int x, int y, int length) {
            if (length == 1) {
                coordinate[x][y] = "*";
                return;
            }

            int depth = length / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }

                    factorialSetCoordinate(x + i * depth, y + j * depth, depth);
                }
            }
        }
    }
}
