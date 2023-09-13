package kz.BekAidar.Library.repositories;

import kz.BekAidar.Library.entities.Book;
import kz.BekAidar.Library.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Book findAllById(Long id);
    List<Book> findAllByLibrary(Library library);
}
