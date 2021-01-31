package dk.workkit.dto;

import dk.workkit.domain.Employee;

public class EmployeeDTO {

    private String id;
    private String initials;
    private String workPhone;
    private UserDTO user;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.initials = employee.getInitials();
        this.workPhone = employee.getWorkPhone();
        this.user = new UserDTO(employee.getUser());
    }

    public String getId() {
        return id;
    }

    public String getInitials() {
        return initials;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public UserDTO getUser() {
        return user;
    }
}
