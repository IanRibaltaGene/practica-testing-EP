package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

public class CardPayment {
    // The information associated to the payment realized via internet
    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal importPayment; // The import of the payment    import-->importPayment
    public CardPayment (Nif nif, BigDecimal imp) throws NullPointerException {
        if(nif == null || imp == null){
            throw new NullPointerException("Arguments should not be null");
        }
        this.nif = nif;
        this.importPayment = imp;
        this.reference = generateUniqueId();
        this.date = new Date();
    }// Initializes attributes

    //Unlikely to repeat ID
    private String generateUniqueId() {
        SecureRandom random = new SecureRandom();
        BigInteger bigInt = new BigInteger(130, random);
        return bigInt.toString().substring(0, 23);
    }

    // the getters
    public String getReference() {
        return reference;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getImportPayment() {
        return importPayment;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "reference='" + reference + '\'' +
                ", nif=" + nif +
                ", date=" + date +
                ", importPayment=" + importPayment +
                '}';
    }
}
