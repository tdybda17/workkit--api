package dk.workkit.usecases.createproject;

import dk.workkit.domain.Employee;
import dk.workkit.domain.Project;
import dk.workkit.domain.Status;
import dk.workkit.interfaces.Request;
import dk.workkit.exceptions.validation.ValidationException;
import dk.workkit.tools.ValueExtractor;

import java.util.Map;

public class CreateProjectRequest implements Request<Project.ProjectBuilder> {

    private Map<String, Object> requestData;
    private String initials;
    private String name;
    private String statusId;
    private String ownerId;

    public CreateProjectRequest(Map<String, Object> requestData) {
        this.requestData = requestData;
        this.initials = ValueExtractor.getStringOrDefault(requestData, "initials");
        this.name = ValueExtractor.getStringOrDefault(requestData, "name");
        this.statusId = ValueExtractor.getStringOrDefault(requestData, "statusId");
        this.ownerId = ValueExtractor.getStringOrDefault(requestData, "ownerId");
    }

    @Override
    public Project.ProjectBuilder validate() throws ValidationException {
        return new Project.ProjectBuilder()
                .setInitials(initials)
                .setName(name)
                .setStatus(new Status.StatusBuilder().setId(statusId).build())
                .setOwner(new Employee.EmployeeBuilder().setId(ownerId).build());
    }

    public Map<String, Object> getRequestData() {
        return requestData;
    }

    public String getInitials() {
        return initials;
    }

    public String getName() {
        return name;
    }

    public String getStatusId() {
        return statusId;
    }

    public String getOwnerId() {
        return ownerId;
    }
}
