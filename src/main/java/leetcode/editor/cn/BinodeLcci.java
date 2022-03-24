//2022-03-24 23:50:32
//第面试题 17.12题
//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
//
// 返回转换后的单向链表的头节点。
//
// 注意：本题相对原题稍作改动
//
//
//
// 示例：
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
//
//
// 提示：
//
//
// 节点数量不会超过 100000。
//
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 👍 99 👎 0

package leetcode.editor.cn;
public class BinodeLcci{
    public static void main(String[] args){
        Solution solution = new BinodeLcci().new Solution();
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
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
    TreeNode head = new TreeNode(-1);
    TreeNode prev = null;
    public TreeNode convertBiNode(TreeNode root) {
        dfs(root);
        return head.right;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        if (prev == null){
            prev = node;
            head.right = node;
        }else{
            prev.right = node;
            prev = node;
        }
        node.left = null;
        dfs(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}