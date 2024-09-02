//2024-08-30 17:23:20
//第2400题
//给你两个 正 整数 startPos 和 endPos 。最初，你站在 无限 数轴上位置 startPos 处。在一步移动中，你可以向左或者向右移动一个位置
//。
//
// 给你一个正整数 k ，返回从 startPos 出发、恰好 移动 k 步并到达 endPos 的 不同 方法数目。由于答案可能会很大，返回对 10⁹ +
//7 取余 的结果。
//
// 如果所执行移动的顺序不完全相同，则认为两种方法不同。
//
// 注意：数轴包含负整数。
//
//
//
// 示例 1：
//
// 输入：startPos = 1, endPos = 2, k = 3
//输出：3
//解释：存在 3 种从 1 到 2 且恰好移动 3 步的方法：
//- 1 -> 2 -> 3 -> 2.
//- 1 -> 2 -> 1 -> 2.
//- 1 -> 0 -> 1 -> 2.
//可以证明不存在其他方法，所以返回 3 。
//
// 示例 2：
//
// 输入：startPos = 2, endPos = 5, k = 10
//输出：0
//解释：不存在从 2 到 5 且恰好移动 10 步的方法。
//
//
//
// 提示：
//
//
// 1 <= startPos, endPos, k <= 1000
//
//
// Related Topics 数学 动态规划 组合数学 👍 59 👎 0

package leetcode.editor.cn;
public class NumberOfWaysToReachAPositionAfterExactlyKSteps{
    public static void main(String[] args){
        Solution solution = new NumberOfWaysToReachAPositionAfterExactlyKSteps().new Solution();
        System.out.println(solution.numberOfWays(1,2,3));
        System.out.println(solution.numberOfWays(2,5,10));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int mod = 1000000007;
        int dist = endPos - startPos;
        if(k < Math.abs(dist) || ((k - Math.abs(dist)) & 1) == 1){
            return 0;
        }
        int cap = (k - Math.abs(dist)) / 2;
        long[] dp = new long[cap+1];
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = cap; j >= 0; j--) {
                if (j>=1) {
                    dp[j] = (dp[j]+dp[j-1]) % mod;
                }
            }
        }
        return (int) dp[cap];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}