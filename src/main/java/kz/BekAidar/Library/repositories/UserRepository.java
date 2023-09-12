package kz.BekAidar.Library.repositories;

import kz.BekAidar.Library.entities.Library;
import kz.BekAidar.Library.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllById(Long id);
    List<User> findAllByLibraries(Library library);
}
