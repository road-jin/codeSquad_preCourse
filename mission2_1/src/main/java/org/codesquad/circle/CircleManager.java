package org.codesquad.circle;

import java.util.Scanner;

public class CircleManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle circles[] = new Circle[3];

        for (int i = 0; i < circles.length; i++) {
            System.out.print("x, y, radius >>");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            int radius = scanner.nextInt();
            circles[i] = new Circle(x, y, radius);
        }

        //for (int i = 0; i < circles.length; i++) circles[i].show();// 출력
        int maxIndex = 0;

        for (int i = 1; i < circles.length; i++) {
            if (circles[maxIndex].area() < circles[i].area()) {
                maxIndex = i;
            }
        }

        circles[maxIndex].show();
        scanner.close();
    }
}
