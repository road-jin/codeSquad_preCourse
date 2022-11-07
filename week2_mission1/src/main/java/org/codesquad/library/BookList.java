package org.codesquad.library;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> books;

    public BookList() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public BookList copy() {
        BookList copyBooks = new BookList();
        books.forEach((book) -> copyBooks.add(book));
        return copyBooks;
    }

    public void showAll() {
        books.forEach((book -> System.out.println(book.show())));
        System.out.println();
    }


    public void update(Book findBook, Book updateBook) {
        books.remove(findBook);
        books.add(updateBook);
    }
}
