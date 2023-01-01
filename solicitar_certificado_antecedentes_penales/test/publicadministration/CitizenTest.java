package publicadministration;

import data.Nif;
import exception.NullNifException;
import exception.WrongFormatNifException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitizenTest {

    private static Nif nif;
    private static String name;
    private static String add;
    private static String mobile;
    private static Citizen citizenAll;

    @BeforeAll
    static void setUp() throws WrongFormatNifException, NullNifException {
        nif = new Nif("32181154Z");
        name = "Joe Doe";
        add = "Carrer de Francesc Bellapart, 1, Sabadell";
        mobile = "+34 973 90 09 45";
        citizenAll = new Citizen(nif, name, add, mobile);
    }

    @Test
    void constructorNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> {
                    Citizen citizen = new Citizen(null, null, null, null);
                });
        assertThrows(NullPointerException.class,
                () -> {
            Citizen citizen = new Citizen(null, name, add, mobile);
                });
        assertThrows(NullPointerException.class,
                () -> {
                    Citizen citizen = new Citizen(nif, null, add, mobile);
                });
        assertThrows(NullPointerException.class,
                () -> {
                    Citizen citizen = new Citizen(nif, name, null, mobile);
                });
        assertThrows(NullPointerException.class,
                () -> {
                    Citizen citizen = new Citizen(nif, name, add, null);
                });
    }

    @Test
    void getNif() {
        assertEquals(nif, citizenAll.getNif());
    }

    @Test
    void getName() {
        assertEquals("Joe Doe", citizenAll.getName());
    }

    @Test
    void getAddress() {
        assertEquals("Carrer de Francesc Bellapart, 1, Sabadell", citizenAll.getAddress());
    }

    @Test
    void getMobileNumb() {
        assertEquals("+34 973 90 09 45", citizenAll.getMobileNumb());
    }

    @Test
    void testToString() {
        assertEquals("Citizen{" +
                "nif=" + nif +
                ", name='" + name + '\'' +
                ", address='" + add + '\'' +
                ", mobileNumb='" + mobile + '\'' +
                '}', citizenAll.toString());
    }
}