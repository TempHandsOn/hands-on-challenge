import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandsOn2Tests {
    @Test
    void HandsOn2Test1Pass() {
        HandsOn2 test1 = new HandsOn2();
        test1.setTargetNumber(16);
        test1.setExpressionValues(new Integer[]{1, 3, 4, 5});
        assertEquals("16 = (((1+3)*5)-4)", test1.startExpressionResolution());
    }

    @Test
    void HandsOn2Test2Pass() {
        HandsOn2 test2 = new HandsOn2();
        test2.setTargetNumber(20);
        test2.setExpressionValues(new Integer[]{15, 4, 5, 5});
        assertEquals("20 = (((15-5)-5)*4)", test2.startExpressionResolution());
    }

    @Test
    void HandsOn2Test3Pass() {
        HandsOn2 test3 = new HandsOn2();
        test3.setTargetNumber(400);
        test3.setExpressionValues(new Integer[]{5, 80, 10, 10});
        assertEquals("400 = (((5*80)-10)+10)", test3.startExpressionResolution());
    }

    @Test
    void HandsOn2Test4Fail() {
        HandsOn2 test4 = new HandsOn2();
        test4.setTargetNumber(400);
        test4.setExpressionValues(new Integer[]{5, 80, 5, 10});
        assertEquals("The target number cannot be achieved with the 4 numbers supplied",
                test4.startExpressionResolution());
    }
}
