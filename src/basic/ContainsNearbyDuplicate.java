package basic;

import java.util.HashSet;

/**
 * ContainsNearbyDuplicate
 * @description 给一个整数数组nums和一个整数k，判断数组中是否存在两个不同的索引i和j，满足
 * nums[i] == nums[j] 且 abs(i - j) <= k。存在返回true，否则，返回false
 * @author shujingping
 * @date 2023/5/23 09:51
 * @version 1.0
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1};
        int k = 1;
        System.out.println(solution(nums, k));
    }
    public static boolean solution(int[] nums, int k) {
        // 滑动窗口
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i-k-1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
 
