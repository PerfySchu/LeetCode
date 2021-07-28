//第113题
//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
// 
// 
// Related Topics 树 深度优先搜索 回溯 二叉树 
// 👍 535 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PathSumIi{
    public static void main(String[] args){
        PathSumIi sum = new PathSumIi();
        TreeNode node7 = sum.new TreeNode(7, null, null);
        TreeNode node2 = sum.new TreeNode(2, null, null);
        TreeNode node5 = sum.new TreeNode(5, null, null);
        TreeNode node1 = sum.new TreeNode(1, null, null);
        TreeNode node11 = sum.new TreeNode(11, node7, node2);
        TreeNode node13 = sum.new TreeNode(13, null, null);
        TreeNode node42 = sum.new TreeNode(4, node5, node1);
        TreeNode node41 = sum.new TreeNode(4, node11, null);
        TreeNode node8 = sum.new TreeNode(8, node13, node42);
        TreeNode root = sum.new TreeNode(5, node41, node8);
        Solution solution = sum.new Solution();
        System.out.println(solution.pathSum(root, 22));
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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,  targetSum, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode node, int targetSum, List<Integer> temp){
        if(node == null){
            return;
        }
        temp.add(node.val);
        targetSum-=node.val;
        if(targetSum == 0 && node.left==null && node.right==null){
            result.add(new ArrayList<>(temp));
        }
        dfs(node.left, targetSum, temp);
        dfs(node.right, targetSum, temp);
        temp.remove(temp.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
