package tasks;

import java.util.*;

public class FirstTask {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();
        System.out.println(getStringToMakeAnagrams(firstString,secondString));
    }

    /* This method compares lengths of strings.
     * We can't check whether two strings are anagrams if they have different lengths.
     */
    static void checkLength(String first, String second) throws Exception {
        if (first.length() != second.length()) {
            throw new Exception("Unequal lengths of words");
        }
    }

    /* We create a hash map, in which the key is character(letter)
     * and the value is number of occurrences of this letter in current string.
     * So, we use foreach cycle to go through the string.
     * At first, we check if this character is already in the map, and if it is,
     * we get value and increment it (just add this character to number of the occurrences)
     * Thus, we check every character in the string and fill the hash map.
     */
    static Map<Character, Integer> letterMap(char[] string) {
        Map<Character, Integer> map = new HashMap<>();
        for (char character: string) {
            Integer count = map.getOrDefault(character, 0);
            map.put(character, count + 1);
        }
        return map;
    }

    static String getStringToMakeAnagrams(String firstWord, String secondWord) throws Exception {
        checkLength(firstWord, secondWord);

        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();

        Map<Character, Integer> firstMap = letterMap(firstArray);
        Map<Character, Integer> secondMap = letterMap(secondArray);

        /* If maps of the strings are equals, then numbers of occurrences of the same characters are equal
         * and these strings are anagrams.
         */
        if (firstMap.equals(secondMap))
            return "Strings are anagrams";

        /* We create a list that will contain characters that we need to change in the first string.
         * At the beginning we go through the map of the first string and get current character and number of its occurrences.
         * Then, we get the number of occurrences from the second map by the character.
         * After this, we subtract the second value from the first one and get the character and number of times
         * we need to add it to the first string to make both string anagrams.
         * So we check every character and fill the list.
         */
        List<Character> diff = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : firstMap.entrySet())
        {
            Character letter = entry.getKey();
            Integer firstCount = entry.getValue();
            Integer secondCount = secondMap.getOrDefault(letter, 0);
            for (int i = 0; i < firstCount - secondCount; i++) {
                diff.add(letter);
            }
        }
        return diff.toString();
    }
}
