package org.codesquad;

import org.codesquad.alphabet.AlphabetArray;
import org.codesquad.library.Book;
import org.codesquad.library.BookList;
import org.codesquad.library.Library;
import org.codesquad.maze.Maze;

public class Main {

    public static void main(String[] args) {
        // 문제1
        AlphabetArray alphabetArray = new AlphabetArray();
        alphabetArray.print();

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

        BookList copyBooks = books.copy();

        Library onVillage = new Library(books.copy());
        Library doVillage = new Library(books.copy());

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

        // 문제3
        Maze maze = new Maze();
        maze.findExit();
    }
}
