package basic;

import java.util.HashMap;

/**
 * SubArraySum
 * @description 数组中和为k的连续子数组的个数
 * @author shujingping
 * @date 2023/2/14 16:18
 * @version 1.0
 */
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
         // 前缀和数组
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int res = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) {
                res += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
 
