package data;

import exception.NullCodeException;
import exception.WrongFormatSmallCodeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallCodeTest {

    private static SmallCode smallCodeDifferent;
    private static SmallCode smallCodeSame;

    @BeforeAll
    static void setUp() throws WrongFormatSmallCodeException, NullCodeException {
        smallCodeDifferent = new SmallCode("123");
        smallCodeSame = new SmallCode("111");
    }


    @Test
    void constructorNullException(){
        Throwable nullException = assertThrows(NullCodeException.class,
                () -> {
                    SmallCode smallCode = new SmallCode(null);
                });

        assertEquals("Code must not be null", nullException.getMessage());
    }

    @Test
    void constructorExceptionLength(){
        Throwable moreLengthException = assertThrows(WrongFormatSmallCodeException.class,
                () -> {
                    SmallCode smallCode = new SmallCode("aaaaa");
                });
        Throwable lessLengthException = assertThrows(WrongFormatSmallCodeException.class,
                () -> {
                    SmallCode smallCode = new SmallCode("aa");
                });

        assertEquals("The code has to be exactly 3 digits", moreLengthException.getMessage());
        assertEquals("The code has to be exactly 3 digits", lessLengthException.getMessage());
    }

    @Test
    void constructorExceptionNonDigits(){
        Throwable letterException = assertThrows(WrongFormatSmallCodeException.class,
                () -> {
                    SmallCode smallCode = new SmallCode("1a1");
                });
        Throwable lettersException = assertThrows(WrongFormatSmallCodeException.class,
                () -> {
                    SmallCode smallCode = new SmallCode("aaa");
                });

        assertEquals("The code has to be exactly 3 digits", letterException.getMessage());
        assertEquals("The code has to be exactly 3 digits", lettersException.getMessage());
    }

    @Test
    void getSmallCodeDifferentDigits(){
        assertEquals("123", smallCodeDifferent.getSmallCode());
        assertNotEquals("111", smallCodeDifferent.getSmallCode());
    }

    @Test
    void getSmallCodeSameDigits(){
        assertEquals("111", smallCodeSame.getSmallCode());
        assertNotEquals("123", smallCodeSame.getSmallCode());
    }
}