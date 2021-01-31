package dk.workkit.usecases.createproject;

import dk.workkit.domain.Project;
import dk.workkit.domain.User;
import dk.workkit.dto.ProjectDTO;
import dk.workkit.exceptions.repository.RepositoryException;
import dk.workkit.exceptions.validation.ValidationException;
import dk.workkit.interfaces.Session;
import dk.workkit.repositories.ProjectRepository;
import dk.workkit.tools.KeyGenerator;

public class CreateProjectUseCase {

    private final Session session;
    private final ProjectRepository repository;
    private final CreateProjectRequest request;
    private final CreateProjectHandler handler;

    public CreateProjectUseCase(
            Session session,
            ProjectRepository repository,
            CreateProjectRequest request,
            CreateProjectHandler handler) {
        this.session = session;
        this.repository = repository;
        this.request = request;
        this.handler = handler;
    }

    public void create() {
        if (!session.isAuthorized()) {
            handler.handleUnauthorized();
            return;
        }

        User user = session.getUser();
        if (!hasPermission(user)) {
            handler.handleForbidden();
            return;
        }

        try {
            Project.ProjectBuilder projectBuilder = request.validate();
            projectBuilder
                    .setCreatedBy(user)
                    .setKey(KeyGenerator.genKey(Project.class, projectBuilder.build()));

            Project project = repository.save(projectBuilder.build());
            handler.handleSuccess(new ProjectDTO(project));
        } catch (ValidationException e) {
            handler.handleValidationError(e);
        } catch (RepositoryException e) {
            handler.handleIntegrityError(e);
        }

    }

    private boolean hasPermission(User user) {
        return true;
    }

}
