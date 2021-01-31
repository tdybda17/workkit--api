package dk.workkit.interfaces;

import dk.workkit.exceptions.validation.ValidationException;

public interface ValidationErrorHandler {
    void handleValidationError(ValidationException e);
}
