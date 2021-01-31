package dk.workkit.usecases.createuser;

import dk.workkit.domain.User;
import dk.workkit.exceptions.validation.ValidationException;
import dk.workkit.interfaces.Request;
import dk.workkit.tools.ValueExtractor;

import java.time.LocalDateTime;
import java.util.Map;

public class CreateUserRequest implements Request<User> {

    private Map<String, Object> body;
    private String username;
    private String email;
    private String password;
    private String confPassword;
    private String firstName;
    private String lastName;

    public CreateUserRequest(Map<String, Object> body) {
        this.body = body;
        this.username = ValueExtractor.getStringOrDefault(body, "username");
        this.email = ValueExtractor.getStringOrDefault(body, "email");
        this.password = ValueExtractor.getStringOrDefault(body, "password");
        this.confPassword = ValueExtractor.getStringOrDefault(body, "confPassword");
        this.firstName = ValueExtractor.getStringOrDefault(body, "firstName");
        this.lastName = ValueExtractor.getStringOrDefault(body, "lastName");
    }

    @Override
    public User validate() throws ValidationException {
        return new User.UserBuilder()
                .setUsername(getUsername())
                .setPassword(getPassword())
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setEmail(getEmail())
                .setJoinedDate(LocalDateTime.now())
                .build();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
