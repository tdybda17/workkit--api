package dk.workkit.memcache;

public class CacheMissException extends RuntimeException {
    public CacheMissException() {
    }

    public CacheMissException(String message) {
        super(message);
    }
}
