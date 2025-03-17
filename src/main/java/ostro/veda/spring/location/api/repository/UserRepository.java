package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ostro.veda.spring.location.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT u.visitedPlaces FROM User u WHERE u.username = :username")
    List<Place> findVisitedPlacesByUsername(@Param("username") String username);
}
