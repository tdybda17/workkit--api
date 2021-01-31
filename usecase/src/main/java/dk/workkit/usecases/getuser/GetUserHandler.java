package dk.workkit.usecases.getuser;

import dk.workkit.dto.UserDTO;

public interface GetUserHandler {
    void handleSuccess(UserDTO userDTO);
}
