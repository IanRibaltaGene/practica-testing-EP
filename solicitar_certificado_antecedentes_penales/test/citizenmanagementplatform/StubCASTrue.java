package citizenmanagementplatform;

import exception.InsufficientBalanceException;
import exception.NotValidPaymentDataException;
import publicadministration.CreditCard;
import services.CAS;

import java.math.BigDecimal;
import java.rmi.ConnectException;
import java.util.Date;

public class StubCASTrue implements CAS {
    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException {

        return true;
    }
}
