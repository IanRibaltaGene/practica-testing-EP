package data;

import exception.WrongFormatCVSException;

final public class SmallCode {
    //Three digit code
    private final String cvs;

    public SmallCode(String code) throws WrongFormatCVSException {
        if(CorrectCode(code)){
            this.cvs = code;
        }else{
            throw new WrongFormatCVSException("Code cvs has to be exactly 3 digits");
        }
    }

    //Check the code contains only 3 digits
    private boolean CorrectCode (String code){
        return (code.length() == 3) && code.matches("[0-9]+");
    }

    public String getCvs(){
        return cvs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallCode smallCode = (SmallCode) o;

        return getCvs().equals(smallCode.getCvs());
    }

    @Override
    public int hashCode() {
        return getCvs().hashCode();
    }

    @Override
    public String toString() {
        return "SmallCode{" +
                "cvs='" + cvs + '\'' +
                '}';
    }
}
