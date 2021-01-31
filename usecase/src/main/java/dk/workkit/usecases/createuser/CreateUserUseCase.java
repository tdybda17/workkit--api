package dk.workkit.usecases.createuser;

import dk.workkit.domain.User;
import dk.workkit.dto.UserDTO;
import dk.workkit.exceptions.repository.RepositoryException;
import dk.workkit.exceptions.repository.UniqueFieldViolationException;
import dk.workkit.exceptions.validation.ValidationException;
import dk.workkit.interfaces.Session;
import dk.workkit.repositories.UserRepository;

public class CreateUserUseCase {
    private UserRepository repository;
    private CreateUserRequest request;
    private CreateUserHandler handler;
    private Session session;

    public CreateUserUseCase(
            UserRepository repository,
            CreateUserRequest request,
            CreateUserHandler handler,
            Session session) {
        this.repository = repository;
        this.request = request;
        this.handler = handler;
        this.session = session;
    }

    public void create() {
        try {
            User user = request.validate();
            user = repository.save(user);
            handler.handleSuccess(new UserDTO(user));
        } catch (ValidationException e) {
            handler.handleValidationError(e);
        } catch (UniqueFieldViolationException e) {
            handler.handleUniqueFieldViolated(e.getMessage());
        } catch (RepositoryException e) {
            handler.handleIntegrityError(e);
        }
    }

}
