package tobeto.com.tobetobootcampproject.core.exceptions.types;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message) {
        super(message);
    }
}
