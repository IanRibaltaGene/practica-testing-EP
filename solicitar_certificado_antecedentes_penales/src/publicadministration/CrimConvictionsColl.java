package publicadministration;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

public class CrimConvictionsColl {
    // Represents the total criminal convictions registered for a citizen
    // Its components, that is, the set of criminal convictions
    private SortedMap<Date, CrimConviction> convictions;

    public CrimConvictionsColl (){
        this.convictions = new TreeMap<>();
    } // Initializes the object

    // the getters
    public SortedMap<Date, CrimConviction> getConvictions() {
        return convictions;
    }

    public void addCriminalConviction (CrimConviction crmC){
        convictions.put(crmC.getCommitDate(), crmC);
    }// Adds a criminal conviction  --> has to be void, if it was CrimConvictionsColl it could be without void.

    public CrimConviction getCriminalConviction (Date date){
        return convictions.get(date);
    }// Gets a specific criminal conviction by date

    @Override
    public String toString() {
        return "CrimConvictionsColl{" +
                "convictions=" + convictions +
                '}';
    }
}
