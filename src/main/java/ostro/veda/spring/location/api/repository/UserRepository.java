package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ostro.veda.spring.location.api.model.Place;
import ostro.veda.spring.location.api.model.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query("SELECT u.visitedPlaces FROM User u WHERE u.username = :username")
    List<Place> findVisitedPlacesByUsername(@Param("username") String username);
}
