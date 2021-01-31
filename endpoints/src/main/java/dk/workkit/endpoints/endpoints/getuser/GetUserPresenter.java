package dk.workkit.endpoints.endpoints.getuser;

import dk.workkit.dto.UserDTO;
import dk.workkit.endpoints.endpoints.Presenter;
import dk.workkit.endpoints.endpoints.Response;
import dk.workkit.endpoints.tools.Json;
import dk.workkit.usecases.getuser.GetUserHandler;
import org.springframework.http.HttpStatus;

public class GetUserPresenter implements Presenter, GetUserHandler {

    private Response response;

    @Override
    public Response getResponse() {
        return response;
    }

    @Override
    public void handleSuccess(UserDTO userDTO) {
        this.response = Response.success(HttpStatus.OK, Json.to(userDTO));
    }
}
