package data;

import exception.NullCodeException;
import exception.WrongFormatSmallCodeException;

final public class SmallCode {
    //Three digit code
    private final String smallCode;

    public SmallCode(String code) throws WrongFormatSmallCodeException, NullCodeException {
        if(code == null){
            throw new NullCodeException("Code must not be null");
        }
        if(correctCode(code)){
            this.smallCode = code;
        }else{
            throw new WrongFormatSmallCodeException("The code has to be exactly 3 digits");
        }
    }

    //Check the code only contains 3 digits
    private boolean correctCode (String code){
        return (code.length() == 3) && code.matches("\\d+");
    }

    public String getSmallCode(){
        return smallCode;
    }

    @Override
    public String toString() {
        return "SmallCode{" +
                "smallCode='" + smallCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallCode smallCode1 = (SmallCode) o;

        return getSmallCode().equals(smallCode1.getSmallCode());
    }

    @Override
    public int hashCode() {
        return getSmallCode().hashCode();
    }
}
