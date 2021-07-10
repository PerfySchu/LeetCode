//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 120 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum{
    public static void main(String[] args){
        Solution solution = new BinarySubarraysWithSum().new Solution();
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(solution.numSubarraysWithSum(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println(solution3(nums, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //构建前缀和字典
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        int count = 0;
        for (int i = 1; i < sums.length; i++) {
            //前 i 项和正好是目标值
            if(sums[i] == goal){
                count ++;
            }
            for (int j = i+1; j<sums.length; j++){
                // 前 i 到 j 项和是目标值
                if (sums[i] + goal == sums[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 前缀和 + hashmap 解法
     * @param nums
     * @param goal
     * @return
     */
    public static int solution2(int[] nums, int goal){
        int count =0;
        // sumMap 所有 前缀和 以及 出现的次数
        Map<Integer, Integer> sumMap = new HashMap<>();
        //为什么要初始化 0,1 ？ 为了让 当前n项和等于 goal 的情况不漏掉
        //sumMap.put(0, 1);
        int sum = 0;
        //一边记录一边判断
        for (int num : nums) {
            sum += num;
            //当前 n项和正好是目标值
            //有此3行代码，则不需要初始化map(0,1)
            if(sum == goal){
                count ++;
            }
            //如果当前 n项和跟目标值的差值正好也在 map中， 那就符合题设条件
            if(sumMap.containsKey(sum - goal)){
                count += sumMap.get(sum - goal);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    /**
     * 滑动窗口解法
     * @param nums
     * @param goal
     * @return
     */
    public static int solution3(int[] nums, int goal){
        int n = nums.length;
        int left1 = 0, left2 = 0, right =0;
        //sum1 当前最大窗口之和，sum2
        int sum1 = 0, sum2 = 0;
        int count =0;
        while (right < n){
            sum1 += nums[right];
            //当前窗口总和超过目标值
            while (left1<=right && sum1>goal){
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2<=right && sum2>= goal){
                sum2 -= nums[left2];
                left2++;
            }
            count += left2 - left1;
            right ++;
        }
        return count;
    }
}
