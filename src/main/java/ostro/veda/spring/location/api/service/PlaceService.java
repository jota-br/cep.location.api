package ostro.veda.spring.location.api.service;

@Service
public class PlaceService {
    
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(AddressRepository addressRepository, UserRepository userRepository, PlaceRepository placeRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;
    }

    public Place addPlace(String cep) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);
            Place place = null;
            Address address = addressRepository.findByCep(cep);

            if (address == null)
                address = buildAddress(cepService.getAddress(cep));
            else place = placeRepository.findByAddress(address);

            if (place == null) {            
                place = new Place()
                        .setUsers(List.of(user))
                        .setAddress(address);
            } else {
                if (!place.getUsers().contains(user))
                    place.getUsers().add(user);
            }

            return placeRepository.save(place);
        }
        return null;
    }

    private Place buildPlace(PlaceDto placeDto) {
        return new Place()
                .setPlaceId(placeDto.getPlaceId())
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