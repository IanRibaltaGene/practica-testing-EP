package citizenmanagementplatform;

import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
import exception.*;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.rmi.ConnectException;
import java.util.Date;

public class UnifiedPlatform {
    //TODO ??? // The class members
    // TODO ??? // The constructor/s
    // Input events
    public void selectJusMin () {
        //TODO . . .
    }
    public void selectProcedures () {
        //TODO . . .
    }
    public void selectCriminalReportCertf () {
        //TODO . . .
    }
    public void selectAuthMethod (byte opc) {
        //TODO . . .
    }
    public void enterNIFandPINobt (Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException
    {
        //TODO . . .
    }
    public void enterPIN (SmallCode pin) throws
            NotValidPINException, ConnectException
    {
        //TODO (. . .)
    }
    private void enterForm (Citizen citz, Goal goal) throws
            IncompleteFormException, IncorrectVerificationException,
            ConnectException
    {
        //TODO(. . .)
    }
    private void realizePayment () {
        //TODO(. . .)
    }
    private void enterCardData (CreditCard cardD) throws
            IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException
    {
        //TODO(. . .)
    }
    private void obtainCertificate () throws
            BadPathException, DigitalSignatureException,
            ConnectException
    {
        //TODO(. . .)
    }
    private void printDocument () throws
            BadPathException, PrintingException
    {
        //TODO(. . .)
    }

    //TODO(. . .) // The setter methods for injecting the dependences

    //TODO(. . .) // Other input events (not required) //Other internal operations (not required)
    private void registerPayment () {
        //TODO(. . .)
    }
    private void openDocument (DocPath path) throws BadPathException {
        //TODO(. . .)
    }
    private void printDocument (DocPath path) throws
            BadPathException, PrintingException
    {
        //TODO(. . .)
    }

}
