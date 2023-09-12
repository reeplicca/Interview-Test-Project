package kz.BekAidar.Library.services;

import kz.BekAidar.Library.entities.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Book getBook(Long id);
    Book updateBook(Book updBook);
    void deleteBook(Long id);
}
