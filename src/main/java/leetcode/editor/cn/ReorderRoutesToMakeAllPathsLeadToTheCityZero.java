//2023-12-07 10:35:23
//第1466题
//n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输
//部决定重新规划路线，以改变交通拥堵的状况。
//
// 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
// 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
// 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
// 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
//
//
//
// 示例 1：
//
//
//
// 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
//输出：3
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 2：
//
//
//
// 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
//输出：2
//解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
//
// 示例 3：
//
// 输入：n = 3, connections = [[1,0],[2,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// 2 <= n <= 5 * 10^4
// connections.length == n-1
// connections[i].length == 2
// 0 <= connections[i][0], connections[i][1] <= n-1
// connections[i][0] != connections[i][1]
//
//
// Related Topics 深度优先搜索 广度优先搜索 图 👍 176 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero{
    public static void main(String[] args){
        Solution solution = new ReorderRoutesToMakeAllPathsLeadToTheCityZero().new Solution();
        System.out.println(solution.minReorder(6, new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int[] edge : connections) {
            e[edge[0]].add(new int[]{edge[1], 1});
            e[edge[1]].add(new int[]{edge[0], 0});
        }
        return dfs(0, -1, e);
    }

    public int dfs(int x, int parent, List<int[]>[] e){
        int res = 0;
        for (int[] edge : e[x]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}