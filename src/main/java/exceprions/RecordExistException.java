package exceprions;

public class RecordExistException extends RuntimeException{
    public RecordExistException(String message) {
        super(message);
    }
}
