//2022-05-16 09:22:32
//第面试题 04.06题
//设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
//
// 如果指定节点没有对应的“下一个”节点，则返回null。
//
// 示例 1:
//
// 输入: root = [2,1,3], p = 1
//
//  2
// / \
//1   3
//
//输出: 2
//
// 示例 2:
//
// 输入: root = [5,3,6,2,4,null,null,1], p = 6
//
//      5
//     / \
//    3   6
//   / \
//  2   4
// /
//1
//
//输出: null
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 109 👎 0

package leetcode.editor.cn;
public class SuccessorLcci{
    public static void main(String[] args){
        Solution solution = new SuccessorLcci().new Solution();
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode cur = root;
        TreeNode ans = null;
        while (cur != null) {
            if(cur.val > target){
                ans = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}