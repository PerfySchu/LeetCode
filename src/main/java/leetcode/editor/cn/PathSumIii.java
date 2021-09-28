//2021-09-28 16:02:10
//第437题
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1071 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

public class PathSumIii{
    public static void main(String[] args){
        PathSumIii pathSumIii = new PathSumIii();
        Solution solution = pathSumIii.new Solution();
        TreeNode treeNode13 = pathSumIii.new TreeNode(5, null, null);
        TreeNode treeNode12 = pathSumIii.new TreeNode(5, null, null);
        TreeNode treeNode11 = pathSumIii.new TreeNode(5, null, null);
        TreeNode treeNode23 = pathSumIii.new TreeNode(3, treeNode13, treeNode12);
        TreeNode treeNode22 = pathSumIii.new TreeNode(2, null, treeNode11);
        TreeNode treeNode211 = pathSumIii.new TreeNode(11, null, null);
        TreeNode treeNode35 = pathSumIii.new TreeNode(5, treeNode23, treeNode22);
        TreeNode treeNode33 = pathSumIii.new TreeNode(-3, null, treeNode211);
        TreeNode root = pathSumIii.new TreeNode(10, treeNode35, treeNode33);

        System.out.println(solution.pathSum(root, 8));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

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
    public int pathSum(TreeNode root, int targetSum) {
        //路径前缀和
        HashMap<Long, Integer> prefix = new HashMap<>();
        //为根节点设置一个0
        prefix.put(0L, 1);
        //树的深度优先遍历
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, HashMap<Long, Integer> prefix, long curr, int targetSum){
        if(root == null){
            return 0;
        }
        //当前节点路径之和
        curr += root.val;

        //判断前缀和中是否有与当前节点匹配的解
        //例如 当前 curr=18, 目标 targetSum=8, 如果 map 中存在 18-8 =10，则符合题目要求
        int res = prefix.getOrDefault(curr - targetSum, 0);

        //记录当前前缀和
        prefix.put(curr, prefix.getOrDefault(curr, 0)+1);

        //递归左子树和右子树
        res += dfs(root.left, prefix, curr, targetSum);
        res += dfs(root.right, prefix, curr, targetSum);

        //回退一层，移除当前结果
        prefix.put(curr, prefix.getOrDefault(curr, 0)-1);

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
