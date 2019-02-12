import org.junit.ComparisonFailure;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.model.TestTimedOutException;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

public class DriverTest {

    @Rule
    public Timeout globalTimeout = Timeout.millis(900);

    Driver jeff = new Driver ("jeff",141);

    @Test   //testing name which should pass
    public void testDriverName()
    {
        assertEquals("jeff", jeff.getDriverName());
    }

    @Test  (expected=ComparisonFailure.class) //testing name which should fail but exception expected
    public void testDriverNameFail()
    {
        assertEquals("larry", jeff.getDriverName());
    }

    @Test       //testing driver number which should produce a pass
    public void testDriverNumber()
    {
        assertEquals(141,jeff.getDriverNum());
    }

    @Test  (expected=IllegalArgumentException.class)     //testing driver number which should produce a fail as its below 100 but exception expected
    public void testDriverNumberFail()
    {
        Driver larry = new Driver("larry",57);
        assertEquals(57,larry.getDriverNum());
    }

    @Test   (expected = AssertionError.class)                  //testing driver number which should produce a fail, it wont match the expected result
    public void testDriverNumberFail2()
    {
        assertEquals(527,jeff.getDriverNum());
    }

    @Test
    public void testBannedStatus()
    {
        assertFalse(jeff.check_status());
    }

    @Test
    public void waitTillTested()                //is supposed to error
    {
        jeff.waitTillbanned();
    }
}