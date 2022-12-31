package exception;

public class WrongFormatPasswordException extends Exception {
    public WrongFormatPasswordException(String message){
        super(message);
    }
}
