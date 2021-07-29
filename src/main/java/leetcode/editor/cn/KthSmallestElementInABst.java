//第230题
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 421 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst{
    public static void main(String[] args){
        KthSmallestElementInABst bst = new KthSmallestElementInABst();
        TreeNode node1 = bst.new TreeNode(1, null, null);
        TreeNode node2 = bst.new TreeNode(2, node1, null);
        TreeNode node4 = bst.new TreeNode(4, null, null);
        TreeNode node3 = bst.new TreeNode(3, node2, node4);
        TreeNode node6 = bst.new TreeNode(6, null, null);
        TreeNode root = bst.new TreeNode(5, node3, node6);
        Solution solution = bst.new Solution();
        System.out.println(solution.kthSmallest(root, 2));
    }

    public class TreeNode {
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
    List<Integer> orderedVal = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return orderedVal.get(k-1);
    }

    public Integer dfs(TreeNode node){
        if(node == null){
            return null;
        }
        Integer val = dfs(node.left);
        if(val != null){
            orderedVal.add(val);
        }
        orderedVal.add(node.val);
        val = dfs(node.right);
        if(val != null){
            orderedVal.add(val);
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
