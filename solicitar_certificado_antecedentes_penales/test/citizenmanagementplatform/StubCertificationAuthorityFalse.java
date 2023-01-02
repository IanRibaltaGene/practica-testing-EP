package citizenmanagementplatform;

import data.Nif;
import data.SmallCode;
import exception.AnyMobileRegisteredException;
import exception.IncorrectValDateException;
import exception.NifNotRegisteredException;
import exception.NotValidPINException;
import services.CertificationAuthority;

import java.rmi.ConnectException;
import java.util.Date;

public class StubCertificationAuthorityFalse implements CertificationAuthority {
    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        return false;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException {
        return false;
    }
}
