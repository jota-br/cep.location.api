package ostro.veda.spring.location.api.dto;

@Service
public class UserService {

    public String addPlace(PlaceDto placeDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);
            Place place = buildPlace(placeDto)
                .setUser(List.of(user));
            return placeRepository.save(placeDto);
        }
    }

    public String getPlace() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
        }
    }

    private Place buildPlace(PlaceDto placeDto) {
        return new Place()
            .setPlaceId(placeDto.getPlaceId())
            .setAddress()
    }

    private Address buildAddress(AddressDto addressDto) {
        return new Address()
            .setAdressId(addressDto.getAddressId())
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