package publicadministration;

import data.Nif;
import exception.NullNifException;

public class Citizen {
    // Represents all the information required for a citizen
    private final Nif nif;
    private final String name;
    private final String address;
    private final String mobileNumb;

    //TODO(. . .) // Other additional information (not required)
    public Citizen (Nif nif, String name, String add, String mobile) throws NullPointerException {
        if(nif == null || name == null || add == null || mobile == null){
            throw new NullPointerException("Arguments should not be null");
        }
        this.nif = nif;
        this.name = name;
        this.address = add;
        this.mobileNumb = mobile;
    }// Initializes attributes

    // the getters
    public Nif getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return mobileNumb;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "nif=" + nif +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumb='" + mobileNumb + '\'' +
                '}';
    }
}
