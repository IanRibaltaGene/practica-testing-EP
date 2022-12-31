package data;

import exception.NullGoalException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoalTest {
    @Test
    void constructorNullException() {
        Throwable nullException = assertThrows(NullGoalException.class,
                () -> {
                    Goal goal = new Goal(null);
                });

        assertEquals("Type must not be null", nullException.getMessage());
    }
}