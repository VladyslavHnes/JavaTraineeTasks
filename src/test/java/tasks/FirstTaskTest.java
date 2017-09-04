package tasks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FirstTaskTest {

    @Test
    public void testIsAnagram() throws Exception {
        String firstString = "luck";
        String secondString = "lack";
        String result = FirstTask.getStringToMakeAnagrams(firstString,secondString);
        assertEquals("[u]",  result);
    }

    @Test(expected = Exception.class)
    public void testCheckLength() throws Exception {
        String firstString = "four";
        String secondString = "seven";
        FirstTask.checkLength(firstString,secondString);
    }

    @Test
    public void testLetterMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',2);
        assertEquals(map,FirstTask.letterMap("aa".toCharArray()));
    }

}