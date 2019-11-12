//Given an array where elements are sorted in ascending order, convert it to a height balanced BST. 
//
// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
//
// Example: 
//
// 
//Given the sorted array: [-10,-3,0,5,9],
//
//One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics Tree Depth-first Search
package leetcode.editor.en;
public class ConvertSortedArrayToBinarySearchTree{
    public static void main(String[] args){
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        System.out.println(solution.sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    /**
     * 这题初看起来就是二叉树中序遍历的逆向过程
     * 首先找到根节点，对于搜索树，根节点肯定是中位数
     * 确定根节点后，数组就被分成左右两部分，左部分用来生成左子树，右部分生成右子树
     * 左右子树的生成方法和根节点一样，也是先获取中位数节点，再处理左右子树
     * 结束条件是用来生成子树的数组为空
     */

    class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }

    TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length);
    }

    private TreeNode bst(int[] nums, int start, int end){
        if(end == start){
            return null;
        }
        int midIndex = (end+start)/2;
        return new TreeNode(nums[midIndex], bst(nums, start, midIndex), bst(nums, midIndex+1, end));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
