package publicadministration;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CrimConvictionTest {

    private static Date commit;
    private static String offense;
    private static String sentence;
    private static CrimConviction conviction;

    @BeforeAll
    static void setup(){
        commit = new Date();
        offense = "offense 1";
        sentence = "sentence 1";
        conviction = new CrimConviction(commit,offense,sentence);
    }

    @Test
    void constructorNullArgumentException() {
        assertThrows(NullPointerException.class,
                () -> new CrimConviction(null, null, null)
        );
        assertThrows(NullPointerException.class,
                () -> new CrimConviction(null, offense, sentence)
        );
        assertThrows(NullPointerException.class,
                () -> new CrimConviction(commit, null, sentence)
        );
        assertThrows(NullPointerException.class,
                () -> new CrimConviction(commit, offense, null)
        );
    }
    @Test
    void getCommitDate() {
        assertEquals(commit, conviction.getCommitDate());
    }

    @Test
    void getOffense() {
        assertEquals(offense, conviction.getOffense());
    }

    @Test
    void getSentence() {
        assertEquals(sentence, conviction.getSentence());
    }

    @Test
    void testToString() {
        assertEquals("CrimConviction{" +
                "commitDate=" + commit +
                ", offense='" + offense + '\'' +
                ", sentence='" + sentence + '\'' +
                '}', conviction.toString());
    }
}