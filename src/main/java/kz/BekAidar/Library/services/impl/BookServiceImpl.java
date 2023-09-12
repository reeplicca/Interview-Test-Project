package kz.BekAidar.Library.services.impl;

import kz.BekAidar.Library.entities.Book;
import kz.BekAidar.Library.repositories.BookRepository;
import kz.BekAidar.Library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findAllById(id);
    }

    @Override
    public Book updateBook(Book updBook) {
        Book book = bookRepository.findAllById(updBook.getId());
        book.setName(updBook.getName());
        book.setLibrary(updBook.getLibrary());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
