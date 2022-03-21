//2022-03-21 09:24:16
//第653题
//给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//
//
// 示例 1：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 9
//输出: true
//
//
// 示例 2：
//
//
//输入: root = [5,3,6,2,4,null,7], k = 28
//输出: false
//
//
//
//
// 提示:
//
//
// 二叉树的节点个数的范围是 [1, 10⁴].
// -10⁴ <= Node.val <= 10⁴
// root 为二叉搜索树
// -10⁵ <= k <= 10⁵
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉搜索树 哈希表 双指针 二叉树 👍 332 👎 0

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIvInputIsABst{
    public static void main(String[] args){
        Solution solution = new TwoSumIvInputIsABst().new Solution();
        TwoSumIvInputIsABst two = new TwoSumIvInputIsABst();
        TreeNode node2 = two.new TreeNode(2);
        TreeNode node4 = two.new TreeNode(4);
        TreeNode node7 = two.new TreeNode(7);
        TreeNode node3 = two.new TreeNode(3, node2, node4);
        TreeNode node6 = two.new TreeNode(6, null, node7);
        TreeNode root = two.new TreeNode(5, node3, node6);
        solution.findTarget(root, 9);
    }
    class TreeNode {
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
    Set<Integer> set = new HashSet<>();
    boolean contains = false;
    public boolean findTarget(TreeNode root, int k) {
        dfs(root, k);
        return contains;
    }
    void dfs(TreeNode root, int k){
        if(root != null){
            if (set.contains(k - root.val)) {
                contains = true;
                return;
            }
            set.add(root.val);
            findTarget(root.left, k);
            findTarget(root.right, k);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}