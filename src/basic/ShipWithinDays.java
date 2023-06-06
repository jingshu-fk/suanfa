package basic;

/**
 * ShipWithinDays
 * @description leetcode-1011-在D天内送达包裹的能力 【er fener feer f
 * @author shujingping
 * @date 2023/5/26 09:49
 * @version 1.0
 */
public class ShipWithinDays {
    public int getDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        int left = max, right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            // need为需要运送的天数
            // cur为这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    need++;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
 
