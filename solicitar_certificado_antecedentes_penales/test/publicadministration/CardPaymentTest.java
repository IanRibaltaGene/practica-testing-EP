package publicadministration;

import data.Nif;
import exception.NullNifException;
import exception.WrongFormatNifException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CardPaymentTest {

    private static CardPayment cardPayment;
    private static Nif nif;
    private static BigDecimal importPayment;
    private static Date expectedDate;
    @BeforeAll
    static void setup() throws WrongFormatNifException, NullNifException {
        nif = new Nif("32181154Z");
        importPayment = new BigDecimal(123);
        cardPayment = new CardPayment(nif,importPayment);
        expectedDate = new Date();
    }

    @Test
    void constructorNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> new CardPayment(null, null)
        );
        assertThrows(NullPointerException.class,
                () -> new CardPayment(null, importPayment)
        );
        assertThrows(NullPointerException.class,
                () -> new CardPayment(nif, null)
        );
    }

    @Test
    void getReference() {
        assertTrue(cardPayment.getReference().matches("\\d{23}"));
    }

    @Test
    void getNif() {
        assertEquals(nif, cardPayment.getNif());
    }

    @Test
    void getDate() {
        assertEquals(expectedDate,cardPayment.getDate());
    }

    @Test
    void getImportPayment() {
        assertEquals(importPayment,cardPayment.getImportPayment());
    }

    @Test
    void testToString() {
        assertEquals("CardPayment{" +
                "reference='" + cardPayment.getReference() + '\'' +
                ", nif=" + nif +
                ", date=" + cardPayment.getDate() +
                ", importPayment=" + importPayment +
                '}', cardPayment.toString());
    }
}