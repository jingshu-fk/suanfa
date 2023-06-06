package basic;

/**
 * MinEatingSpeed
 * @description leetcode-875-爱吃香蕉的珂珂 【二分搜索】
 * @author shujingping
 * @date 2023/5/26 09:21
 * @version 1.0
 */
public class MinEatingSpeed {

    public int getSpeed(int[] piles, int h) {
        // 最小速度每小时1个香蕉
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            // 最快速度每小时吃一堆香蕉（最多的一堆的香蕉数目）
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }
}
 
