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
        TreeNode nodeq21 = new SameTree().new TreeNode(1);
        TreeNode nodeq22 = new SameTree().new TreeNode(2);
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

    /**
     * 考虑树的遍历，对 p 和 q 同时遍历（先序遍历），
     * 基本思路是：
     * 1.判断根节点是否相同，不同则直接返回 false， 若两节点都为 null则返回 true
     * 2.判断左子树是否都非空，若都非空，则进入递归，否则返回false
     * 3.对右子树做同样的判断
     * 4.当所有节点都遍历完成，则返回true
     *
     * 期间遇到的问题就是，当左子树到了最底层的时候，程序直接返回了， 没有返回上层递归继续判断右子树
     * 这就是代码短路效应？
     * 也就是说左子树递归到了最内层的结束条件导致整个函数返回
     * 概括来说就是，当递归内分出两个子递归，每个子递归单独触及结束条件时，都会导致程序结束
     *
     * 后续看了一些解法，为了避免短路效应， 可以将最终返回条件设为 左子树true && 右子树true
     * 如此一来，及时左子树到了最内层，因为后面有一个 and 判断，也会继续执行右子树判断，
     * 因此可以成功的避免短路
     * 概括讲就是，如果递归结束需要综合每个自递归的条件，则在 return 语句中对子递归进行合并判断能有效避免短路
     */
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
            /*
             * 这种写法会导致代码短路，只能判断单侧子树
            if(null!=p.left && null!=q.left){
                return isSameTree(p.left, q.left);
            }
            if(null!=p.right && null!=q.right){
                return isSameTree(p.right, q.right);
            }
             */
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return q == null && p == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
