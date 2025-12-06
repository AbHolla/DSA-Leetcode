import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        // Map each character to its row number
        int[] row = new int[26];
        for (char c : row1.toCharArray()) row[c - 'a'] = 1;
        for (char c : row2.toCharArray()) row[c - 'a'] = 2;
        for (char c : row3.toCharArray()) row[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String w : words) {
            String word = w.toLowerCase();
            int r = row[word.charAt(0) - 'a'];

            boolean ok = true;
            for (char ch : word.toCharArray()) {
                if (row[ch - 'a'] != r) {
                    ok = false;
                    break;
                }
            }

            if (ok) result.add(w);
        }

        return result.toArray(new String[0]);
    }
}
