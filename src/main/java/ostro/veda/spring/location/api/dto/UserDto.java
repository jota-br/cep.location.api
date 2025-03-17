package ostro.veda.spring.location.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String username;
    private String password;
    private List<PlaceDto> visitedPlaces;
    private List<RoleDto> roles;
}