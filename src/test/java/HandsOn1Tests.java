import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandsOn1Tests {
    @Test
    void HandsOn1Test1AlphaPass() {
        HandsOn1 test1 = new HandsOn1();
        test1.setSentence("this is is is a a test of of hands on on on one");
        test1.setAlphabetical(true);
        test1.setReverseAlphabetical(false);
        test1.processChallenge();
        Map<String, Integer> test1Result = test1.getAlphaCount();
        assertEquals(test1Result.get("this"), 1);
        assertEquals(test1Result.get("is"), 3);
        assertEquals(test1Result.get("a"), 2);
        assertEquals(test1Result.get("test"), 1);
        assertEquals(test1Result.get("of"), 2);
        assertEquals(test1Result.get("hands"), 1);
        assertEquals(test1Result.get("on"), 3);
        assertEquals(test1Result.get("one"), 1);
    }

    @Test
    void HandsOn1Test2ReverseAlphaPass() {
        HandsOn1 test2 = new HandsOn1();
        test2.setSentence("this is is is a a test of of hands on on on two");
        test2.setAlphabetical(false);
        test2.setReverseAlphabetical(true);
        test2.processChallenge();
        Map<String, Integer> test2Result = test2.getReverseAlphaCount();
        assertEquals(test2Result.get("this"), 1);
        assertEquals(test2Result.get("is"), 3);
        assertEquals(test2Result.get("a"), 2);
        assertEquals(test2Result.get("test"), 1);
        assertEquals(test2Result.get("of"), 2);
        assertEquals(test2Result.get("hands"), 1);
        assertEquals(test2Result.get("on"), 3);
        assertEquals(test2Result.get("two"), 1);
    }

    @Test
    void HandsOn1Test3CountPass() {
        HandsOn1 test3 = new HandsOn1();
        test3.setSentence("this is is is a a test of of hands on on on three");
        test3.setAlphabetical(false);
        test3.setReverseAlphabetical(false);
        test3.processChallenge();
        Map<String, Integer> test3Result = test3.getCount();
        assertEquals(test3Result.get("this"), 1);
        assertEquals(test3Result.get("is"), 3);
        assertEquals(test3Result.get("a"), 2);
        assertEquals(test3Result.get("test"), 1);
        assertEquals(test3Result.get("of"), 2);
        assertEquals(test3Result.get("hands"), 1);
        assertEquals(test3Result.get("on"), 3);
        assertEquals(test3Result.get("three"), 1);
    }
}
