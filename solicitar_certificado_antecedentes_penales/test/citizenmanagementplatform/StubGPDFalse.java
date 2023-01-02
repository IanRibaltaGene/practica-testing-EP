package citizenmanagementplatform;

import data.Goal;
import exception.IncorrectVerificationException;
import publicadministration.Citizen;
import services.CertificationAuthority;
import services.GPD;

import java.rmi.ConnectException;

public class StubGPDFalse implements GPD {
    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        return false;
    }
}
