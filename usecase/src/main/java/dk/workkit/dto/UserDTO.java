package dk.workkit.dto;

import dk.workkit.domain.User;

import java.time.LocalDateTime;

public class UserDTO {

    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean admin;
    private LocalDateTime joinedDate;
    private LocalDateTime lastModified;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.admin = user.isAdmin();
        this.joinedDate = user.getJoinedDate();
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAdmin() {
        return admin;
    }

    public LocalDateTime getJoinedDate() {
        return joinedDate;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }
}
