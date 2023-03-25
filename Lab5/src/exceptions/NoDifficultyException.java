package exceptions;

/**
 * Exception for the case of absence of difficulty in all elements
 */
public class NoDifficultyException extends Exception{
    public NoDifficultyException(String message) {
        super(message);
    }
}
