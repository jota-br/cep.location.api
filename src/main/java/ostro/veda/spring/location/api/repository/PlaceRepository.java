package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ostro.veda.spring.location.api.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    Place findByAddress(Address address);
}
