//2024-09-12 10:45:56
//第2576题
//给你一个下标从 0 开始的整数数组 nums 。
//
// 一开始，所有下标都没有被标记。你可以执行以下操作任意次：
//
//
// 选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
//
//
// 请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,5,2,4]
//输出：2
//解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
//没有其他更多可执行的操作，所以答案为 2 。
//
//
// 示例 2：
//
//
//输入：nums = [9,2,5,4]
//输出：4
//解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
//第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
//没有其他更多可执行的操作，所以答案为 4 。
//
//
// 示例 3：
//
//
//输入：nums = [7,6,8]
//输出：0
//解释：没有任何可以执行的操作，所以答案为 0 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics 贪心 数组 双指针 二分查找 排序 👍 76 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindTheMaximumNumberOfMarkedIndices{
    public static void main(String[] args){
        Solution solution = new FindTheMaximumNumberOfMarkedIndices().new Solution();
        System.out.println(solution.maxNumOfMarkedIndices(new int[]{3,5,2,4}));
        System.out.println(solution.maxNumOfMarkedIndices(new int[]{9,2,5,4}));
        System.out.println(solution.maxNumOfMarkedIndices(new int[]{7,6,8}));
        System.out.println(solution.maxNumOfMarkedIndices(new int[]{57,40,57,51,90,51,68,100,24,39,11,85,2,22,67,29,74,82,10,96,14,35,25,76,26,54,29,44,63,49,73,50,95,89,43,62,24,88,88,36,6,16,14,2,42,42,60,25,4,58,23,22,27,26,3,79,64,20,92}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int i = 0;
        int j = n/2;
        while(i<n/2 && j<n){
            if(nums[i]*2<=nums[j]){
                res+=2;
                i++;
            }
            j++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}