package org.codesquad;

import org.codesquad.cafe.Cafe;
import org.codesquad.cafe.Menu;
import org.codesquad.person.Person;

public class Main {

    public static void main(String[] args) {
        /*
        // 문제 #1
        Number number = new Number(10, 2);
        Calculate calculationService = new Calculate();

        System.out.println(calculationService.addition(number));
        System.out.println(calculationService.subtraction(number));
        System.out.println(calculationService.multiplication(number));
        System.out.println(calculationService.division(number));
         */


        /*
        // 문제 #2
        Person jane = new Person(new PersonalIdentification("제인", 30, Gender.female),
                new MarriageInfo(MaritalStatus.married, 1));
        System.out.println(jane.showPersonInfo());
        */



        // 문제 #3
        Cafe starbucks = new Cafe("별다방");
        Cafe bean = new Cafe("콩다방");

        Menu americano = new Menu("아메리카노", 4000);
        Menu latte = new Menu("라떼", 5000);
        starbucks.addMenu(americano);
        bean.addMenu(latte);

        Person james = new Person("James", 5000);
        Person tomas = new Person("Tomas", 10000);

        starbucks.order(james, americano);
        bean.order(tomas, latte);

        /*
        // 문제 #4
        MyDate date1 = new MyDate(30, 2, 2000);
        System.out.println(date1.isValid());
        MyDate date2 = new MyDate(31, 10, 2006);
        System.out.println(date2.isValid());

        //		date1.day =10;   에러
        //		date1.month = 3; 에러
        //		date1.year = 2020; 에러
        */
    }
}