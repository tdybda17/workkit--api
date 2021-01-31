package dk.workkit.endpoints.endpoints.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ObjectMappingException extends RuntimeException {
    public ObjectMappingException(String message) {
        super(message);
    }
}
