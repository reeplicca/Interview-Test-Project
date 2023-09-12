package kz.BekAidar.Library.repositories;

import kz.BekAidar.Library.entities.Library;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LibraryRepository extends JpaRepository<Library,Long> {
    Library findAllById(Long id);
}
