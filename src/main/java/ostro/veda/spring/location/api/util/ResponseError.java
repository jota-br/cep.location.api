package ostro.veda.spring.location.api.util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseError {

    private LocalDateTime timestamp = LocalDateTime.now();
    private String status;
    private int statusCode;
    private String error;
}
