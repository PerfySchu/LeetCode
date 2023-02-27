//2023-02-03 09:23:04
//第1129题
//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。
//
//
//
// 示例 1：
//
//
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
//
//
// 示例 2：
//
//
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
//
//
// 示例 3：
//
//
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
//
//
// 示例 4：
//
//
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
//
//
// 示例 5：
//
//
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 100
// red_edges.length <= 400
// blue_edges.length <= 400
// red_edges[i].length == blue_edges[i].length == 2
// 0 <= red_edges[i][j], blue_edges[i][j] < n
//
//
// Related Topics 广度优先搜索 图 👍 242 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public static void main(String[] args) {
        Solution solution = new ShortestPathWithAlternatingColors().new Solution();
        System.out.println(Arrays.toString(solution.shortestAlternatingPaths(3, new int[][]{{2, 1}, {0, 1}}, new int[][]{})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<Integer>[] redList = new List[n];
            List<Integer>[] blueList = new List[n];

            for (int i = 0; i < n; ++i) {
                redList[i] = new ArrayList<>();
                blueList[i] = new ArrayList<>();
            }

            for (int[] e : redEdges) {
                redList[e[0]].add(e[1]);
            }

            for (int[] e : blueEdges) {
                blueList[e[0]].add(e[1]);
            }

            int[] redAns = new int[n];// 最后一步为 [红色] 时到达点i的 [最小] 步数
            int[] blueAns = new int[n];// 最后一步为 [蓝色] 时到达点i的 [最小] 步数

            for (int i = 1; i < n; i++)// 初始化 所有 [最小] 步数全部设置成 [MAX]
            {                         // 从 [1] 开始因为从 [点0] 到 [点0] 需要 [0] 步
                redAns[i] = Integer.MAX_VALUE;
                blueAns[i] = Integer.MAX_VALUE;
            }

            Queue<int[]> queue = new ArrayDeque<>();// 由长度为 [2] 的数组表示每个点
            // 点的序号 + 下一次要走的 [颜色]

            queue.add(new int[]{0, 0});// [0] 表示下一次要走 [红色]
            queue.add(new int[]{0, 1});// [1] 表示下一次要走 [蓝色]
            // 初始状态有 [2] 个因为一开始可以走 [红色] 或者 [蓝色]

            int level = 0;// bfs的层数 = 走的步数
            // 在层数 [i] 到达的点 意味着从 [0] 开始走 [i] 步可以到达这个点

            while (!queue.isEmpty()) {
                level++;// bfs的层数 [+1]

                int size = queue.size();

                for (int i = 0; i < size; i++)// 对于每个准备走的点
                {
                    int[] curArr = queue.poll();
                    int cur = curArr[0];

                    if (curArr[1] == 0)// 如果这个点下一步要走 [红色]
                    {
                        for (int next : redList[cur])// 从 [红色] 的邻接表里找可以走到的下一个点'next'
                        {
                            if (level < redAns[next])// 如果记录的最后一步为 [红色] 时到达点'next'
                            {                       // 的 [最小] 步数 [大于] 当前层数

                                redAns[next] = level;// 更新 [最小] 步数
                                queue.offer(new int[]{next, 1});//将点'next'入队 并且下一次要走 [蓝色]
                            }
                        }
                    } else// 如果这个点下一步要走 [蓝色] 时同理
                    {
                        for (int next : blueList[cur]) {
                            if (level < blueAns[next]) {
                                blueAns[next] = level;
                                queue.offer(new int[]{next, 0});
                            }
                        }
                    }
                }
            }

            // 到达一个点的最小步数为 min([红色]结尾时的[最小]步数，[蓝色]结尾时的[最小]步数)
            for (int i = 0; i < redAns.length; i++) {
                if (blueAns[i] < redAns[i]) {
                    redAns[i] = blueAns[i];
                } else if (redAns[i] == Integer.MAX_VALUE)// 如果都为 [MAX] 证明无法走到
                {
                    redAns[i] = -1;
                }
            }

            return redAns;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}