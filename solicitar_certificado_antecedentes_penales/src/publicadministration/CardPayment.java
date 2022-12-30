package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.util.Date;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal importPayment; // The import of the payment import-->importPayment
    public CardPayment (Nif nif, BigDecimal imp, String reference, Nif nif1, Date date, BigDecimal importPayment) {
        //TODO(. . .)
        this.reference = reference;
        this.nif = nif1;
        this.date = date;
        this.importPayment = importPayment;
    }// Initializes attributes
    //TODO(. . .) // the getters
    @Override
    public String toString () {
        //TODO(. . .)
        return null;
    } // converts to String

}
