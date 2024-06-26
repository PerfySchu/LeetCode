//2024-06-26 10:34:32
//第2741题
//给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列：
//
//
// 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i]
//== 0 。
//
//
// 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。
//
//
//
// 示例 1：
//
// 输入：nums = [2,3,6]
//输出：2
//解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
//
//
// 示例 2：
//
// 输入：nums = [1,4,3]
//输出：2
//解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 14
// 1 <= nums[i] <= 10⁹
//
//
// Related Topics 位运算 数组 动态规划 状态压缩 👍 55 👎 0

package leetcode.editor.cn;
public class SpecialPermutations{
    public static void main(String[] args){
        Solution solution = new SpecialPermutations().new Solution();
        System.out.println(solution.specialPerm(new int[]{2,3,6}));
        System.out.println(solution.specialPerm(new int[]{1,4,3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int specialPerm(int[] nums) {
        int MOD = 1000000007;
        int n = nums.length;
        int[][] f = new int[1<<n][n];
        for (int i = 0; i < n; i++) {
            f[1<<i][i] = 1;
        }
        for (int state = 1; state < 1 << n; state++) {
            for (int i = 0; i < n; i++) {
                if ((state >> i & 1) == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (i == j || (state>>i & 1) == 0) {
                        continue;
                    }
                    if (nums[i] % nums[j] != 0 && nums[j] % nums[i] != 0) {
                        continue;
                    }
                    f[state][i] = (f[state][i] + f[state^(1<<i)][j]) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + f[(1<<n) - 1][i]) % MOD;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}