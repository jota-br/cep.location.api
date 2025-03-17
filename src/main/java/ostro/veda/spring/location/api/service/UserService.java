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

    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    public UserService(UserRepository userRepository, PlaceRepository placeRepository) {
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    public User register(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        if (user == null) user = buildUser(userDto);
        else return null;
        return userRepository.save(user);
    }

    public Place addPlace(PlaceDto placeDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);

            Place place = buildPlace(placeDto)
                    .setUsers(List.of(user));

            return placeRepository.save(place);
        }
        return null;
    }

    public Place getPlace() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
        }

        return null;
    }

    private User buildUser(UserDto userDto) {
        return new User()
                .setUserId(userDto.getUserId())
                .setPassword(userDto.getPassword())
                .setUsername(userDto.getUsername());
    }

    private Place buildPlace(PlaceDto placeDto) {
        return new Place()
                .setPlaceId(placeDto.getPlaceId())
                .setAddress(buildAddress(placeDto.getAddressDto()));
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
}