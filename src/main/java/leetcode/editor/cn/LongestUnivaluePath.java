//2022-09-02 13:42:09
//第687题
//给定一个二叉树的
// root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
//
// 两个节点之间的路径长度 由它们之间的边数表示。
//
//
//
// 示例 1:
//
//
//
//
//输入：root = [5,4,5,1,1,5]
//输出：2
//
//
// 示例 2:
//
//
//
//
//输入：root = [1,4,5,4,4,5]
//输出：2
//
//
//
//
// 提示:
//
//
// 树的节点数的范围是
// [0, 10⁴]
// -1000 <= Node.val <= 1000
// 树的深度将不超过 1000
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 660 👎 0

package leetcode.editor.cn;
public class LongestUnivaluePath{
    public static void main(String[] args){
        Solution solution = new LongestUnivaluePath().new Solution();
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
    int maxAns = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxAns;
    }

    int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int ans = 0;
        int cur = 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(root.left != null && root.left.val == root.val){
            ans = l + 1;
            cur += l + 1;
        }
        if(root.right != null && root.right.val == root.val){
            ans = Math.max(ans, r+1);
            cur += r+1;
        }
        maxAns = Math.max(maxAns, cur);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}