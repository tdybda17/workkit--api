package dk.workkit.endpoints.endpoints.getuser;

import dk.workkit.endpoints.endpoints.Response;
import dk.workkit.repositories.UserRepository;
import dk.workkit.usecases.getuser.GetUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET, value = "/users/{id}")
    public ResponseEntity<String> get(@PathVariable String id) {
        GetUserPresenter presenter = new GetUserPresenter();
        new GetUserUseCase(
                userRepository,
                presenter
        ).get(id);
        Response response = presenter.getResponse();
        return new ResponseEntity<>(
              response.getJson(),
              response.getStatus()
        );
    }

}
