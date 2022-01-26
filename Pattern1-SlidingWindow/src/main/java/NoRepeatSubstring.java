import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int findLength(String str) {
        Map<Character, Integer> characterFrequencyMap = new HashMap();
        int start =0;
        int end =0;
        int length =0;
        while(end < str.length()){
            if(characterFrequencyMap.containsKey(str.charAt(end))){
                length = Math.max(length, end - start);
                start = Math.max(start, characterFrequencyMap.get(str.charAt(end)) +1);
            }
            length = Math.max(length, end - start);
            characterFrequencyMap.put(str.charAt(end), end);
            end++;
        }
        return length;
    }

}
