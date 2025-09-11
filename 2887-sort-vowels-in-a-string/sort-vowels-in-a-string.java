import java.util.*;

public class Solution {

    public String sortVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        );

        List<Character> vowels = new ArrayList<>();

        // Step 1: Collect all vowels from the string
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                vowels.add(c);
            }
        }

        // Step 2: Sort the collected vowels by ASCII value
        Collections.sort(vowels);

        // Step 3: Reconstruct the result string
        StringBuilder result = new StringBuilder();
        int vowelIndex = 0;

        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                result.append(vowels.get(vowelIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

