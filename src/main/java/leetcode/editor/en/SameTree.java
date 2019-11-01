//Given two binary trees, write a function to check if they are the same or not. 
//
// Two binary trees are considered the same if they are structurally identical and the nodes have the same value. 
//
// Example 1: 
//
// 
//Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//Output: true
// 
//
// Example 2: 
//
// 
//Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
//Output: false
// 
//
// Example 3: 
//
// 
//Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//Output: false
// 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;
public class SameTree{
    public static void main(String[] args){
        Solution solution = new SameTree().new Solution();
        TreeNode nodep21 = new SameTree().new TreeNode(2);
        TreeNode nodep22 = new SameTree().new TreeNode(1);
        TreeNode p = new SameTree().new TreeNode(1, nodep21, nodep22);
        TreeNode nodeq21 = new SameTree().new TreeNode(2);
        TreeNode nodeq22 = new SameTree().new TreeNode(1);
        TreeNode q = new SameTree().new TreeNode(1, nodeq21, nodeq22);
        System.out.println(solution.isSameTree(p, q));
    }

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null && q!=null){
            if(p.val != q.val){
                return false;
            }
            if(null!=p.left && null!=q.left){
                return isSameTree(p.left, q.left);
            }
            if(null!=p.right && null!=q.right){
                return isSameTree(p.right, q.right);
            }
            return true;
        }else {
            return q == null && p == null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
