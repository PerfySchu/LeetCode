//Given a binary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node. 
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
// return its depth = 3. 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;
public class MaximumDepthOfBinaryTree{
    public static void main(String[] args){
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
        TreeNode node31 = new MaximumDepthOfBinaryTree().new TreeNode(15);
        TreeNode node32 = new MaximumDepthOfBinaryTree().new TreeNode(7);
        TreeNode node21 = new MaximumDepthOfBinaryTree().new TreeNode(9);
        TreeNode node22 = new MaximumDepthOfBinaryTree().new TreeNode(20, node31, node32);
        TreeNode root = new MaximumDepthOfBinaryTree().new TreeNode(3, node21, node22);
        System.out.println(solution.maxDepth(root));
    }

    /**
     * 获取一个二叉树深度的基本思想是：
     * 1.只有根节点，没有左右子树，则深度为 1,当然如果根节点也是null，则深度为0
     * 2.只有左子树，右子树为null， 则深度为 左子树的深度 + 1
     * 3.只有右子树，左子树为null， 则深度为 右子树深度 + 1
     * 4.左右子树都不为空， 则 深度为 左右子树深度较大者 +1
     *
     * 接下来就是找到递归结束条件了，
     * 结束条件应该是左右子树都为null的情况
     * 同时，因为涉及到左右子树两个单独的遍历，同时还要考虑代码短路提前return的情况
     * 最终可以得到一个单行的解法，递归的奇技淫巧
     */

    class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val = x;
    }
    TreeNode(int x, TreeNode left, TreeNode right){
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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        /* 下面这个判断可有可无
        if(root.left == null && root.right == null){
            return 1;
        }
        */
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
