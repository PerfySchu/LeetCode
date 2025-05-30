//2025-05-30 10:57:51
//第2359题
//给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
//
// 有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么
//edges[i] == -1 。
//
// 同时给你两个节点 node1 和 node2 。
//
// 请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。如果有多个答案，请
//返回 最小 的节点编号。如果答案不存在，返回 -1 。
//
// 注意 edges 可能包含环。
//
//
//
// 示例 1：
//
//
//
// 输入：edges = [2,2,3,-1], node1 = 0, node2 = 1
//输出：2
//解释：从节点 0 到节点 2 的距离为 1 ，从节点 1 到节点 2 的距离为 1 。
//两个距离的较大值为 1 。我们无法得到一个比 1 更小的较大值，所以我们返回节点 2 。
//
//
// 示例 2：
//
//
//
// 输入：edges = [1,2,-1], node1 = 0, node2 = 2
//输出：2
//解释：节点 0 到节点 2 的距离为 2 ，节点 2 到它自己的距离为 0 。
//两个距离的较大值为 2 。我们无法得到一个比 2 更小的较大值，所以我们返回节点 2 。
//
//
//
//
// 提示：
//
//
// n == edges.length
// 2 <= n <= 10⁵
// -1 <= edges[i] < n
// edges[i] != i
// 0 <= node1, node2 < n
//
//
// Related Topics 深度优先搜索 图 👍 38 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class FindClosestNodeToGivenTwoNodes{
    public static void main(String[] args){
        Solution solution = new FindClosestNodeToGivenTwoNodes().new Solution();
        System.out.println(solution.closestMeetingNode(new int[]{2,2,3,-1}, 0, 1));
        System.out.println(solution.closestMeetingNode(new int[]{1,2,-1}, 0, 2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] distance1 = getDistance(edges, node1);
        int[] distance2 = getDistance(edges, node2);
        int minDistNode = -1;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (distance1[i] == Integer.MAX_VALUE || distance2[i] == Integer.MAX_VALUE) {
                continue;
            }
            int maxDist = Math.max(distance1[i], distance2[i]);
            if (maxDist < minDist) {
                minDist = maxDist;
                minDistNode = i;
            }
        }
        return minDistNode;
    }

    private int[] getDistance(int[] edges, int node) {
        int n = edges.length;
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        int dist = 0;
        while (node != -1 && distance[node] == Integer.MAX_VALUE) {
            distance[node] = dist++;
            node = edges[node];
        }
        return distance;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}