package data;

import exception.NullPathException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocPathTest {

    private static DocPath pathOneChar;
    private static DocPath pathMultipleChar;

    @BeforeAll
    static void setUp() throws NullPathException {
        pathOneChar = new DocPath("a");
        pathMultipleChar = new DocPath("a1a/sw1");
    }

    @Test
    void constructorNullDocPath(){
        Throwable nullException = assertThrows(NullPathException.class,
                () -> {
                    DocPath path = new DocPath(null);
                });

        assertEquals("Document path parameter cannot be null", nullException.getMessage());
    }

    @Test
    void getDocPathOneChar() {
        assertEquals("a", pathOneChar.getDocPath());
        assertNotEquals("a/", pathOneChar.getDocPath());
    }

    @Test
    void getDocPathMultipleChar() {
        assertEquals("a1a/sw1", pathMultipleChar.getDocPath());
        assertNotEquals("a", pathMultipleChar.getDocPath());
    }
}