package ostro.veda.spring.location.api.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ostro.veda.spring.location.api.dto.AddressDto;
import ostro.veda.spring.location.api.dto.PlaceDto;
import ostro.veda.spring.location.api.dto.UserDto;
import ostro.veda.spring.location.api.model.Address;
import ostro.veda.spring.location.api.model.Place;
import ostro.veda.spring.location.api.model.User;
import ostro.veda.spring.location.api.repository.PlaceRepository;
import ostro.veda.spring.location.api.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final CepService cepService;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public UserService(CepService cepService, UserRepository userRepository, PlaceRepository placeRepository) {
        this.cepService = cepService;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    public User register(UserRegisterDto userRegisterDto) {
        User user = userRepository.findByUsername(userRegisterDto.getUsername());
        if (user == null) user = buildUser(userDto);
        else return null;
        return userRepository.save(user);
    }

    public List<Place> getPlace() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return userRepository.findVisitedPlacesByUsername(username);
        }
        return List.of();
    }

    private User buildUser(UserRegisterDto userRegisterDto) {
        return new User()
                .setPassword(userDto.getPassword())
                .setUsername(userDto.getUsername());
    }
}