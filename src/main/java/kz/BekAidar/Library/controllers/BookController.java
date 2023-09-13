package kz.BekAidar.Library.controllers;

import kz.BekAidar.Library.entities.Book;
import kz.BekAidar.Library.services.BookService;
import kz.BekAidar.Library.services.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private  final RabbitTemplate template;

    @Autowired
    public BookController(RabbitTemplate template) {
        this.template = template;
    }

    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        logger.info("Emit to myQueue");
        template.setExchange("add-book");
        template.convertAndSend(book);
        return ResponseEntity.ok("Success emit to queue");
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBook(id);
    }

    @PutMapping()
    public Book updateBook(@RequestBody Book updBook) {
        return bookService.updateBook(updBook);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
