package exceptions;

/**
 * Exception for the case of empty collection
 */
public class CollectionIsEmptyException extends Exception{
    public CollectionIsEmptyException(String message) {
        super(message);
    }
}
