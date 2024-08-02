//2024-08-02 09:29:55
//第3128题
//给你一个二维 boolean 矩阵 grid 。
//
// 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
//
// 注意：
//
//
// 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。这 3 个元素
//互相之间不需要相邻。
//
//
//
//
// 示例 1：
//
//
//
//
//
// 0
// 1
// 0
//
//
// 0
// 1
// 1
//
//
// 0
// 1
// 0
//
//
//
//
//
//
//
//
// 0
// 1
// 0
//
//
// 0
// 1
// 1
//
//
// 0
// 1
// 0
//
//
//
//
//
// 输入：grid = [[0,1,0],[0,1,1],[0,1,0]]
//
//
// 输出：2
//
// 解释：
//
// 有 2 个直角三角形。
//
// 示例 2：
//
//
//
//
//
// 1
// 0
// 0
// 0
//
//
// 0
// 1
// 0
// 1
//
//
// 1
// 0
// 0
// 0
//
//
//
//
//
//
// 输入：grid = [[1,0,0,0],[0,1,0,1],[1,0,0,0]]
//
//
// 输出：0
//
// 解释：
//
// 没有直角三角形。
//
// 示例 3：
//
//
//
//
//
// 1
// 0
// 1
//
//
// 1
// 0
// 0
//
//
// 1
// 0
// 0
//
//
//
//
//
//
//
//
// 1
// 0
// 1
//
//
// 1
// 0
// 0
//
//
// 1
// 0
// 0
//
//
//
//
//
// 输入：grid = [[1,0,1],[1,0,0],[1,0,0]]
//
//
// 输出：2
//
// 解释：
//
// 有两个直角三角形。
//
//
//
// 提示：
//
//
// 1 <= grid.length <= 1000
// 1 <= grid[i].length <= 1000
// 0 <= grid[i][j] <= 1
//
//
// Related Topics 数组 哈希表 数学 组合数学 计数 👍 12 👎 0

package leetcode.editor.cn;
public class RightTriangles{
    public static void main(String[] args){
        Solution solution = new RightTriangles().new Solution();
        System.out.println(solution.numberOfRightTriangles(new int[][]{{0,1,0},{0,1,1},{0,1,0}}));
        System.out.println(solution.numberOfRightTriangles(new int[][]{{1,0,0,0},{0,1,0,1},{1,0,0,0}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int[] lineCount = new int[grid.length];
        int[] rowCount = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    lineCount[i] = lineCount[i]+1;
                    rowCount[j] = rowCount[j] + 1;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    //当前点作为直角顶点时，统计可能有多少个三角形
                    if (lineCount[i] < 2 || rowCount[j] < 2) {
                        continue;
                    }
                    ans += (long) (lineCount[i] - 1) * (rowCount[j]-1);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}