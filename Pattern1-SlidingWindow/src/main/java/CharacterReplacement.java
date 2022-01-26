import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap();

        int length = str.length();
        int start = 0;
        int end = 0;
        int maxChar = 0;
        int ans = 0;
        while (end < length) {
            char c = str.charAt(end);

            map.put(c, map.getOrDefault(c, 0) + 1);

            maxChar = maxChar > map.get(c) ? maxChar : map.get(c);

            int lengthOfSubstring = end - start + 1;

            if (lengthOfSubstring - maxChar <= k) {
                if (lengthOfSubstring > ans) {
                    ans = lengthOfSubstring;
                }
            } else {
                while (lengthOfSubstring - maxChar > k) {
                    char ch = str.charAt(start);
                    map.put(ch, map.get(ch) - 1);
                    if (map.get(ch) == 0) {
                        map.remove(ch);
                    }
                    start++;
                    lengthOfSubstring = end - start + 1;
                }
            }
            end++;

        }
        return ans;
    }
}
