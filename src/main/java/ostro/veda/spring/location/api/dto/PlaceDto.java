package ostro.veda.spring.location.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {

    private int placeId;
    private AddressDto addressDto;
    private List<UserDto> users;
}