package basic;

import java.util.HashMap;

/**
 * LengthOfLongestSubstring
 * @description  【滑动窗口】最长无重复子串：给定一个字符串，找出其中不含有重复字符的最长子串的长度
 * @author shujingping
 * @date 2023/5/22 09:52
 * @version 1.0
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String bis = "bvbcb";
        System.out.println(getSubstring(bis));
    }

    public static int getSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>(16);
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(right - left, res);
        }
        return res;
    }
}
 
