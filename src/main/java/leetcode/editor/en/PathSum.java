//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum. 
//
// Note: A leaf is a node with no children. 
//
// Example: 
//
// Given the below binary tree and sum = 22, 
//
// 
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
//7    2      1
// 
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22. 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;
public class PathSum{
    public static void main(String[] args){
        Solution solution = new PathSum().new Solution();
        TreeNode node41 = new PathSum().new TreeNode(7);
        TreeNode node42 = new PathSum().new TreeNode(2);
        TreeNode node43 = new PathSum().new TreeNode(1);
        TreeNode node31 = new PathSum().new TreeNode(11, node41, node42);
        TreeNode node32 = new PathSum().new TreeNode(13);
        TreeNode node33 = new PathSum().new TreeNode(4, null, node43);
        TreeNode node21 = new PathSum().new TreeNode(4, node31, null);
        TreeNode node22 = new PathSum().new TreeNode(8, node32, node33);
        TreeNode root = new PathSum().new TreeNode(5, node21, node22);
        System.out.println(solution.hasPathSum(root, 22));
    }

    /**
     *
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }else{
                return false;
            }
        }
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
