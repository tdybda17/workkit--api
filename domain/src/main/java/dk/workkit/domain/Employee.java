package dk.workkit.domain;

public class Employee implements Model {
    private String id;
    private User user;
    private String initials;
    private String workPhone;

    public Employee(String id, User user, String initials, String workPhone) {
        this.id = id;
        this.user = user;
        this.initials = initials;
        this.workPhone = workPhone;
    }

    public User getUser() {
        return user;
    }

    public String getInitials() {
        return initials;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    @Override
    public String getId() {
        return id;
    }

    public static class EmployeeBuilder {
        private String id;
        private User user;
        private String initials;
        private String workPhone;

        public EmployeeBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public EmployeeBuilder setInitials(String initials) {
            this.initials = initials;
            return this;
        }

        public EmployeeBuilder setWorkPhone(String workPhone) {
            this.workPhone = workPhone;
            return this;
        }

        public Employee build() {
            return new Employee(
                    id,
                    user,
                    initials,
                    workPhone
            );
        }
    }

}
