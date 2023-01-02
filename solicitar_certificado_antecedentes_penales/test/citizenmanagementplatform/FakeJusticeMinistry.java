package citizenmanagementplatform;

import data.DigitalSignature;
import data.Goal;
import exception.DigitalSignatureException;
import publicadministration.Citizen;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;
import services.JusticeMinistry;

import java.rmi.ConnectException;

public class FakeJusticeMinistry implements JusticeMinistry {
    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException {
        byte[] dsBytes = {0,1};
        DigitalSignature ds;
        try {
            ds = new DigitalSignature(dsBytes);
            return new CriminalRecordCertf(persD.getNif(),persD.getName(),g,ds,new CrimConvictionsColl());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
