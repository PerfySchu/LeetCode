//2024-04-24 09:21:44
//第2385题
//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。
//
// 每分钟，如果节点满足以下全部条件，就会被感染：
//
//
// 节点此前还没有感染。
// 节点与一个已感染节点相邻。
//
//
// 返回感染整棵树需要的分钟数。
//
//
//
// 示例 1：
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
//
//
// 示例 2：
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
// 每个节点的值 互不相同
// 树中必定存在值为 start 的节点
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 66 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AmountOfTimeForBinaryTreeToBeInfected{
    public static void main(String[] args){
        Solution solution = new AmountOfTimeForBinaryTreeToBeInfected().new Solution();
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2);
        TreeNode node10 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node9, node2);
        TreeNode node3 = new TreeNode(3, node10, node6);
        TreeNode node5 = new TreeNode(5, null, node4);
        TreeNode root = new TreeNode(1, node5, node3);
        System.out.println(solution.amountOfTime(root, 3));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        dfs(graph, root);
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nodeVal = arr[0];
            time = arr[1];
            for (int childVal : graph.get(nodeVal)) {
                if (visited.add(childVal)) {
                    queue.offer(new int[]{childVal, time+1});
                }
            }
        }
        return time;
    }

    public void dfs(Map<Integer, List<Integer>> graph, TreeNode node){
        graph.putIfAbsent(node.val, new ArrayList<>());
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null) {
                graph.get(node.val).add(child.val);
                graph.putIfAbsent(child.val, new ArrayList<>());
                graph.get(child.val).add(node.val);
                dfs(graph, child);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}