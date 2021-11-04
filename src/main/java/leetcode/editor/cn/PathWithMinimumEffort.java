//2021-11-03 16:06:42
//第1631题
//你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row,
// col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你
//每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。 
//
// 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。 
//
// 请你返回从左上角走到右下角的最小 体力消耗值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
//输出：2
//解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
//这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
//输出：1
//解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
// 
//
// 示例 3： 
//
// 
//输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//输出：0
//解释：上图所示路径不需要消耗任何体力。
// 
//
// 
//
// 提示： 
//
// 
// rows == heights.length 
// columns == heights[i].length 
// 1 <= rows, columns <= 100 
// 1 <= heights[i][j] <= 10⁶ 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 二分查找 矩阵 堆（优先队列） 👍 247 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort{
    public static void main(String[] args){
        Solution solution = new PathWithMinimumEffort().new Solution();
        System.out.println(solution.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        //移动方位向量    左， 右，下， 上
        int[][] directs = {{-1,0},{1,0},{0,-1},{0,1}};

        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //定义起点，左上角
        queue.offer(new int[]{0, 0, 0});
        //记录元素是否被访问
        boolean[][] visited = new boolean[m][n];

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], val = cur[2];
            //调过已被访问的节点
            if(visited[x][y]) continue;
            //到达终点，直接返回
            if(x == m-1 && y == n-1){
                return val;
            }
            visited[x][y] = true;

            //当前节点朝四个方向扩展
            for (int[] direct : directs) {
                int nx = x + direct[0], ny = y + direct[1];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n){
                    //跳过边界
                    continue;
                }
                int abs = Math.abs(heights[nx][ny] - heights[x][y]);
                queue.offer(new int[]{nx, ny, Math.max(val, abs)});
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
