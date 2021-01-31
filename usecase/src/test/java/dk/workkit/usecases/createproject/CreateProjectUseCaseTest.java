package dk.workkit.usecases.createproject;

import dk.workkit.interfaces.Session;
import dk.workkit.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CreateProjectUseCaseTest {

    private Session session;
    private ProjectRepository repository;
    private CreateProjectHandler handler;
    private CreateProjectRequest request;
    private CreateProjectUseCase useCase;

    @BeforeEach
    void setUp() {
        session = mock(Session.class);
        repository = mock(ProjectRepository.class);
        handler = mock(CreateProjectHandler.class);
    }

    @Test
    void testWhenUserNotAuthenticated() {
        when(session.isAuthorized()).thenReturn(false);
        useCase = new CreateProjectUseCase(session, repository, request, handler);
        useCase.create();
        verify(handler, times(1)).handleUnauthorized();
        verifyNoMoreInteractions(handler);
    }


}