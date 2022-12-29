package exception;

public class NotValidPaymentDataException extends Exception{
    public NotValidPaymentDataException(String message){
        super(message);
    }
}
