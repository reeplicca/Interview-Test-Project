package kz.BekAidar.Library.repositories;

import kz.BekAidar.Library.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Long> {
    Library findAllById(Long id);
}
