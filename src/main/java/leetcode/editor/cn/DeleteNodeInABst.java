//第450题
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 二叉搜索树 二叉树 
// 👍 486 👎 0

package leetcode.editor.cn;
public class DeleteNodeInABst{
    /**
     * 并保证二叉搜索树的性质不变
     * 二叉搜索树的性质：二叉搜索树的中序遍历结果是递增序列
     *
     * 删除分情况讨论：
     * 1.待删除节点是叶子节点，直接删除
     * 2.待删除节点只有一个子树（左或者右），直接用子树替代被删除节点
     * 3.被删除节点有左右子树，用右子树的最左值替换当前节点，并删除最左值节点
     *
     */

    public static void main(String[] args){
        DeleteNodeInABst deleteNode = new DeleteNodeInABst();
        TreeNode node2 = deleteNode.new TreeNode(2, null, null);
        TreeNode node4 = deleteNode.new TreeNode(4, null, null);
        TreeNode node7 = deleteNode.new TreeNode(7, null, null);
        TreeNode node3 = deleteNode.new TreeNode(3, node2, node4);
        TreeNode node6 = deleteNode.new TreeNode(6, null, node7);
        TreeNode root = deleteNode.new TreeNode(5, node3, node6);
        Solution solution = deleteNode.new Solution();
        System.out.println(solution.deleteNode(root, 3));
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            //找到待删除节点，进行删除操作
            if(root.left != null && root.right != null){
                //寻找中序后继节点，即右子树的最左叶子结点
                TreeNode prev = root;
                TreeNode next = root.right;
                while (next.left != null){
                    prev = next;
                    next = next.left;
                }
                //删除最左节叶子节点
                if(prev == root){
                    prev.right = next.right;
                }else{
                    prev.left = next.right;
                }
                //替换当前节点值
                root.val = next.val;
            }else if(root.left == null){
                return root.right;
            }else{
                return root.left;
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
