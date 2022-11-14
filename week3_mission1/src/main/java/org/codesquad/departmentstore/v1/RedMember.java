package org.codesquad.departmentstore.v1;

public class RedMember extends Member {

    public RedMember(String name, int buyPrice, int shoppingHours) {
        super(name, buyPrice, shoppingHours);
        super.grade = "RED";
        super.pointRatio = 0.01;
    }
}
