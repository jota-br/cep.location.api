package ostro.veda.spring.location.api.dto;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {

    private Address address;
    private List<User> users;
}