package publicadministration;

import data.Nif;
import data.SmallCode;

import java.util.Date;

public class CreditCard {
    // The payment information for using the card via internet
    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc; // The Safe Verification Code
    public CreditCard (Nif nif, String cNum, Date d, SmallCode c) throws NullPointerException{
        if(nif == null || cNum == null || d == null || c == null){
            throw new NullPointerException("Arguments should not be null");
        }
        this.nif = nif;
        this.cardNumb = cNum;
        this.expirDate = d;
        this.svc = c;
    }// Initializes attributes
    // the getters
    public Nif getNif() {
        return nif;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "nif=" + nif +
                ", cardNumb='" + cardNumb + '\'' +
                ", expirDate=" + expirDate +
                ", svc=" + svc +
                '}';
    }
}
