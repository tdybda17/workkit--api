package dk.workkit.endpoints.endpoints.createuser;

import dk.workkit.dto.UserDTO;
import dk.workkit.endpoints.endpoints.Presenter;
import dk.workkit.endpoints.endpoints.Response;
import dk.workkit.endpoints.tools.Json;
import dk.workkit.exceptions.repository.RepositoryException;
import dk.workkit.exceptions.validation.ValidationException;
import dk.workkit.usecases.createuser.CreateUserHandler;
import org.springframework.http.HttpStatus;

public class CreateUserPresenter implements Presenter, CreateUserHandler {

    private Response response;

    @Override
    public Response getResponse() {
        return response;
    }

    @Override
    public void handleIntegrityError(RepositoryException e) {
        this.response = Response.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @Override
    public void handleUnauthorized() {
        this.response = Response.unauthorized();
    }

    @Override
    public void handleValidationError(ValidationException e) {
        this.response = Response.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @Override
    public void handleSuccess(UserDTO userDTO) {
        this.response = Response.success(HttpStatus.CREATED, Json.to(userDTO));
    }

    @Override
    public void handleUniqueFieldViolated(String text) {
        this.response = Response.error(HttpStatus.CONFLICT, text);
    }
}
