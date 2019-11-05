//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root). 
//
// 
//For example: 
//Given binary tree [3,9,20,null,null,15,7], 
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
// 
// 
//return its bottom-up level order traversal as: 
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics Tree Breadth-first Search
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversalIi().new Solution();
        TreeNode node31 = new BinaryTreeLevelOrderTraversalIi().new TreeNode(15);
        TreeNode node32 = new BinaryTreeLevelOrderTraversalIi().new TreeNode(7);
        TreeNode node21 = new BinaryTreeLevelOrderTraversalIi().new TreeNode(9);
        TreeNode node22 = new BinaryTreeLevelOrderTraversalIi().new TreeNode(20, node31, node32);
        TreeNode root = new BinaryTreeLevelOrderTraversalIi().new TreeNode(15, node21, node22);
        List<List<Integer>> result = solution.levelOrderBottom(root);
        System.out.println(result);
    }

    /**
     * 二叉树的层次遍历之前有了解过
     * 不过那种使用队列的方式只能体现层次的先后，并不能体现具体层次
     *
     * 所以了解各路大神的解法后，大概知道了用 深度优先DFS 和 广度优先BFS
     * 的方法来遍历树，比较方便获取层次信息
     *
     * 以下以深度优先为例
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = x;
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        deepFirst(root, 0, result);
        return result;
    }

    private void deepFirst(TreeNode root, int level, List<List<Integer>> result){
        if (root == null) {
            return;
        }
        //当前层无元素，则添加当前层的List
        if(result.size() <= level){
            //指定下标为0，保证倒排（每次新插入层都在第一顺位）
            result.add(0, new ArrayList<>());
        }
        //加入当前节点的值
        result.get(result.size()-1-level).add(root.val);

        //遍历左子树
        deepFirst(root.left, level+1, result);
        //遍历右子树
        deepFirst(root.right, level + 1, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
