package dk.workkit.interfaces;

import dk.workkit.exceptions.validation.ValidationException;

public interface Request<T> {
    T validate() throws ValidationException;
}
