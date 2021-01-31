package dk.workkit.interfaces;

import dk.workkit.exceptions.repository.RepositoryException;

public interface IntegrityErrorHandler {
    void handleIntegrityError(RepositoryException e);
}
