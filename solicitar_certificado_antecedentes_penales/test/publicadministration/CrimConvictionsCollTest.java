package publicadministration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CrimConvictionsCollTest {

    private static Date commit1;
    private static Date commit2;

    private static CrimConviction crimConviction1;
    private static CrimConviction crimConviction2;
    private static CrimConvictionsColl crimConvictionsColl;

    @BeforeAll
    static void setup(){
        commit1 = new Date(1010000);
        String offense = "offense 1";
        String sentence = "sentence 1";
        crimConviction1 = new CrimConviction(commit1,offense,sentence);

        commit2 = new Date(1000000);
        String sentence2 = "sentence 2";
        crimConviction2 = new CrimConviction(commit2,offense,sentence2);

        crimConvictionsColl = new CrimConvictionsColl();
        crimConvictionsColl.addCriminalConviction(crimConviction1);
        crimConvictionsColl.addCriminalConviction(crimConviction2);
    }

    @Test
    void getConvictions() {
        SortedMap<Date, CrimConviction> convictions;
        convictions = new TreeMap<>();
        convictions.put(crimConviction1.getCommitDate(), crimConviction1);
        convictions.put(crimConviction2.getCommitDate(), crimConviction2);

        assertEquals(convictions,crimConvictionsColl.getConvictions());
    }

    @Test
    void getCriminalConviction() {
        assertEquals(crimConviction1, crimConvictionsColl.getCriminalConviction(commit1));
        assertEquals(crimConviction2,crimConvictionsColl.getCriminalConviction(commit2));
    }
}