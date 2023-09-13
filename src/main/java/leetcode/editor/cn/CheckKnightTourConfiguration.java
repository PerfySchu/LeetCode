//2023-09-13 09:47:21
//第2596题
//骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
//
// 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，其中 grid[row][col] 表示单元格 (
//row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
//
// 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
//
// 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
//
//
//
// 示例 1：
// 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13
//,2,7,22]]
//输出：true
//解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
//
//
// 示例 2：
// 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
//输出：false
//解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
//
//
//
//
// 提示：
//
//
// n == grid.length == grid[i].length
// 3 <= n <= 7
// 0 <= grid[row][col] < n * n
// grid 中的所有整数 互不相同
//
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 模拟 👍 19 👎 0

package leetcode.editor.cn;
public class CheckKnightTourConfiguration{
    public static void main(String[] args){
        Solution solution = new CheckKnightTourConfiguration().new Solution();
        System.out.println(solution.checkValidGrid(new int[][]{{0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}}));
        System.out.println(solution.checkValidGrid(new int[][]{{0,3,6},{5,8,1},{2,7,4}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) {
            return false;
        }
        int[][] idx = new int[n*n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                idx[grid[i][j]] = new int[]{i, j};
            }
        }
        for (int i = 1; i < idx.length; i++) {
            int dx = Math.abs(idx[i][0] - idx[i-1][0]);
            int dy = Math.abs(idx[i][1] - idx[i-1][1]);
            if (dx * dy != 2) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}