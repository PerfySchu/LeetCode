//2023-05-22 09:15:01
//第1080题
//给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
//
// 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
//
// 叶子节点，就是没有子节点的节点。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
//输出：[1,2,3,4,null,null,7,8,9,null,14]
//
//
// 示例 2：
//
//
//输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
//输出：[5,4,8,11,null,17,4,7,null,null,null,5]
//
//
// 示例 3：
//
//
//输入：root = [1,2,-3,-5,null,4,null], limit = -1
//输出：[1,null,-3,4]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 5000] 内
// -10⁵ <= Node.val <= 10⁵
// -10⁹ <= limit <= 10⁹
//
//
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 102 👎 0

package leetcode.editor.cn;
public class InsufficientNodesInRootToLeafPaths{
    public static void main(String[] args){
        Solution solution = new InsufficientNodesInRootToLeafPaths().new Solution();
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null) {
            return null;
        }
        if(root.left == null && root.right == null){
            if(root.val < limit) {
                return null;
            } else {
                return root;
            }
        }
        root.left = sufficientSubset(root.left, limit - root.val);
        root.right = sufficientSubset(root.right, limit - root.val);
        if(root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}