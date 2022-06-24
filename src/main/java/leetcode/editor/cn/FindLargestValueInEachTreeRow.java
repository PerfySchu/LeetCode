//2022-06-24 16:46:48
//第515题
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
//
//
// 示例1：
//
//
//
//
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
//
//
// 示例2：
//
//
//输入: root = [1,2,3]
//输出: [1,3]
//
//
//
//
// 提示：
//
//
// 二叉树的节点个数的范围是 [0,10⁴]
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 234 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLargestValueInEachTreeRow{
    public static void main(String[] args){
        Solution solution = new FindLargestValueInEachTreeRow().new Solution();
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
    Map<Integer, Integer> levelMap = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 1);
        List<Integer> ans = new ArrayList<>();
        levelMap.forEach((k, v) ->{
            ans.add(v);
        });
        return ans;
    }

    private void dfs(TreeNode node, int level){
        if(node == null){
            return;
        }
        Integer max = levelMap.getOrDefault(level, node.val);
        levelMap.put(level, Math.max(max, node.val));
        dfs(node.left, level+1);
        dfs(node.right, level+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}