package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ostro.veda.spring.location.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
