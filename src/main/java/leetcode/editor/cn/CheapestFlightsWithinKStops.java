//2021-08-28 09:55:34
//第787题
//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 pricei 抵达 toi。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 104 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 
// 👍 392 👎 0

package leetcode.editor.cn;

import java.util.*;

public class CheapestFlightsWithinKStops{
    public static void main(String[] args){
        Solution solution = new CheapestFlightsWithinKStops().new Solution();
        System.out.println(solution.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE/2;
        //经过 i 条边，达到 j点的最小花费
        int[][] timePrice = new int[k+2][n];
        for (int[] ints : timePrice) {
            Arrays.fill(ints, INF);
        }
        timePrice[0][src] = 0;
        for (int times = 1; times <= k + 1; times++) {
            for (int[] flight : flights) {
                int start = flight[0];
                int end = flight[1];
                int cost = flight[2];
                timePrice[times][end] = Math.min(timePrice[times][end], timePrice[times-1][start]+cost);
            }
        }
        int ans = INF;
        for (int times = 1; times <= k + 1; times++) {
            ans = Math.min(ans, timePrice[times][dst]);
        }
        return ans==INF ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}