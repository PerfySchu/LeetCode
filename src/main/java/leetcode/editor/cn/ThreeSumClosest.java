//2023-07-10 09:09:59
//第16题
//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
// 返回这三个数的和。
//
// 假定每组输入只存在恰好一个解。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
// 示例 2：
//
//
//输入：nums = [0,0,0], target = 1
//输出：0
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 1000
// -1000 <= nums[i] <= 1000
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 双指针 排序 👍 1426 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args){
        Solution solution = new ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(solution.threeSumClosest(new int[]{0,0,0}, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k] == target){
                    return target;
                }
                if(Math.abs(nums[i]+nums[j]+nums[k]-target) < Math.abs(ans-target)){
                    ans = nums[i]+nums[j]+nums[k];
                }
                if (nums[i]+nums[j]+nums[k] > target){
                    k--;
                }else {
                    j++;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}