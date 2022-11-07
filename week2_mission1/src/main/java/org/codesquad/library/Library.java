package org.codesquad.library;

public class Library {

    private BookList books;

    public Library(BookList books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        books.showAll();
    }

    public void updateBook(Book findBook, Book updateBook) {
        books.update(findBook, updateBook);
    }
}
