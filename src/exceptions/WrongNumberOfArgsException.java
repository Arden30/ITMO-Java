package exceptions;

/**
 * Exception for the case of wrong number of the args given to a command
 */
public class WrongNumberOfArgsException extends Exception{
    public WrongNumberOfArgsException(String message) {
        super(message);
    }
}
