//2022-08-22 22:11:15
//第655题
//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则：
//
//
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。
// 继续这一过程，直到树中的所有节点都妥善放置。
// 任意空单元格都应该包含空字符串 "" 。
//
//
// 返回构造得到的矩阵 res 。
//
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
//
//
// 示例 2：
//
//
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
//
//
//
//
// 提示：
//
//
// 树中节点数在范围 [1, 2¹⁰] 内
// -99 <= Node.val <= 99
// 树的深度在范围 [1, 10] 内
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 187 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintBinaryTree{
    public static void main(String[] args){
        Solution solution = new PrintBinaryTree().new Solution();
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node1 = new TreeNode(1, node2, null);
        System.out.println(solution.printTree(node1));
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
    private int maxLevel = 0;
    public List<List<String>> printTree(TreeNode root) {
        dfs(root, 0);
        int m = maxLevel + 1;
        int n = (int) (Math.pow(2, maxLevel+1) -1);
        String[][] res = new String[m][n];
        for (String[] re : res) {
            Arrays.fill(re, "");
        }
        int r = 0, c = (n-1)/2;
        res[0][c] = String.valueOf(root.val);
        dfsFill(res, root.left, r+1, (int) (c-Math.pow(2, maxLevel -r - 1)));
        dfsFill(res, root.right, r+1, (int) (c+Math.pow(2, maxLevel -r - 1)));
        List<List<String>> resList = new ArrayList<>();
        for (String[] re : res) {
            resList.add(Arrays.asList(re));
        }
        return resList;
    }

    void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        maxLevel = Math.max(maxLevel, level);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

    void dfsFill(String[][] arr, TreeNode root, int r, int c){
        if(root == null){
            return;
        }
        arr[r][c] = String.valueOf(root.val);
        int lc = (int) (c-Math.pow(2, maxLevel-r-1));
        int rc = (int) (c+Math.pow(2, maxLevel-r-1));
        int row = r+1;
        dfsFill(arr, root.left, row, lc);
        dfsFill(arr, root.right, row, rc);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}