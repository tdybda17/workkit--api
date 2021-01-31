package dk.workkit.endpoints.endpoints.createuser;

import dk.workkit.endpoints.endpoints.Response;
import dk.workkit.repositories.UserRepository;
import dk.workkit.usecases.createuser.CreateUserRequest;
import dk.workkit.usecases.createuser.CreateUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreateUserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.POST, value = "/users")
    public ResponseEntity<String> post(@RequestBody Map<String, Object> body) {
        CreateUserRequest request = new CreateUserRequest(body);
        CreateUserPresenter presenter = new CreateUserPresenter();
        new CreateUserUseCase(userRepository, request, presenter, null).create();
        Response response = presenter.getResponse();
        return new ResponseEntity<>(response.getJson(), response.getStatus());
    }
}
