import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int length1 = str.length();
        int length2 = pattern.length();

        if (length2 > length1) {
            return false;
        }

        Map<Character, Integer> requiredMap = new HashMap();

        for (int i = 0; i < length2; i++) {
            requiredMap.put(pattern.charAt(i), requiredMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }


        Map<Character, Integer> currentMap = new HashMap();

        int start = 0;
        int end = 0;
        int count = 0;
        while (end < length1) {
            char c = str.charAt(end);

            currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);

            if (requiredMap.containsKey(c) && requiredMap.get(c).intValue() == currentMap.get(c).intValue()) {
                count++;
            }
            if (end - start + 1 > length2) {
                while (end - start + 1 > length2) {
                    char ch = str.charAt(start);
                    currentMap.put(ch, currentMap.get(ch) - 1);
                    if (requiredMap.get(ch) != null && currentMap.get(ch).intValue() < requiredMap.get(ch).intValue()) {
                        count--;
                    }
                    start++;
                }
            }
            if (count == requiredMap.size()) {
                return true;
            }

            end++;
        }

        return false;
    }
}
