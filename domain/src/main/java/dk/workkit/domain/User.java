package dk.workkit.domain;

import java.time.LocalDateTime;

public class User implements Model {
    private final String id;
    private final String username;
    private final String email;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final boolean admin;
    private final LocalDateTime joinedDate;

    public User(
            String id,
            String username,
            String email,
            String password,
            String firstName,
            String lastName,
            boolean admin,
            LocalDateTime joinedDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.admin = admin;
        this.joinedDate = joinedDate == null ? LocalDateTime.now() : joinedDate;
    }

    @Override
    public String getId() {
        return id;
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

    public static class UserBuilder {
        private String id;
        private String username;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private boolean admin;
        private LocalDateTime joinedDate;

        public UserBuilder() {
        }

        public UserBuilder(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.email = user.getEmail();
            this.password = user.getPassword();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.admin = user.isAdmin();
            this.joinedDate = user.getJoinedDate();
        }

        public UserBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setAdmin(boolean admin) {
            this.admin = admin;
            return this;
        }

        public UserBuilder setJoinedDate(LocalDateTime joinedDate) {
            this.joinedDate = joinedDate;
            return this;
        }

        public User build() {
            return new User(
                    this.id,
                    this.username,
                    this.email,
                    this.password,
                    this.firstName,
                    this.lastName,
                    this.admin,
                    this.joinedDate
            );
        }
    }
}
