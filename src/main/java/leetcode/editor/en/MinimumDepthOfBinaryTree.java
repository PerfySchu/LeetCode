//Given a binary tree, find its minimum depth. 
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given binary tree [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7 
//
// return its minimum depth = 2. 
// Related Topics Tree Depth-first Search Breadth-first Search
package leetcode.editor.en;
public class MinimumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
        TreeNode node31 = new MinimumDepthOfBinaryTree().new TreeNode(15);
        TreeNode node32 = new MinimumDepthOfBinaryTree().new TreeNode(7);
        TreeNode node21 = new MinimumDepthOfBinaryTree().new TreeNode(9);
        TreeNode node22 = new MinimumDepthOfBinaryTree().new TreeNode(20, node31, node32);
        TreeNode root = new MinimumDepthOfBinaryTree().new TreeNode(15, node21, node22);
        System.out.println(solution.minDepth(root));
    }

    /**
     * 之前有做过一题 求解二叉树的最大深度
     * 这个题目与之相似，按之前的解法，直接求解左右子树中深度的最小值，然后 +1 即可
     * 后来发现问题，当单侧子树为空时，不能参与最小深度的比较，而应该取不为空的那个子树中的最小深度
     * 因此相比于最大深度计算，最小深度会做出两个判断，即左子树为空的时候，用右子树计算最小深度，右子树为空时，用左子树计算最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null){
            return 1 + minDepth(root.right);
        }
        if(root.right == null){
            return 1 + minDepth(root.left);
        }
        return 1 + Integer.min(minDepth(root.left), minDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
