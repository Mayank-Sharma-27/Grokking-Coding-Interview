import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    public static int findLength(char[] arr) {
        int maximumFruits = 0;
        int start = 0;
        int end = 0;
        int length = arr.length;
        Map<Character, Integer> map = new HashMap();
        while (end < length) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            end++;
            if (map.size() == 2) {
                maximumFruits = Math.max(end - start, maximumFruits);
            } else {
                while (map.size() > 2) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    if (map.get(arr[start]) == 0) {
                        map.remove(arr[start]);
                    }
                    start++;

                }
            }
        }
        maximumFruits = Math.max(end - start, maximumFruits);
        return maximumFruits;

    }

}
