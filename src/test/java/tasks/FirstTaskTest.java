package tasks;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FirstTaskTest {


    @Test
    public void testValidateLetters() {
        String string = "gl123";
        boolean thrown = false;
        try {
            FirstTask.validateLetters(string);
        }
        catch(Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testIsAnagram() throws Exception {
        String firstString = "luck";
        String secondString = "lack";
        String result = FirstTask.isAnagram(firstString,secondString);
        assertEquals("[u]",  result);
    }

    @Test
    public void testCheckLength() {
        String firstString = "four";
        String secondString = "seven";
        boolean thrown = false;
        try {
            FirstTask.checkLength(firstString,secondString);
        }
        catch(Exception e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testPreProcess() {
        String parameter = "STRING";
        char [] array = {'s','t','r','i','n','g'};
        assertArrayEquals(array,FirstTask.preProcess(parameter));
    }

    @Test
    public void testLetterMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',2);
        assertEquals(map,FirstTask.letterMap("aa".toCharArray()));

    }



}