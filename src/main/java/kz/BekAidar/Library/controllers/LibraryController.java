package kz.BekAidar.Library.controllers;

import kz.BekAidar.Library.entities.Library;
import kz.BekAidar.Library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping()
    public Library addLibrary(@RequestBody Library library) {
        return libraryService.addLibrary(library);
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
