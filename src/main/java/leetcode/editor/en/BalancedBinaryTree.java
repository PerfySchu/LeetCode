//Given a binary tree, determine if it is height-balanced. 
//
// For this problem, a height-balanced binary tree is defined as: 
//
// 
// a binary tree in which the left and right subtrees of every node differ in height by no more than 1. 
// 
//
// 
//
// Example 1: 
//
// Given the following tree [3,9,20,null,null,15,7]: 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// Return true. 
// 
//Example 2: 
//
// Given the following tree [1,2,2,3,3,null,null,4,4]: 
//
// 
//       1
//      / \
//     2   2
//    / \
//   3   3
//  / \
// 4   4
// 
//
// Return false. 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;
public class BalancedBinaryTree{
    public static void main(String[] args){
        Solution solution = new BalancedBinaryTree().new Solution();
        TreeNode node31 = new BalancedBinaryTree().new TreeNode(15);
        TreeNode node32 = new BalancedBinaryTree().new TreeNode(7);
        TreeNode node21 = new BalancedBinaryTree().new TreeNode(9);
        TreeNode node22 = new BalancedBinaryTree().new TreeNode(20, node31, node32);
        TreeNode root = new BalancedBinaryTree().new TreeNode(15, node21, node22);
        System.out.println(solution.isBalanced(root));
    }

    /**
     * 平衡二叉树的判断
     * 平衡二叉树的概念：一棵树任意节点的左右子树高度相差不能大于1
     * 那么直观的想法就是遍历一棵树，判断其左右节点的高度差值即可
     * 而二叉树深度的获取方法在之前有个题目里面做过
     *
     * 所以这题会涉及到两个递归，一个是遍历节点所需，另一个是判断高度所需
     * (真是个暴力的解法)
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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int sub = maxDepth(root.left)-maxDepth(root.right);
        if(sub>1 || sub<-1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
