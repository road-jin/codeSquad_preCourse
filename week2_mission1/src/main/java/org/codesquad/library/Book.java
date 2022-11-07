package org.codesquad.library;

public class Book {

    private final String subject;
    private final String author;

    public Book(String subject, String author) {
        this.subject = subject;
        this.author = author;
    }

    public String show() {
        return "제목 : " + subject + " 저자 : " + author;
    }

    public boolean find(Book book) {
        return subject.equals(book.subject);
    }
}
