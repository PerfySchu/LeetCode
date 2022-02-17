//2022-02-17 11:10:04
//第688题
//在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格
//是 (0,0) ，右下单元格是 (n - 1, n - 1) 。 
//
// 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。 
//
// 
//
// 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。 
//
// 骑士继续移动，直到它走了 k 步或离开了棋盘。 
//
// 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。 
//
// 
//
// 示例 1： 
//
// 
//输入: n = 3, k = 2, row = 0, column = 0
//输出: 0.0625
//解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
//在每一个位置上，也有两种移动可以让骑士留在棋盘上。
//骑士留在棋盘上的总概率是0.0625。
// 
//
// 示例 2： 
//
// 
//输入: n = 1, k = 0, row = 0, column = 0
//输出: 1.00000
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 25 
// 0 <= k <= 100 
// 0 <= row, column <= n 
// 
// Related Topics 动态规划 👍 193 👎 0

package leetcode.editor.cn;
public class KnightProbabilityInChessboard{
    public static void main(String[] args){
        Solution solution = new KnightProbabilityInChessboard().new Solution();
        System.out.println(solution.knightProbability(9,5,0,0));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //状态转移方程 f[i][j][p] = ∑ f[nx][ny][p−1] / 8
    //移动方向降维
    int[][] direction = new int[][]{{-1,-2},{-1,2},{1,-2},{1,2},{-2,1},{-2,-1},{2,1},{2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : direction) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if(nx < 0 || nx >=n || ny < 0 || ny >= n){
                            continue;
                        }
                        dp[i][j][p] += dp[nx][ny][p-1] / 8;
                    }
                }
            }
        }
        return dp[row][column][k];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}