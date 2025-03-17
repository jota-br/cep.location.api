package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ostro.veda.spring.location.api.model.User;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    Address findByCep(String cep);
}