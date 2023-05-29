//2023-05-26 14:59:02
//第1091题
//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//：
//
//
// 路径途经的所有单元格都的值都是 0 。
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
//
//
// 畅通路径的长度 是该路径途经的单元格总数。
//
//
//
// 示例 1：
//
//
//输入：grid = [[0,1],[1,0]]
//输出：2
//
//
// 示例 2：
//
//
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
//
//
// 示例 3：
//
//
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
//
//
//
//
// 提示：
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 100
// grid[i][j] 为 0 或 1
//
//
// Related Topics 广度优先搜索 数组 矩阵 👍 300 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix{
    public static void main(String[] args){
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
        //System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        //System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
        //System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,0,0},{0,0,1},{0,0,0}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }
        // 8个方向
        int[][] directions = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        int[][] dist = new int[n][n];
        dist[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            for(int[] direction : directions){
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if(newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0 && dist[newX][newY] == 0){
                    dist[newX][newY] = dist[curX][curY] + 1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return dist[n-1][n-1] == 0 ? -1 : dist[n-1][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}