package calc.backend.impl;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

@Test
public class MathOperatorImplTests {
    private MathOperatorImpl mathOperatorImpl = new MathOperatorImpl();

    public void checkAddition_success() throws Exception {
        double returnVal = mathOperatorImpl.doMath(3, 4, "+");
        assertEquals(returnVal, 7, "Should add successfully");
    }

    public void checkSubtraction_success() throws Exception {
        double returnVal = mathOperatorImpl.doMath(6, 4, "-");
        assertEquals(returnVal, 2, "Should subtract successfully");
    }

    public void checkDivision_success() throws Exception {
        double returnVal = mathOperatorImpl.doMath(10, 2, "/");
        assertEquals(returnVal, 5, "Should divide successfully");
    }

    public void checkMultiplication_success() throws Exception {
        double returnVal = mathOperatorImpl.doMath(3, 4, "*");
        assertEquals(returnVal, 12, "Should multiply successfully");
    }
}
