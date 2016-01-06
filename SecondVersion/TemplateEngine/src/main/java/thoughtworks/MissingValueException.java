package thoughtworks;

public class MissingValueException extends RuntimeException {
    @Override
    public String getMessage() {
        return "missing value";
    }
}
