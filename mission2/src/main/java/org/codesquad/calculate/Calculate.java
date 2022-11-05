package org.codesquad.calculate;

public class Calculate {

    public int addition(Number number) {
        return number.getNumber1() + number.getNumber2();
    }

    public int subtraction(Number number) {
        return number.getNumber1() - number.getNumber2();
    }

    public int multiplication(Number number) {
        return number.getNumber1() * number.getNumber2();
    }

    public int division(Number number) {
        return number.getNumber1() / number.getNumber2();
    }
}
