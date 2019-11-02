//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center). 
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
//
// 
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// But the following [1,2,2,null,3,null,3] is not: 
//
// 
//    1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// Note: 
//Bonus points if you could solve it both recursively and iteratively. 
// Related Topics Tree Depth-first Search Breadth-first Search
package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree{
    public static void main(String[] args){
        Solution solution = new SymmetricTree().new Solution();

        TreeNode node31 = new SymmetricTree().new TreeNode(3);
        TreeNode node32 = new SymmetricTree().new TreeNode(4);
        TreeNode node33 = new SymmetricTree().new TreeNode(4);
        TreeNode node34 = new SymmetricTree().new TreeNode(3);
        TreeNode node21 = new SymmetricTree().new TreeNode(2, node31, node32);
        TreeNode node22 = new SymmetricTree().new TreeNode(2, node33, node34);
        TreeNode root = new SymmetricTree().new TreeNode(1, node21, node22);
        System.out.println(solution.isSymmetric(root));
    }

    /**
     * 判断二叉树的对称性
     * 首先想到的是采用层序遍历，
     * 从根节点开始，每层的首尾节点对比，一旦发现不等即返回 false
     * 实际操作过程中发现迭代过程中并不太方便判断的节点的层级
     * 因为层次遍历过程中，虽然节点是按层次顺序进入队列的，但同一时刻队列里面可能会存在几个层级的节点，
     * 不能很好地分辨处理同一个层级的节点
     *
     * 转换一下思维，在一个二叉树里面判断左右对称不太方便，
     * 那么可以在两个一模一样的二叉树里面判断左右是否对称
     * 也即是：
     * 1.从根节点开始，1号树取左子树， 2号树取右子树
     * 2.对两个子树根节点进行判空和相等判断
     * 3.根节点相等，则递归对子节点也进行同样的操作，原则就是一个子树取左节点，那另一个就取右，保持对称性
     *
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
