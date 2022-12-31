package data;

import exception.NullSignatureException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {

    private static DigitalSignature signature;
    private static byte[] byteArray;
    private static byte[] byteArrayDifferent;
    private static byte[] byteArraySame;

    @BeforeAll
    static void setUp() throws NullSignatureException {
        byteArray = "asdasd".getBytes();
        byteArraySame = "asdasd".getBytes();
        byteArrayDifferent = "asdasds".getBytes();
        signature = new DigitalSignature(byteArray);
    }

    @Test
    void constructorNullException(){
        Throwable nullException = assertThrows(NullSignatureException.class,
                () -> {
            DigitalSignature signature = new DigitalSignature(null);
                });

        assertEquals("Digital signature cannot be null", nullException.getMessage());
    }

    @Test
    void getDigitalSignatureEqualObject() {
        //Same object
        assertEquals(byteArray, signature.getDigitalSignature());
    }
    @Test
    void getDigitalSignatureEqualContent() {
        //Same content
        assertArrayEquals(byteArraySame,signature.getDigitalSignature());
        assertArrayEquals(byteArray,signature.getDigitalSignature());
    }
    @Test
    void getDigitalSignatureNotEqualObject(){
        //Different object
        assertNotEquals(byteArraySame, signature.getDigitalSignature());
        assertNotEquals(byteArrayDifferent, signature.getDigitalSignature());
    }
    @Test
    void getDigitalSignatureNotEqualContent(){
        //Different content
        assertFalse(Arrays.equals(byteArrayDifferent, signature.getDigitalSignature()));
    }
}