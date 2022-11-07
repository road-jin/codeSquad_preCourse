package org.codesquad.phone;

import java.util.Scanner;

public class PhoneBook {

    private final Phone[] phones;
    private Integer currentIndex;

    public PhoneBook(int length) {
        this.phones = new Phone[length];
        this.currentIndex = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("인원수 >> ");
        int size = scanner.nextInt();
        PhoneBook phoneBook = new PhoneBook(size);

        for (int i = 0; i < size; i++) {
            System.out.printf("이름과 전화번호(이름과 번호는 빈칸없이 입력)>> ");
            String name = scanner.next();
            String tel = scanner.next();
            phoneBook.save(name, tel);
        }

        while (true) {
            System.out.printf("검색할 이름 >> ");
            String findName = scanner.next();

            if (findName.equals("그만")) {
                scanner.close();
                return;
            }

            System.out.println(phoneBook.search(findName));
        }
    }

    public void save(String name, String tel) {
        if (currentIndex < phones.length) {
            phones[currentIndex++] = new Phone(name, tel);
        }
    }

    public String search(String findName) {
        for (int i = 0; i < phones.length; i++) {
            if (phones[i].search(findName)) {
                return phones[i].show();
            }
        }

        return findName + "이 없습니다.";
    }
}
