//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level). 
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
//return its level order traversal as: 
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics Tree Breadth-first Search
package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        TreeNode node31 = new BinaryTreeLevelOrderTraversal().new TreeNode(15);
        TreeNode node32 = new BinaryTreeLevelOrderTraversal().new TreeNode(7);
        TreeNode node21 = new BinaryTreeLevelOrderTraversal().new TreeNode(9);
        TreeNode node22 = new BinaryTreeLevelOrderTraversal().new TreeNode(20, node31, node32);
        TreeNode root = new BinaryTreeLevelOrderTraversal().new TreeNode(15, node21, node22);
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }

    /**
     * 二叉树遍历，深度优先算法
     * 使用一个变量 level 标识层级，方便构建结果列表
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        deepFirst(root, 0, result);
        return result;
    }

    private void deepFirst(TreeNode root, int level, List<List<Integer>> result){
        if(root == null){
            return;
        }

        //如果当前结果列表小于当前层级，则结果集中新建一个层级
        if(result.size() <= level){
            result.add(new ArrayList<>());
        }
        //添加当前元素到当前层级中
        result.get(level).add(root.val);

        //递归左右子树
        deepFirst(root.left, level + 1, result);
        deepFirst(root.right, level + 1, result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
