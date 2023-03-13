//2023-03-10 15:56:52
//第740题
//给你一个整数数组 nums ，你可以对它进行一些操作。
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
//
//
// 示例 2：
//
//
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 10⁴
// 1 <= nums[i] <= 10⁴
//
//
// Related Topics 数组 哈希表 动态规划 👍 723 👎 0

package leetcode.editor.cn;
public class DeleteAndEarn{
    public static void main(String[] args){
        Solution solution = new DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3,4,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        //      构造一个新的数组all
        int[] all = new int[max + 1];
        for (int item : nums) {
            all[item] ++;
        }
        int[] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        //      动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }
        return dp[max];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}