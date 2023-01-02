package citizenmanagementplatform;

import data.Goal;
import data.Nif;
import data.SmallCode;
import data.goalTypes;
import exception.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.rmi.ConnectException;
import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

//TODO Create pertinent test doubles in this test package
class UnifiedPlatformTest {
    private UnifiedPlatform platform;
    @BeforeEach
    void setUp() {
        platform = new UnifiedPlatform();
    }

    @AfterEach
    void tearDown() {
        platform = null;
    }

    @Test
    void selectEvent() {
        assertEquals("Menu", platform.getSection());
        platform.selectJusMin();
        assertEquals("Menu > Justice Minister", platform.getSection());
        platform.selectProcedures();
        assertEquals("Menu > Justice Minister > Procedures", platform.getSection());
        platform.selectCriminalReportCertf();
        assertEquals("Menu > Justice Minister > Procedures > CriminalReportCertf", platform.getSection());

    }

    @Test
    void selectAuthMethod() throws WrongFormatNifException, NullNifException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException {
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        assertEquals(Byte.valueOf("0"), platform.getAuthMethod());

    }

    @Test
    void enterNIFandPINobtAuth() throws WrongFormatNifException, NullNifException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        assertTrue(platform.getProcStatusInProcedure());
    }

    @Test
    void enterNIFandPINobtNoAuth() throws WrongFormatNifException, NullNifException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        platform.setCertificationAuth(new StubCertificationAuthorityFalse());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        assertFalse(platform.getProcStatusInProcedure());

    }


    @Test
    void enterPINCheck() throws WrongFormatNifException, NullNifException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, WrongFormatSmallCodeException, NullCodeException, NotValidPINException {

        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");

        //PASOS REALITZATS TEORICAMENT AL ACABAR
        HashMap<Integer, Boolean> steps = new HashMap<>();
        steps.put(0,true);
        steps.put(1,true);

        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        assertEquals(steps, platform.getProcStatusSteps());
        assertTrue(platform.getProcStatusInProcedure());
    }

    @Test
    void enterPINNoCheck() throws IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NotValidPINException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        platform.setCertificationAuth(new StubCertificationAuthorityTrueNoCheck());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        assertFalse(platform.getProcStatusInProcedure());
    }

    @Test
    void enterFormGPDVerified() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, NullGoalException, IncompleteFormException, IncorrectVerificationException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);

        HashMap<Integer, Boolean> steps = new HashMap<>();
        steps.put(0,true);
        steps.put(1,true);
        steps.put(2, true);

        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        assertEquals(steps, platform.getProcStatusSteps());

    }

    @Test
    void enterFormGPDNotVerified() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, NullGoalException, IncompleteFormException, IncorrectVerificationException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);

        platform.setGpd(new StubGPDFalse());
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        assertFalse(platform.getProcStatusInProcedure());
    }

    @Test
    void enterNullForm() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, NullGoalException, IncompleteFormException, IncorrectVerificationException {
        assertThrows(NullPointerException.class,
                    () -> platform.enterForm(null, null)
        );
    }

    @Test
    void enterIncompleteForm() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);

        platform.setGpd(new StubGPDFalse());
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        assertThrows(IncompleteFormException.class,
                () -> platform.enterForm(null, null)
        );
    }
    @Test
    void enterCardDataNotReady() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException, NotValidPaymentDataException, InsufficientBalanceException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);
        CreditCard card = new CreditCard(nif,"1111111111111111", date, code);

        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        assertThrows(ProceduralException.class,
                () -> platform.enterCardData(null)
        );

    }
    @Test
    void enterCardDataNull() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException, NotValidPaymentDataException, InsufficientBalanceException {
        assertThrows(NullPointerException.class,
                () -> platform.enterCardData(null)
        );
    }

    @Test
    void enterCardDataIncomplete() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);
        CreditCard card = new CreditCard(nif,"1111111111111111", date, code);

        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        platform.realizePayment();
        assertThrows(IncompleteFormException.class,
                () -> platform.enterCardData(null)
        );
    }

    @Test
    void enterCardDataCASDenied() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException, NotValidPaymentDataException, InsufficientBalanceException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);
        CreditCard card = new CreditCard(nif,"1111111111111111", date, code);

        platform.setCas(new StubCASFalse());
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        platform.realizePayment();
        platform.enterCardData(card);
        assertFalse(platform.getProcStatusInProcedure());


    }
    @Test
    void enterCardDataCASApproved() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException, NotValidPaymentDataException, InsufficientBalanceException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);
        CreditCard card = new CreditCard(nif,"1111111111111111", date, code);

        HashMap<Integer, Boolean> steps = new HashMap<>();
        steps.put(0,true);
        steps.put(1,true);
        steps.put(2, true);
        steps.put(3, true);

        platform.setCas(new StubCASTrue());
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        platform.realizePayment();
        platform.enterCardData(card);
        assertEquals(steps, platform.getProcStatusSteps());
    }

    @Test
    void obtainCertificateJusticeFalse() throws WrongFormatNifException, NullNifException, WrongFormatSmallCodeException, NullCodeException, NullGoalException, IncorrectValDateException, NifNotRegisteredException, ProceduralException, AnyMobileRegisteredException, ConnectException, NotValidPINException, IncompleteFormException, IncorrectVerificationException, NotValidPaymentDataException, InsufficientBalanceException, DigitalSignatureException, BadPathException {
        Nif nif = new Nif("00281847M");
        Date date = new Date();
        SmallCode code = new SmallCode("123");
        Goal goal = new Goal(goalTypes.GAMESECTOR);
        CreditCard card = new CreditCard(nif,"1111111111111111", date, code);

        HashMap<Integer, Boolean> steps = new HashMap<>();
        steps.put(0,true);
        steps.put(1,true);
        steps.put(2, true);
        steps.put(3, true);

        platform.setCas(new StubCASTrue());
        platform.setCertificationAuth(new StubCertificationAuthorityTrue());
        platform.setGpd(new StubGPDTrue());
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(Byte.valueOf("0"));
        platform.enterNIFandPINobt(nif, date);
        platform.enterPIN(code);
        platform.enterForm(new Citizen(nif,"","",""), goal);
        platform.realizePayment();
        platform.enterCardData(card);
        assertThrows(NullPointerException.class,
                () -> platform.obtainCertificate()
        );

    }

}