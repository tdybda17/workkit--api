package dk.workkit.usecases.createproject;

import dk.workkit.dto.ProjectDTO;
import dk.workkit.interfaces.ForbiddenHandler;
import dk.workkit.interfaces.IntegrityErrorHandler;
import dk.workkit.interfaces.UnauthorizedHandler;
import dk.workkit.interfaces.ValidationErrorHandler;

public interface CreateProjectHandler extends
        UnauthorizedHandler,
        ForbiddenHandler,
        ValidationErrorHandler,
        IntegrityErrorHandler {
    void handleAlreadyExists();
    void handleSuccess(ProjectDTO projectDTO);
}
