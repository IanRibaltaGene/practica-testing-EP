package data;

import exception.NullNifException;
import exception.WrongFormatNifException;

import static org.junit.jupiter.api.Assertions.*;

class NifTest {

    @org.junit.jupiter.api.Test
    void ConstructorException() throws WrongFormatNifException, NullNifException {
        Throwable nullException = assertThrows(NullNifException.class,
                () -> {
                    Nif nif = new Nif(null);
        });
        Throwable formatExceptionLength = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("a");
        });
        Throwable formatExceptionDNI1 = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("111111111a");
        });
        Throwable formatExceptionDNI2 = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("111111111");
        });
        Throwable formatExceptionNIF = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("A1111111A");
        });
        Throwable formatExceptionNIFK = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("K11111111");
        });
        assertEquals("Nif must not be null", nullException.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionLength.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionDNI1.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionDNI2.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionNIF.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionNIFK.getMessage());
    }

}