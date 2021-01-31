package dk.workkit.usecases.getuser;

import dk.workkit.domain.User;
import dk.workkit.dto.UserDTO;
import dk.workkit.repositories.UserRepository;

public class GetUserUseCase {
    private UserRepository repository;
    private GetUserHandler handler;

    public GetUserUseCase(
            UserRepository repository,
            GetUserHandler handler) {
        this.repository = repository;
        this.handler = handler;
    }

    public void get(String id) {
        User user = repository.get(id);
        handler.handleSuccess(new UserDTO(user));
    }

}
