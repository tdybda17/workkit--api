package dk.workkit.exceptions.repository;

public class ConstraintViolationException extends RepositoryException {
    public ConstraintViolationException(String message) {
        super(message);
    }

    public ConstraintViolationException(String message, Throwable cause) {
        super(message, cause);
    }
}
