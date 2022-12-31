package data;

import exception.NullNifException;
import exception.WrongFormatNifException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NifTest {

    private static Nif nif1;
    private static Nif nifK;

    @BeforeAll
    static void setUp() throws WrongFormatNifException, NullNifException {
        nif1 = new Nif("11111111F");
        nifK = new Nif("K1111111A");
    }

    @Test
    void ConstructorExceptionNull(){
        Throwable nullException = assertThrows(NullNifException.class,
                () -> {
                    Nif nif = new Nif(null);
        });

        assertEquals("Nif must not be null", nullException.getMessage());
    }

    @Test
    void ConstructorExceptionLength(){
        Throwable formatExceptionLength = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("a");
                });
        Throwable formatExceptionLength2 = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("111111a");
                });

        assertEquals("This NIF does not follow the correct format", formatExceptionLength.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionLength2.getMessage());

    }

    @Test
    void ConstructorExceptionDNI(){
        Throwable formatExceptionDNI1 = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("111111111a");
                });
        Throwable formatExceptionDNI2 = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("111111111");
                });

        assertEquals("This NIF does not follow the correct format", formatExceptionDNI1.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionDNI2.getMessage());
    }

    @Test
    void ConstructorExceptionNIFNonDNI(){
        Throwable formatExceptionNIF = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("A1111111A");
                });
        Throwable formatExceptionNIFK = assertThrows(WrongFormatNifException.class,
                () -> {
                    Nif nif = new Nif("K11111111");
                });

        assertEquals("This NIF does not follow the correct format", formatExceptionNIF.getMessage());
        assertEquals("This NIF does not follow the correct format", formatExceptionNIFK.getMessage());
    }

    @Test
    void GetNIFNonDNI(){
        assertEquals("11111111F", nif1.getNif());
    }

    @Test
    void GetNIFDNI(){
        assertEquals("K1111111A", nifK.getNif());
    }

}