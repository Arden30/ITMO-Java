package common.exceptions;

/**
 * Exception which throws if element which was given is not minimal in the collection
 */
public class ElementIsNotMinException extends Exception{
    public ElementIsNotMinException(String message) {
        super(message);
    }
}
