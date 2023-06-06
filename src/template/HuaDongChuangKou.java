package template;

import java.util.HashMap;

/**
 * HuaDongChuangKou
 * @description 滑动窗口模版：解决子串问题
 * @author shujingping
 * @date 2023/5/23 09:01
 * @version 1.0
 */
public class HuaDongChuangKou {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(16);
        HashMap<Character, Integer> window = new HashMap<>(16);
        for (int i = 0; i < t.length(); i++) {
            char b = t.charAt(i);
            need.put(b, need.getOrDefault(b, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将移出窗口的字符
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return s.substring(start, len);
    }
}
 
