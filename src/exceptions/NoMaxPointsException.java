package exceptions;

/**
 * Exception for the case of absence of max points in all elements
 */
public class NoMaxPointsException extends Exception{
    public NoMaxPointsException(String message) {
        super(message);
    }
}
