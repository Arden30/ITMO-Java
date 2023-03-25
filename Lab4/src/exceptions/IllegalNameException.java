package exceptions;

public class IllegalNameException extends IllegalArgumentException{
    public IllegalNameException(String message) {
        super(message);
    }
}
