//2022-03-30 18:14:33
//第606题
//你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
//
// 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
//
// 示例 1:
//
//
//输入: 二叉树: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
//输出: "1(2(4))(3)"
//
//解释: 原本将是“1(2(4)())(3())”，
//在你省略所有不必要的空括号对之后，
//它将是“1(2(4))(3)”。
//
//
// 示例 2:
//
//
//输入: 二叉树: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
//输出: "1(2()(4))(3)"
//
//解释: 和第一个示例相似，
//除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 316 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ConstructStringFromBinaryTree{
    public static void main(String[] args){
        Solution solution = new ConstructStringFromBinaryTree().new Solution();
    }

    public static class TreeNode {
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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        firstDfs(root);
        return sb.substring(1, sb.length() - 1);
    }

    void firstDfs(TreeNode root){
        if (root != null) {
            sb.append("(");
            sb.append(root.val);
            if (root.left != null) {
                firstDfs(root.left);
            }
            else if (root.right != null){
                sb.append("()");
            }
            if (root.right != null){
                firstDfs(root.right);
            }
            sb.append(")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}