package basic;

import java.util.ArrayList;
import java.util.List;

/**
 * TestA
 * @description 测试
 * @author shujingping
 * @date 2023/2/14 16:30
 * @version 1.0
 */
public class TestA {
    public static void main(String[] args) {
//        int[] nums = {3, 5, -4, 1, -1, 9};
        int[] nums = {1, 1, 1};
        List<String> ks = new ArrayList<>();
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.subarraySum(nums, 2));
    }
}
 
