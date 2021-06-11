import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramsMap = new HashMap<String, List<String>>();

        for (String str: strs) {
            String sorted = sortString(str);
            List<String> tmp = anagramsMap.getOrDefault(sorted, new LinkedList<String>());
            tmp.add(str);
            anagramsMap.put(sorted, tmp);
        }

        List<List<String>> output = new ArrayList<>();
        for (List<String> value : anagramsMap.values()) {
            output.add(value);
        }
        return output;
    }

    private static String sortString(String inputString)
    {
        char tempArray[] = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }
}
