package dk.workkit.dto;

import dk.workkit.domain.Project;
import dk.workkit.domain.Status;

import java.time.LocalDateTime;

public class ProjectDTO {

    private final String id;
    private final String initials;
    private final String name;
    private final String key;
    private final Status status;
    private final EmployeeDTO owner;
    private final LocalDateTime created;
    private final LocalDateTime modified;
    private final UserDTO createdBy;

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.initials = project.getInitials();
        this.name = project.getName();
        this.key = project.getKey();
        this.status = project.getStatus();
        this.owner = new EmployeeDTO(project.getOwner());
        this.created = project.getCreated();
        this.modified = project.getModified();
        this.createdBy = new UserDTO(project.getCreatedBy());
    }

    public String getId() {
        return id;
    }

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public Status getStatus() {
        return status;
    }

    public EmployeeDTO getOwner() {
        return owner;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public UserDTO getCreatedBy() {
        return createdBy;
    }
}
