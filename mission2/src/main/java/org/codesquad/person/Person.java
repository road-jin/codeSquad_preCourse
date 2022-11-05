package org.codesquad.person;

import org.codesquad.person.marriageinfo.MarriageInfo;
import org.codesquad.person.personalidentification.PersonalIdentification;

public class Person {

    private final PersonalIdentification personalIdentification;
    private MarriageInfo marriageInfo;
    private Money money;

    public Person(String name) {
        this.personalIdentification = new PersonalIdentification(name);
    }

    public Person(String name, Integer money) {
        this.personalIdentification = new PersonalIdentification(name);
        this.money = new Money(money);
    }

    public Person(PersonalIdentification personalIdentification, MarriageInfo marriageInfo) {
        this.personalIdentification = personalIdentification;
        this.marriageInfo = marriageInfo;
    }

    public int getMoney() {
        return this.money.show();
    }

    public void sendMoney(int buyPrice) {
        this.money.send(buyPrice);
    }

    public String getName() {
        return personalIdentification.getName();
    }

    public String showPersonInfo() {
        return "이름은 " + personalIdentification.getName() + "이고 " +
                "나이는 " + personalIdentification.getAge() + "살 입니다. " +
                "성별은 " + personalIdentification.getGender() + " 이며, " +
                marriageInfo.getMaritalStatus() + "입니다. " +
                "자녀는 " + marriageInfo.getChild() + "명이 있습니다.";
    }
}