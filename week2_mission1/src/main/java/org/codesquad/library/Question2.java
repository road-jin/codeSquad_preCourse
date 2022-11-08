package org.codesquad.library;

public class Question2 {

    public static void main(String[] args) {
        // 문제2
        Book book1 = new Book("태백산맥", "조정래");
        Book book2 = new Book("이기적 유전자", "리처드 도킨즈");
        Book book3 = new Book("자전거 도둑", "박완서");
        Book book4 = new Book("토지", "박경리");
        Book book5 = new Book("대변동", "제레드 다이아몬드");

        BookList books = new BookList();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        BookList copyBooks = books.shallowCopy();

        Library onVillage = new Library(copyBooks);
        Library doVillage = new Library(copyBooks.deepCopy());

        onVillage.showBooks();
        copyBooks.showAll();
        doVillage.showBooks();

        System.out.println("------------------------------------------------------");

        Book book6 = new Book("그 많던 싱아는 누가 다 먹었을까", "박완서");
        onVillage.updateBook(book3, book6);

        doVillage.addBook(new Book("사피엔스", "유발 하라리"));

        onVillage.showBooks();
        copyBooks.showAll();
        doVillage.showBooks();
    }
}
