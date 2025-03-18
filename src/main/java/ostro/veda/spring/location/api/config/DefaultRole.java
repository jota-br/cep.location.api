package ostro.veda.spring.location.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ostro.veda.spring.location.api.model.Role;
import ostro.veda.spring.location.api.repository.RoleRepository;

@Component
public class DefaultRole implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role role = roleRepository.findByName("USERS");
        if (role == null)
            roleRepository.save(new Role().setName("USERS"));
    }
}
