//2023-08-17 15:11:28
//第1444题
//给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1
// 次，得到 k 块披萨并送给别人。
//
// 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平
//地切，那么需要把上面的部分送给一个人。在切完最后一刀后，需要把剩下来的一块送给最后一个人。
//
// 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
//
//
//
// 示例 1：
//
//
//
// 输入：pizza = ["A..","AAA","..."], k = 3
//输出：3
//解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
//
//
// 示例 2：
//
// 输入：pizza = ["A..","AA.","..."], k = 3
//输出：1
//
//
// 示例 3：
//
// 输入：pizza = ["A..","A..","..."], k = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= rows, cols <= 50
// rows == pizza.length
// cols == pizza[i].length
// 1 <= k <= 10
// pizza 只包含字符 'A' 和 '.' 。
//
//
// Related Topics 记忆化搜索 数组 动态规划 矩阵 👍 145 👎 0

package leetcode.editor.cn;
public class NumberOfWaysOfCuttingAPizza{
    public static void main(String[] args){
        Solution solution = new NumberOfWaysOfCuttingAPizza().new Solution();
        System.out.println(solution.ways(new String[]{"A..","AAA","..."}, 3));
        System.out.println(solution.ways(new String[]{"A..","AA.","..."}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int mod = 1000000007;
        int[][] apples = new int[m + 1][n + 1];
        int[][][] dp = new int[k+1][m+1][n+1];

        for (int i = m-1; i>=0; i--){
            for (int j = n-1; j>=0; j--) {
                apples[i][j] = apples[i+1][j] + apples[i][j+1] - apples[i+1][j+1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        for (int ki = 2; ki <=k; ki++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 横切
                    for (int i2 = i+1; i2 < m; i2++) {
                        if (apples[i][j] > apples[i2][j]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki-1][i2][j]) % mod;
                        }
                    }
                    // 竖切
                    for (int j2 = j+1; j2 < n; j2++) {
                        if (apples[i][j] > apples[i][j2]) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki-1][i][j2]) % mod;
                        }
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}