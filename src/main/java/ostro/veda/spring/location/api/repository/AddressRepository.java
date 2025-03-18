package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ostro.veda.spring.location.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "SELECT * FROM address a WHERE a.cep = :cep LIMIT 1", nativeQuery = true)
    Address findByCep(@Param("cep") String cep);
}