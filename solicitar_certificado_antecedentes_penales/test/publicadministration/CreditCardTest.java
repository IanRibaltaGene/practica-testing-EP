package publicadministration;

import data.Nif;
import data.SmallCode;
import exception.NullCodeException;
import exception.NullNifException;
import exception.WrongFormatNifException;
import exception.WrongFormatSmallCodeException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {

    private static Nif nif;
    private static String cardNumb;
    private static Date expirDate;
    private static SmallCode svc;
    private static CreditCard creditCard;

    @BeforeAll
    static void setUp() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException {
        nif = new Nif("32181154Z");
        cardNumb = "4532977886386158";
        expirDate = new Date(1809172800);
        svc = new SmallCode("950");
        creditCard = new CreditCard(nif, cardNumb, expirDate, svc);
    }

    @Test
    void constructorNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> new CreditCard(null, null, null, null)
                );
        assertThrows(NullPointerException.class,
                () -> new CreditCard(null, cardNumb, expirDate, svc)
                );
        assertThrows(NullPointerException.class,
                () -> new CreditCard(nif, null, expirDate, svc)
                );
        assertThrows(NullPointerException.class,
                () -> new CreditCard(nif, cardNumb, null, svc)
                );
        assertThrows(NullPointerException.class,
                () -> new CreditCard(nif, cardNumb, expirDate, null)
                );
    }
    @Test
    void getNif() {
        assertEquals(nif, creditCard.getNif());
    }

    @Test
    void getCardNumb() {
        assertEquals(cardNumb, creditCard.getCardNumb());
    }

    @Test
    void getExpirDate() {
        assertEquals(expirDate, creditCard.getExpirDate());
    }

    @Test
    void getSvc() {
        assertEquals(svc, creditCard.getSvc());
    }

    @Test
    void testToString() {
        assertEquals("CreditCard{" +
                "nif=" + nif +
                ", cardNumb='" + cardNumb + '\'' +
                ", expirDate=" + expirDate +
                ", svc=" + svc +
                '}', creditCard.toString());
    }
}