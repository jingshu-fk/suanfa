package template;

/**
 * BinarySearch
 * @description 二分搜索模版（一个有序数组搜索元素,寻找左侧边界，寻找右侧边界）
 * @author shujingping
 * @date 2023/5/23 08:35
 * @version 1.0
 */
public class BinarySearch {
    public int oneSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }


    public int leftSearch(int[] nums, int target) {
        // 寻找左侧边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 锁定左侧边界
                right = mid - 1;
            }
        }

        // 最后检查left越界的情况
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public int rightSearch(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后检查right越界的情况
        if (right < 0 || nums[right] != target) {
            return -1;
        }

        return right;
    }
}
 
