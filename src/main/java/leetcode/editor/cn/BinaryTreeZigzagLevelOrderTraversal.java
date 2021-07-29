//第103题
//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 480 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args){
        BinaryTreeZigzagLevelOrderTraversal traversal = new BinaryTreeZigzagLevelOrderTraversal();
        BinaryTreeZigzagLevelOrderTraversal.TreeNode node15 = traversal.new TreeNode(15, null, null);
        BinaryTreeZigzagLevelOrderTraversal.TreeNode node7 = traversal.new TreeNode(7, null, null);
        BinaryTreeZigzagLevelOrderTraversal.TreeNode node9 = traversal.new TreeNode(9, null, null);
        BinaryTreeZigzagLevelOrderTraversal.TreeNode node20 = traversal.new TreeNode(20, node15, node7);
        BinaryTreeZigzagLevelOrderTraversal.TreeNode root = traversal.new TreeNode(3, node9, node20);
        BinaryTreeZigzagLevelOrderTraversal.Solution solution = traversal.new Solution();
        System.out.println(solution.zigzagLevelOrder(root));
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        boolean leftToRight = false;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        while (!nodes.isEmpty()){
            Deque<Integer> list = new LinkedList<>();
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if(leftToRight) {
                    list.offerFirst(node.val);
                }else{
                    list.offerLast(node.val);
                }
                if(node.left!=null){
                    nodes.offer(node.left);
                }
                if(node.right!=null){
                    nodes.offer(node.right);
                }
            }
            result.add((List<Integer>) list);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
