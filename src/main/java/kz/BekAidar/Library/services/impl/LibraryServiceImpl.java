package kz.BekAidar.Library.services.impl;

import kz.BekAidar.Library.entities.Book;
import kz.BekAidar.Library.entities.Library;
import kz.BekAidar.Library.entities.User;
import kz.BekAidar.Library.repositories.BookRepository;
import kz.BekAidar.Library.repositories.LibraryRepository;
import kz.BekAidar.Library.repositories.UserRepository;
import kz.BekAidar.Library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Library addLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    @Override
    public Library getLibrary(Long id) {
        return libraryRepository.findAllById(id);
    }

    @Override
    public Library updateLibrary(Library updLibrary) {
        Library library = libraryRepository.findAllById(updLibrary.getId());
        library.setName(updLibrary.getName());
        library.setDistrict(updLibrary.getDistrict());
        return libraryRepository.save(library);
    }

    @Override
    public void deleteLibrary(Long id) {
        Library library = libraryRepository.findAllById(id);
        List<Book> books = bookRepository.findAllByLibrary(library);
        List<User> users = userRepository.findAllByLibraries(library);

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getLibrary().equals(library)) {
                bookRepository.deleteById(books.get(i).getId());
            }
        }

        for (int i = 0; i < users.size(); i++) {
            List<Library> libraries = users.get(i).getLibraries();
            libraries.remove(library);
        }

        libraryRepository.deleteById(id);
    }
}
