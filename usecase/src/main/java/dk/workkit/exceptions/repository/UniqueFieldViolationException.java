package dk.workkit.exceptions.repository;

public class UniqueFieldViolationException extends RepositoryException {
    public UniqueFieldViolationException(String message) {
        super(message);
    }

    public UniqueFieldViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
