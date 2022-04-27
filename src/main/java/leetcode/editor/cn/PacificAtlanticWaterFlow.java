//2022-04-27 09:30:57
//第417题
//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。
//
//
//
// 示例 1：
//
//
//
//
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
//
//
// 示例 2：
//
//
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
//
//
//
//
// 提示：
//
//
// m == heights.length
// n == heights[r].length
// 1 <= m, n <= 200
// 0 <= heights[r][c] <= 10⁵
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 381 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow{
    public static void main(String[] args){
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
        System.out.println(solution.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] direction = {{-1, 0},{1, 0},{0, -1},{0, 1}};
    int[][] heights;
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        //太平洋上边界开始
        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }
        //太平洋左边界开始
        for (int i = 1; i < n; i++) {
            dfs(0, i, pacific);
        }
        //大西洋右边界开始
        for (int i = 0; i < m; i++) {
            dfs(i, n-1, atlantic);
        }
        //大西洋下边界开始
        for (int i = 0; i < n-1; i++) {
            dfs(m - 1, i, atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    ans.add(cell);
                }
            }
        }
        return ans;
    }

    public void dfs(int row, int col, boolean[][] ocean){
        if(ocean[row][col]){
            return;
        }
        ocean[row][col] = true;
        //朝四个方向探索
        for (int[] dir : direction) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newCol >= 0
                    && newRow < m && newCol < n
                    && heights[newRow][newCol] >= heights[row][col]){
                dfs(newRow, newCol, ocean);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}