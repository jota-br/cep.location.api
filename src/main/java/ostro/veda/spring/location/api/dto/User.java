package ostro.veda.spring.location.api.dto;

@Getter
@Setter
@NoArgsConstructor
public class User {

    private String username;
    private String password;
    private List<Place> visitedPlaceList;
}