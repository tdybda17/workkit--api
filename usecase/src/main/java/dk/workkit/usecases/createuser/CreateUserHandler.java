package dk.workkit.usecases.createuser;

import dk.workkit.dto.UserDTO;
import dk.workkit.interfaces.IntegrityErrorHandler;
import dk.workkit.interfaces.UnauthorizedHandler;
import dk.workkit.interfaces.UniqueFieldHandler;
import dk.workkit.interfaces.ValidationErrorHandler;

public interface CreateUserHandler extends
        UnauthorizedHandler,
        ValidationErrorHandler,
        IntegrityErrorHandler,
        UniqueFieldHandler {
    void handleSuccess(UserDTO userDTO);
}
