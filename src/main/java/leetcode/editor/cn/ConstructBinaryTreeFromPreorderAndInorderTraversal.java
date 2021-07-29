//第105题
//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 1131 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args){
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        System.out.println(solution.buildTree(new int[]{1,2}, new int[]{2,1}));
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

    /**
     * 先序遍历下，序列的第一个是根节点，其次是 左节点 和 根节点
     * 中序遍历下，序列的第一个是左节点，其次是 根节点 和 右节点
     * 此题思路：
     * 1.将先序第一个作为根节点，在中序遍历中找到根节点为位置
     * 2.确定根节点位置后，中序遍历数组中，根的左边都是左子树的数据，右边都是右子树数据
     * 3.根据中序数组中确定的子树范围，可以圈定先序数组中，根，左子树，右子树 数组范围
     * 4.取中序中的左(右)子树和先序的左(右)子树，重复以上过程
     */

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> inList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return buildTree(preList, inList);
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder){
        if(preorder.size() ==0 || inorder.size() ==0){
            return null;
        }
        Integer rootVal = preorder.get(0);
        TreeNode root = new TreeNode(rootVal);
        if(preorder.size()==1 || inorder.size()==1){
            return root;
        }
        int rootIndex = inorder.indexOf(rootVal);
        List<Integer> leftPreorder = preorder.subList(1, rootIndex+1);
        List<Integer> leftInorder = inorder.subList(0, rootIndex);
        List<Integer> rightPreorder = preorder.subList(rootIndex+1, preorder.size());
        List<Integer> rightInorder = inorder.subList(rootIndex+1, inorder.size());
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
