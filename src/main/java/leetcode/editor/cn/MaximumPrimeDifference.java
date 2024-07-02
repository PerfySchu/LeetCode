//2024-07-02 09:24:55
//第3115题
//给你一个整数数组 nums。
//
// 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
//
//
//
// 示例 1：
//
//
// 输入： nums = [4,2,9,5,3]
//
//
// 输出： 3
//
// 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
//
// 示例 2：
//
//
// 输入： nums = [4,8,2,8]
//
//
// 输出： 0
//
// 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁵
// 1 <= nums[i] <= 100
// 输入保证 nums 中至少有一个质数。
//
//
// Related Topics 数组 数学 数论 👍 11 👎 0

package leetcode.editor.cn;
public class MaximumPrimeDifference{
    public static void main(String[] args){
        Solution solution = new MaximumPrimeDifference().new Solution();
        System.out.println(solution.maximumPrimeDifference(new int[]{4,2,9,5,3}));
        System.out.println(solution.maximumPrimeDifference(new int[]{4,8,2,8}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
        }
        if(last == Integer.MIN_VALUE){
            return 0;
        }
        return last-first;
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}