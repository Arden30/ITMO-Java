package exceptions;

/**
 * Exception for the case of absence of given ID in all elements
 */
public class NoSuchIDException extends Exception{
    public NoSuchIDException(String message) {
        super(message);
    }
}
