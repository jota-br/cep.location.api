package ostro.veda.spring.location.api.dto;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String username;
    private String password;
    private List<Place> visitedPlaces;
}