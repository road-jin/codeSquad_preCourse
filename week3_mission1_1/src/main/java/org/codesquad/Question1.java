package org.codesquad;

import org.codesquad.point.ColorPoint;
import org.codesquad.point.Point3D;
import org.codesquad.point.PositivePoint;

public class Question1 {

    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
        cp.setXY(10, 20);
        cp.setColor("RED");
        String str = cp.toString();
        System.out.println(str + "입니다.");

        System.out.println("====================================================");

        ColorPoint zeroPoint = new ColorPoint(); // (0,0) 위치의 BLACK 색 점
        System.out.println(zeroPoint.toString() + "입니다.");
        ColorPoint cp2 = new ColorPoint(10, 10); // (10,10) 위치의 BLACK 색 점
        cp2.setXY(5, 5);
        cp2.setColor("RED");
        System.out.println(cp2.toString() + "입니다.");

        System.out.println("====================================================");

        Point3D p = new Point3D(1, 2, 3);// 1,2,3은 각각 x, y, z축의 값.
        System.out.println(p.toString() + "입니다.");

        p.moveUp();// z 축으로 위쪽 이동
        System.out.println(p.toString() + "입니다.");

        p.moveDown();// z 축으로 아래쪽 이동
        p.move(10, 10);// x, y 축으로 이동
        System.out.println(p.toString() + "입니다.");

        p.move(100, 200, 300);// x, y, z축으로 이동
        System.out.println(p.toString() + "입니다.");

        System.out.println("====================================================");

        PositivePoint p2 = new PositivePoint();
        p2.move(10, 10);
        System.out.println(p2.toString() + "입니다.");

        p2.move(-5, 5);// 객체 p는 음수 공간으로 이동되지 않음
        System.out.println(p2.toString() + "입니다.");

        PositivePoint p3 = new PositivePoint(-10, -10);
        System.out.println(p3.toString() + "입니다.");
    }
}
