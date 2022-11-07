package org.codesquad.phone;

public class Phone {

    private final String name;
    private final String tel;

    public Phone(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public boolean search(String searchName) {
        if (name.equals(searchName)) {
            return true;
        }

        return false;
    }

    public String show() {
        return name + "의 번호는 " + tel + " 입니다.";
    }
}
