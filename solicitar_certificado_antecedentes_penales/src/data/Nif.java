package data;

import exception.NullNifException;
import exception.WrongFormatNifException;

/**
 * Essential data classes
 */
final public class Nif {
    // The tax identification number in the Spanish state.
    private final String nif;
    public Nif (String code) throws NullNifException, WrongFormatNifException {
        if(code == null){
            throw new NullNifException("Nif must not be null");
        }
        if(!isValidNif(code)){
            throw new WrongFormatNifException("This NIF does not follow the correct format");
        }
        this.nif = code;
    }

    public static boolean isValidNif(String niff){
        if (niff.length() != 9) {
            return false;
        }
        String numbers;
        char controlLetter;
        char type = niff.charAt(0);
        if (type == 'K' || type == 'L' || type == 'M' || type == 'X' || type == 'Y' || type == 'Z') {
            numbers = niff.substring(1, 8);
            controlLetter = niff.charAt(8);
        } else if(!Character.isDigit(type)){
            return false;
        }else{
            numbers = niff.substring(0, 8);
            controlLetter = niff.charAt(8);
        }
        if(!Character.isLetter(controlLetter)){
            return false;
        }
        for(int i=0; i < numbers.length(); i++){
            if (!Character.isDigit(numbers.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    public String getNif () { return nif; }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }
    @Override
    public int hashCode () { return nif.hashCode(); }
    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }
}
