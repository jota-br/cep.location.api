package ostro.veda.spring.location.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ostro.veda.spring.location.api.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}