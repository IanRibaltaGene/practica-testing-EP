package data;

import exception.NullSignatureException;

import java.util.Arrays;

final public class DigitalSignature {

    private final byte[] digitalSignature;


    public DigitalSignature(byte[] digitalSignature) throws NullSignatureException {
        if(digitalSignature == null){
            throw new NullSignatureException("Digital signature cannot be null");
        }
        this.digitalSignature = digitalSignature;
    }

    public byte[] getDigitalSignature() {
        return digitalSignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DigitalSignature that = (DigitalSignature) o;

        return Arrays.equals(getDigitalSignature(), that.getDigitalSignature());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getDigitalSignature());
    }
}
