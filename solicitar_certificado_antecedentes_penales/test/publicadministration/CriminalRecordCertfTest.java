package publicadministration;

import data.DigitalSignature;
import data.Goal;
import data.Nif;
import data.goalTypes;
import exception.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CriminalRecordCertfTest {

    private static Nif nif;
    private static String name;
    private static Goal goal;
    private static DigitalSignature digSign;
    private static CrimConvictionsColl crimConvs;

    private static CriminalRecordCertf criminalRecordCertf;

    @BeforeAll
    static void setUp() throws WrongFormatNifException, NullNifException, NullSignatureException, NullPathException, NullGoalException {
        nif = new Nif("32181154Z");
        name = "Joe Doe";
        goal = new Goal(goalTypes.GAMESECTOR);
        byte[] byteArray = "asdasd".getBytes();
        digSign = new DigitalSignature(byteArray);
        CrimConviction crimConv = new CrimConviction(new Date(), "offense 1","sentence 1");
        crimConvs = new CrimConvictionsColl();
        crimConvs.addCriminalConviction(crimConv);
        criminalRecordCertf = new CriminalRecordCertf(nif,
                name, goal, digSign, crimConvs);
    }


    @Test
    void getNif() {
        assertEquals(nif, criminalRecordCertf.getNif());
    }

    @Test
    void getName() {
        assertEquals(name, criminalRecordCertf.getName());
    }

    @Test
    void getGoal() {
        assertEquals(goal, criminalRecordCertf.getGoal());
    }

    @Test
    void getDigSign() {
        assertEquals(digSign, criminalRecordCertf.getDigSign());
    }

    @Test
    void getCrimConvs() {
        assertEquals(crimConvs, criminalRecordCertf.getCrimConvs());
    }
}