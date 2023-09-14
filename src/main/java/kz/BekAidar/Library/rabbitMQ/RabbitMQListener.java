package kz.BekAidar.Library.rabbitMQ;

import kz.BekAidar.Library.entities.Book;
import kz.BekAidar.Library.entities.Library;
import kz.BekAidar.Library.entities.User;
import kz.BekAidar.Library.services.BookService;
import kz.BekAidar.Library.services.LibraryService;
import kz.BekAidar.Library.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RabbitMQListener {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private LibraryService libraryService;

    Logger logger = LoggerFactory.getLogger(RabbitMQListener.class);

    @RabbitListener(queues = "myQueueUser")
    public void processMyQueueUser(User user) {
        userService.addUser(user);
        logger.info("Received first form myQueue: {}", "Add User");
    }

    @RabbitListener(queues = "myQueueBook")
    public void processMyQueueBook(Book book) {
        bookService.addBook(book);
        logger.info("Received second form myQueue: {}", "Add Book");
    }

    @RabbitListener(queues = "myQueueLibrary")
    public void processMyQueueLibrary(Library library) {
        libraryService.addLibrary(library);
        logger.info("Received third form myQueue: {}", "Add Library");
    }
}
