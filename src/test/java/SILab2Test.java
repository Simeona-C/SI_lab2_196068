import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    private final SILab2 obj = new SILab2();

    @Test
    void function_MultipleCondition() {
        RuntimeException resultingException;
        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(-1, 0, 0))));
        assertEquals(resultingException.getMessage(), "The hours are smaller than the minimum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(25, 0, 0))));
        assertEquals(resultingException.getMessage(), "The hours are grater than the maximum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(0, -1, 0))));
        assertEquals(resultingException.getMessage(), "The minutes are not valid!");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(0, 60, 0))));
        assertEquals(resultingException.getMessage(), "The minutes are not valid!");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(0, 0, 60))));
        assertEquals(resultingException.getMessage(), "The seconds are not valid");

        assertEquals(Arrays.asList(0), obj.function(Arrays.asList(new Time(0, 0, 0))));
        assertEquals(Arrays.asList(24*3600), obj.function(Arrays.asList(new Time(24, 0, 0))));

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(24, 0, 1))));
        assertEquals(resultingException.getMessage(), "The time is greater than the maximum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(24, 1, 0))));
        assertEquals(resultingException.getMessage(), "The time is greater than the maximum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(24, 0, 1))));
        assertEquals(resultingException.getMessage(), "The time is greater than the maximum");
    }

    @Test
    void function_EveryBranch() {
        RuntimeException resultingException;

        assertEquals(new ArrayList<Integer>(), obj.function(new ArrayList<Time>()));

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(-1, 0, 0))));
        assertEquals(resultingException.getMessage(), "The hours are smaller than the minimum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(25, 0, 0))));
        assertEquals(resultingException.getMessage(), "The hours are grater than the maximum");

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(1, -1, 0))));
        assertEquals(resultingException.getMessage(), "The minutes are not valid!");

        assertEquals(Arrays.asList(3600), obj.function(Arrays.asList(new Time(1, 0, 0))));

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(1, 0, -1))));
        assertEquals(resultingException.getMessage(), "The seconds are not valid");

        assertEquals(Arrays.asList(24*3600), obj.function(Arrays.asList(new Time(24, 0, 0))));

        resultingException = assertThrows(RuntimeException.class, () -> obj.function(Arrays.asList(new Time(24, 1, 0))));
        assertEquals(resultingException.getMessage(), "The time is greater than the maximum");
    }
}