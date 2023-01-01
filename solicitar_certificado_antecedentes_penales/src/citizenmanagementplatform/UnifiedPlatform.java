package citizenmanagementplatform;

import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
import exception.*;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import services.CAS;
import services.CertificationAuthority;
import services.GPD;
import services.JusticeMinistry;

import java.rmi.ConnectException;
import java.util.Date;
import java.util.HashMap;

public class UnifiedPlatform {
    //TODO ??? // The class members
    private CertificationAuthority certificationAuth;
    private GPD gpd;
    private JusticeMinistry justiceMinistry;
    private CAS cas;


    private Procedure procStatus;
    private String section;
    private static class Procedure {

        private boolean inProcedure;
        public Citizen citizen;
        public boolean readyToPay;
        public HashMap<Integer,Boolean> procedureSteps;
        private Byte authType;
        public static  int lastTransaction = 0;
        public Procedure(){
            this.procedureSteps = new HashMap<Integer,Boolean>();
            this.readyToPay = false;
            this.inProcedure = false;
        }
        public void setAuthType(Byte authType) {
            this.authType = authType;
        }

        public void setCitizen(Citizen citizen) {
            this.citizen = citizen;
        }
        private void verifySteps(int index) throws ProceduralException {
            if(!inProcedure) throw new ProceduralException("Must select a procedure");
            if (!authType.equals((byte) 0)) throw new ProceduralException("The authentication type its incorrect");
            for (int i = 0; i < index; i++) {
                if(!procedureSteps.containsKey(i) || !procedureSteps.get(i)){
                    throw new ProceduralException(getError(i));
                }
            }

        }
        private String getError(int i) {
            switch (i) {
                case 0 -> {
                    return "PIN not sent correctly";
                }
                case 1 -> {
                    return "PIN hasn't been verified correctly";
                }
                case 2 -> {
                    return "Form not verified correctly";
                }
                case 3 -> {
                    return "";
                }
                default -> { return "Unexpected error" ;}

            }
        }

    }
    public UnifiedPlatform(){
        section = "Menu";
    }
    // Input events
    public void selectJusMin () {
        section  = " > Justice Minister";
    }
    public void selectProcedures () {
        section  += " > Procedures";
    }
    public void selectCriminalReportCertf () {
        section  += " > CriminalReportCertf";
        procStatus = new Procedure();
        procStatus.inProcedure = true;

    }
    public void selectAuthMethod (byte opc) {
        procStatus.setAuthType(opc);
    }
    public void enterNIFandPINobt (Nif nif, Date valDate) throws
            NifNotRegisteredException, IncorrectValDateException,
            AnyMobileRegisteredException, ConnectException,ProceduralException
    {
        procStatus.verifySteps(0);
        if(certificationAuth.sendPIN(nif,valDate)) {
            System.out.println("PIN has been sent correctly");
            procStatus.setCitizen(new Citizen(nif,"","",""));
            procStatus.procedureSteps.put(0,true);
        } else{
            resetProcedure("Has been an error sending the PIN");
        }
    }
    public void enterPIN (SmallCode pin) throws
            NotValidPINException, ConnectException,ProceduralException
    {
        procStatus.verifySteps(1);
        if(certificationAuth.checkPIN(procStatus.citizen.getNif(),pin)){
            System.out.println("PIN has been verified correctly\n"+
                    "Please contact GPD to fill a personal data form");
            procStatus.procedureSteps.put(1,true);
        }else{
            resetProcedure("Has been an error verifying the PIN");
        }
    }
    private void resetProcedure(String message) {
        System.out.println(message);
        procStatus =new Procedure();
    }

    private void enterForm (Citizen citz, Goal gl) throws
            IncompleteFormException, IncorrectVerificationException,
            ConnectException, ProceduralException {

        procStatus.verifySteps(1);
        Citizen cit;
        Goal goal;
        try{
            cit  = new Citizen(citz.getNif(),citz.getName(), citz.getAddress(), citz.getMobileNumb());
            goal  = new Goal(gl.getType());
        }catch (Exception e){
            throw new IncompleteFormException(e.getMessage());
        }
        procStatus.setCitizen(cit);

        if(gpd.verifyData(cit,goal)) {
            System.out.println("Form verified correctly\n"+
                    "The procedure has a price of 3.86€.");
            procStatus.procedureSteps.put(2,true);
        }else{
            resetProcedure("Has been an error verifying the form");
        }

    }
    private void realizePayment () {
        procStatus.readyToPay = true;
    }
    private void enterCardData (CreditCard cardD) throws
            IncompleteFormException, NotValidPaymentDataException,
            InsufficientBalanceException, ConnectException, ProceduralException {
        procStatus.verifySteps(2);
        if(!procStatus.readyToPay) throw new ProceduralException("Not ready to pay");
        CreditCard credC;
        try{
            credC = new CreditCard(cardD.getNif(),cardD.getCNum(), cardD.getDate(),cardD.getN());
        }
        catch (Exception e){
            throw new IncompleteFormException(e.getMessage());
        }
        CardPayment cPay = new CardPayment(new Date());

    }
    private void obtainCertificate () throws
            BadPathException, DigitalSignatureException,
            ConnectException, ProceduralException {


        //TODO(. . .)
    }
    private void printDocument () throws
            BadPathException, PrintingException
    {
        //TODO(. . .)
    }

    //TODO(. . .) // The setter methods for injecting the dependences

    public void setCas(CAS cas) {
        this.cas = cas;
    }
    public void setCertificationAuth(CertificationAuthority certificationAuth) {
        this.certificationAuth = certificationAuth;
    }
    public void setGpd(GPD gpd) {
        this.gpd = gpd;
    }
    public void setJusticeMinistry(JusticeMinistry justiceMinistry) {
        this.justiceMinistry = justiceMinistry;
    }

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
