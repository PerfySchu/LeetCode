//2021-11-03 14:19:46
//第407题
//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//输出: 4
//解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
//输出: 10
// 
//
// 
//
// 提示: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
//
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 451 👎 0

package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterIi{
    public static void main(String[] args){
        Solution solution = new TrappingRainWaterIi().new Solution();
        System.out.println(solution.trapRainWater(new int[][]{{3,3,3,3,3},{3,2,2,2,3},{3,2,1,2,3},{3,2,2,2,3},{3,3,3,3,3}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        int height = heightMap.length;
        int width = heightMap[0].length;
        //记录当前节点是否被访问
        boolean[][] visited = new boolean[height][width];
        //三元数组 (x,y,height)
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        //放入最外圈元素
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(i == 0 || i == height-1 || j == 0 || j == width-1){
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        //每次去除当前外围最小值，并向四周对比，判断是否有可以存水的地方
        //右，左，上，下
        //int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        //TODO: 上下左右位置的变化可以用一维数组简化表示  {-1, 0, 1, 0, -1}
        int[] direct = {-1, 0, 1, 0, -1};
        while (!queue.isEmpty()){
            int[] element = queue.poll();
            int x = element[0], y = element[1], high = element[2];
            //取当前坐标前后左右四个方向的位置逐一对比
            for (int i = 0; i < 4; i++) {
                int newX = x + direct[i];
                int newY = y + direct[i+1];
                //如果当前位置没访问过且合法，则可以进行对比处理
                if(newX >= 0 && newX < height && newY >= 0 && newY < width && !visited[newX][newY]){
                    int newHigh = heightMap[newX][newY];
                    //可以灌水
                    if(high > heightMap[newX][newY]){
                        res += high - newHigh;
                    }
                    queue.offer(new int[]{newX, newY, Math.max(high, newHigh)});
                    visited[newX][newY] = true;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
