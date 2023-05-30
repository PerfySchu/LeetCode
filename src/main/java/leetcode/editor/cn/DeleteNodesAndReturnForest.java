//2023-05-30 13:42:32
//第1110题
//给出二叉树的根节点 root，树上每个节点都有一个不同的值。
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。
//
//
//
// 示例 1：
//
//
//
//
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
//
//
//
//
// 提示：
//
//
// 树中的节点数最大为 1000。
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
// to_delete.length <= 1000
// to_delete 包含一些从 1 到 1000、各不相同的值。
//
//
// Related Topics 树 深度优先搜索 数组 哈希表 二叉树 👍 257 👎 0

package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest{
    public static void main(String[] args){
        Solution solution = new DeleteNodesAndReturnForest().new Solution();
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node5 = new TreeNode(7);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(solution.delNodes(node1, new int[]{3, 5}));
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
    List<TreeNode> ans = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) {
            set.add(i);
        }
        dfs(root, true);
        return ans;
    }

    TreeNode dfs(TreeNode node, boolean isRoot){
        if (node == null) {
            return null;
        }
        boolean isDelete = set.contains(node.val);
        node.left = dfs(node.left, isDelete);
        node.right = dfs(node.right, isDelete);
        if (isDelete) {
            return null;
        }else {
            if (isRoot) {
                ans.add(node);
            }
            return node;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}