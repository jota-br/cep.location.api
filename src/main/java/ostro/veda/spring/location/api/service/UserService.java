package ostro.veda.spring.location.api.dto;

@Service
public class UserService {

    public String addPlace(PlaceDto placeDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            User user = userRepository.findByUsername(username);
            placeDto.setUser(user);
            return placeRepository.save(placeDto);
        }
    }

    public String getPlace() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
        }
    }
}