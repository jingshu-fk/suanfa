package basic;

/**
 * PreSum
 * @description 前缀和数组
 * 求数组索引[i, j]区间的和
 * @author shujingping
 * @date 2023/2/1 16:43
 * @version 1.0
 */

public class PreSum {
    private int[] preSum;

    public PreSum(int[] nums) {
        preSum[0] = 0;
        preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}
 
