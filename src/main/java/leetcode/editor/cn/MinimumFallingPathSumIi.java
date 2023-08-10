//2023-08-10 09:21:23
//第1289题
//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
//
//
//
// 示例 1：
//
//
//
//
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
//
//
// 示例 2：
//
//
//输入：grid = [[7]]
//输出：7
//
//
//
//
// 提示：
//
//
// n == grid.length == grid[i].length
// 1 <= n <= 200
// -99 <= grid[i][j] <= 99
//
//
// Related Topics 数组 动态规划 矩阵 👍 115 👎 0

package leetcode.editor.cn;
public class MinimumFallingPathSumIi{
    public static void main(String[] args){
        Solution solution = new MinimumFallingPathSumIi().new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(solution.minFallingPathSum(new int[][]{{7}}));
        System.out.println(solution.minFallingPathSum(new int[][]{{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2},{2,2,1,2,2}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int n = grid.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k!=j){
                        min = Math.min(min,grid[i-1][k]);
                    }
                }
                grid[i][j] += min;
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans,grid[n-1][i]);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}