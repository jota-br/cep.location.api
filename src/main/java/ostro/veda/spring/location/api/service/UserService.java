package ostro.veda.spring.location.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ostro.veda.spring.location.api.dto.AddressDto;
import ostro.veda.spring.location.api.dto.UserRegisterDto;
import ostro.veda.spring.location.api.model.Address;
import ostro.veda.spring.location.api.model.Place;
import ostro.veda.spring.location.api.model.Role;
import ostro.veda.spring.location.api.model.User;
import ostro.veda.spring.location.api.repository.AddressRepository;
import ostro.veda.spring.location.api.repository.PlaceRepository;
import ostro.veda.spring.location.api.repository.RoleRepository;
import ostro.veda.spring.location.api.repository.UserRepository;
import ostro.veda.spring.location.api.util.BusinessException;

import java.util.List;

@Service
public class UserService {

    private final CepService cepService;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(CepService cepService, UserRepository userRepository, PlaceRepository placeRepository, RoleRepository roleRepository, AddressRepository addressRepository) {
        this.cepService = cepService;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
        this.roleRepository = roleRepository;
        this.addressRepository = addressRepository;
    }

    public User register(UserRegisterDto userRegisterDto) {
        User user = userRepository.findByUsername(userRegisterDto.getUsername());
        if (user == null) {
            Role role = roleRepository.findByName("USERS");
            user = buildUser(userRegisterDto).setRole(role);
        } else throw new BusinessException("User already exists");
        return userRepository.save(user);
    }

    public List<Place> getPlace() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            return userRepository.findVisitedPlacesByUsername(username);
        }
        throw new BusinessException("Authentication required");
    }

    public User addPlace(String cep) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {

            String username = authentication.getName();
            User user = userRepository.findByUsername(username);
            String formattedCep = cep.substring(0, 5) + "-" + cep.substring(5);
            Address address = addressRepository.findByCep(formattedCep);

            Place place = null;
            if (address == null)
                address = buildAddress(cepService.getAddress(cep));
            else place = placeRepository.findByAddress(address);

            if (place == null) {
                place = new Place()
                        .setAddress(address);
            }

            if (!place.getUsers().contains(user)) {
                place.getUsers().add(user);
                user.getVisitedPlaces().add(place);
                return userRepository.save(user);
            }
            throw new BusinessException("CEP already associated with User", username);
        }
        throw new BusinessException("Authentication required");
    }

    private Address buildAddress(AddressDto addressDto) {
        return new Address()
                .setCep(addressDto.getCep())
                .setLogradouro(addressDto.getLogradouro())
                .setComplemento(addressDto.getComplemento())
                .setUnidade(addressDto.getUnidade())
                .setBairro(addressDto.getBairro())
                .setLocalidade(addressDto.getLocalidade())
                .setUf(addressDto.getUf())
                .setEstado(addressDto.getEstado())
                .setRegiao(addressDto.getRegiao())
                .setIbge(addressDto.getIbge())
                .setGia(addressDto.getGia())
                .setDdd(addressDto.getDdd())
                .setSiafi(addressDto.getSiafi());
    }

    private User buildUser(UserRegisterDto userRegisterDto) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRegisterDto.getPassword());
        return new User()
                .setPassword(encryptedPassword)
                .setUsername(userRegisterDto.getUsername());
    }
}