//2024-12-26 10:34:55
//第3218题
//有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
//
// 给你整数 m ，n 和两个数组：
//
//
// horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
// verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
//
//
// 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
//
//
// 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
// 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
//
//
// 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
//
// 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
//
// 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
//
//
//
// 示例 1：
//
//
// 输入：m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
//
//
// 输出：13
//
// 解释：
//
//
//
//
// 沿着垂直线 0 切开蛋糕，开销为 5 。
// 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
// 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
// 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
// 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
//
//
// 总开销为 5 + 1 + 1 + 3 + 3 = 13 。
//
// 示例 2：
//
//
// 输入：m = 2, n = 2, horizontalCut = [7], verticalCut = [4]
//
//
// 输出：15
//
// 解释：
//
//
// 沿着水平线 0 切开蛋糕，开销为 7 。
// 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
// 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
//
//
// 总开销为 7 + 4 + 4 = 15 。
//
//
//
// 提示：
//
//
// 1 <= m, n <= 20
// horizontalCut.length == m - 1
// verticalCut.length == n - 1
// 1 <= horizontalCut[i], verticalCut[i] <= 10³
//
//
// Related Topics 贪心 数组 动态规划 排序 👍 37 👎 0

package leetcode.editor.cn;
public class MinimumCostForCuttingCakeI{
    public static void main(String[] args){
        Solution solution = new MinimumCostForCuttingCakeI().new Solution();
        System.out.println(solution.minimumCost(3, 2, new int[]{1,3}, new int[]{5}));
        System.out.println(solution.minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            dp[i][0] =  dp[i-1][0] + horizontalCut[i-1];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] =  dp[0][i-1] + verticalCut[i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //状态转移，其中减去dp[i - 1][j - 1]是因为dp[i - 1][j]和dp[i][j - 1]最小开销和有重叠
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Math.min(horizontalCut[i - 1], verticalCut[j - 1]);
            }
        }
        return dp[m-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}