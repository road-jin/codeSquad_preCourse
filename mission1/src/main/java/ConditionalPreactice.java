import java.util.Scanner;

public class ConditionalPreactice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /*
        BaekJoon1330 baekJoon1330 = new BaekJoon1330();
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon1330.getCompare(number1, number2));
        */

        /*
|       BaekJoon9498 baekJoon9498 = new BaekJoon9498();
        int score = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon9498.getGrade(score));
        */

        /*
        BaekJoon2753 baekJoon2753 = new BaekJoon2753();
        int year = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon2753.getLeapYear(year));
        */

        /*
        BaekJoon14681 baekJoon14681 = new BaekJoon14681();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon14681.getQuadrantNumber(x, y));
        */

        /*
        BaekJoon2884 baekJoon2884 = new BaekJoon2884();
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon2884.getAlarmTime(hour, minute));
        */

        /*
        BaekJoon2525 baekJoon2525 = new BaekJoon2525();
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        int cookingTime = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon2525.getOvenEndTime(hour, minute, cookingTime));
        */

        BaekJoon2480 baekJoon2480 = new BaekJoon2480();
        int diceNumber1 = scanner.nextInt();
        int diceNumber2 = scanner.nextInt();
        int diceNumber3 = scanner.nextInt();

        scanner.close();
        System.out.println(baekJoon2480.getPrizeMoney(diceNumber1, diceNumber2, diceNumber3));
    }

    public static class BaekJoon1330 {
        public String getCompare(int number1, int number2) {
            if (number1 < number2) {
                return "<";
            }

            if (number1 > number2) {
                return ">";
            }

            return "==";
        }
    }

    public static class BaekJoon9498 {
        public String getGrade(int score) {
            if (score >= 90) {
                return "A";
            }

            if (score >= 80) {
                return "B";
            }

            if (score >= 70) {
                return "C";
            }

            if (score >= 60) {
                return "D";
            }

            return "F";
        }
    }

    public static class BaekJoon2753{
        public int getLeapYear(int year) {
            if (year % 4 == 0) {
                if (year % 100 != 0 || year % 400 == 0) {
                    return 1;
                }
            }

            return 0;
        }
    }

    public static class BaekJoon14681{
        public int getQuadrantNumber(int x, int y) {
            if (x > 0 && y > 0) {
                return 1;
            }

            if (x < 0 && y > 0) {
                return 2;
            }

            if (x < 0 && y < 0) {
                return 3;
            }

            return 4;
        }
    }

    public static class BaekJoon2884 {
        public String getAlarmTime(int hour, int minute) {
            int resultHour = hour;
            int resultMinute = minute - 45;

            if (resultMinute < 0) {
                resultHour--;
                resultMinute += 60;

                if (resultHour < 0) {
                    resultHour = 23;
                }
            }

            return resultHour + " " + resultMinute;
        }
    }

    public static class BaekJoon2525 {
        public String getOvenEndTime(int hour, int minute, int cookingTime) {
            int resultHour = hour + (cookingTime / 60);
            int resultMinute = minute + (cookingTime % 60);

            if (resultMinute >= 60) {
                resultMinute %= 60;
                resultHour++;
            }

            if (resultHour >= 24) {
                resultHour -= 24;
            }

            return  resultHour + " " + resultMinute;
        }
    }

    public static class BaekJoon2480 {
        public int getPrizeMoney(int diceNumber1, int diceNumber2, int diceNumber3) {
            if (diceNumber1 == diceNumber2 && diceNumber2 == diceNumber3) {
                return 10000 + diceNumber1 * 1000;
            }

            if (diceNumber1 == diceNumber2 || diceNumber1 == diceNumber3) {
                return 1000 + diceNumber1 * 100;
            }

            if (diceNumber2 == diceNumber3) {
                return 1000 + diceNumber2 * 100;
            }

            int maxDiceNumber = maxDiceNumber(diceNumber1, diceNumber2, diceNumber3);

            return maxDiceNumber * 100;
        }

        private int maxDiceNumber(int diceNumber1, int diceNumber2, int diceNumber3) {
            if (diceNumber1 > diceNumber2) {
                if (diceNumber1 > diceNumber3) {
                    return diceNumber1;
                }
            }

            if (diceNumber2 > diceNumber3) {
                return diceNumber2;
            }

            return diceNumber3;
        }
    }


}

