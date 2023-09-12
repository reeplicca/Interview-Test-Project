package kz.BekAidar.Library.services;

import kz.BekAidar.Library.entities.Library;

import java.util.List;

public interface LibraryService {
    Library addLibrary(Library library);
    List<Library> getAllLibraries();
    Library getLibrary(Long id);
    Library updateLibrary(Library updLibrary);
    void deleteLibrary(Long id);
}
