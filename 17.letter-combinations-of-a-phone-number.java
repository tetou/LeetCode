/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    private String digits;
    private List<String> result;
    private Map<Character, String[]> map;
    private Set<String> set;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.result = new ArrayList<String>();
        this.map = new HashMap<Character, String[]>();
        this.set = new HashSet<String>();
        map.put('2', new String[]{"a","b","c"});
        map.put('3', new String[]{"d","e","f"});
        map.put('4', new String[]{"g","h","i"});
        map.put('5', new String[]{"j","k","l"});
        map.put('6', new String[]{"m","n","o"});
        map.put('7', new String[]{"p","q","r","s"});
        map.put('8', new String[]{"t","u","v"});
        map.put('9', new String[]{"w","x","y","z"});

        help(0, "");

        for (String element : set) {
            result.add(element);
        }

        return result;
    }

    private void help(int index, String str) {
        if (digits.length() == str.length() && !str.equals("")) {
            set.add(str);
        }
        if (index >= digits.length()) return;
        char digit = digits.charAt(index);
        String[] arr = map.get(digit);
        for (int i = 0; i < arr.length; i++) {
            help(index+1, str+arr[i]);
        }
    }
}
// @lc code=end

