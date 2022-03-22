//2022-03-22 09:26:19
//第501题
//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。
//
// 假定 BST 满足如下定义：
//
//
// 结点左子树中所含节点的值 小于等于 当前节点的值
// 结点右子树中所含节点的值 大于等于 当前节点的值
// 左子树和右子树都是二叉搜索树
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中节点的数目在范围 [1, 10⁴] 内
// -10⁵ <= Node.val <= 10⁵
//
//
//
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 426 👎 0

package leetcode.editor.cn;

import java.util.*;

public class FindModeInBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new FindModeInBinarySearchTree().new Solution();
        TreeNode node2 = new FindModeInBinarySearchTree().new TreeNode(2);
        TreeNode node1 = new FindModeInBinarySearchTree().new TreeNode(1, null, node2);
        solution.findMode(node1);
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
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int max = 0;
        Set<Integer> res = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max){
                res = new HashSet<>();
                res.add(entry.getKey());
                max = entry.getValue();
            }else if(entry.getValue() == max){
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (Integer re : res) {
            ans[i++] = re;
        }
        return ans;
    }

    void dfs(TreeNode node){
        if (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}