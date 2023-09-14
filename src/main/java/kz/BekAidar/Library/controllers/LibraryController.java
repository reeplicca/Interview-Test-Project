package kz.BekAidar.Library.controllers;

import kz.BekAidar.Library.entities.Library;
import kz.BekAidar.Library.services.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    Logger logger = LoggerFactory.getLogger(LibraryController.class);

    private  final AmqpTemplate template;

    @Autowired
    public LibraryController(AmqpTemplate template) {
        this.template = template;
    }

    @Autowired
    private LibraryService libraryService;

    @PostMapping()
    public ResponseEntity<String> addLibrary(@RequestBody Library library) {
        logger.info("Emit to myQueue");
        template.convertAndSend("myQueueLibrary",library);
        return ResponseEntity.ok("Success emit to queue");
    }

    @GetMapping()
    public List<Library> getAllLibrary() {
        return libraryService.getAllLibraries();
    }

    @GetMapping(value = "/{id}")
    public Library getLibrary(@PathVariable("id") Long id) {
        return libraryService.getLibrary(id);
    }

    @PutMapping()
    public Library updateLibrary(@RequestBody Library updLibrary) {
        return libraryService.updateLibrary(updLibrary);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLibrary(@PathVariable("id") Long id) {
        libraryService.deleteLibrary(id);
    }
}
