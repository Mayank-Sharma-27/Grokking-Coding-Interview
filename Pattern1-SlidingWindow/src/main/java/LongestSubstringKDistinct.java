import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {
        int maximumLengthOfSubstring = 0;

        int start = 0;
        int end = 0;
        int length = str.length() - 1;
        Map<Character, Integer> map = new HashMap();
        while (end < length) {
            map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);
            end++;
            if (map.size() <= k) {
                maximumLengthOfSubstring = Math.max(end - start, maximumLengthOfSubstring);
            } else {
                while (map.size() >= k) {
                    map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                    if (map.get(str.charAt(start)) == 0) {
                        map.remove(str.charAt(start));
                    }
                    start++;

                }
            }
        }
        maximumLengthOfSubstring = Math.max(end - start, maximumLengthOfSubstring);
        return maximumLengthOfSubstring;
    }
}
