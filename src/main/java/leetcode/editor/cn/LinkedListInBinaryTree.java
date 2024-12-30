//2024-12-30 14:35:38
//第1367题
//给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
//
// 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False
//。
//
// 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
//
//
//
// 示例 1：
//
//
//
// 输入：head = [4,2,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//输出：true
//解释：树中蓝色的节点构成了与链表对应的子路径。
//
//
// 示例 2：
//
//
//
// 输入：head = [1,4,2,6], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//输出：true
//
//
// 示例 3：
//
// 输入：head = [1,4,2,6,8], root = [1,4,4,null,2,2,null,1,null,6,8,null,null,null,
//null,1,3]
//输出：false
//解释：二叉树中不存在一一对应链表的路径。
//
//
//
//
// 提示：
//
//
// 二叉树和链表中的每个节点的值都满足 1 <= node.val <= 100 。
// 链表包含的节点数目在 1 到 100 之间。
// 二叉树包含的节点数目在 1 到 2500 之间。
//
//
// Related Topics 树 深度优先搜索 链表 二叉树 👍 207 👎 0

package leetcode.editor.cn;
public class LinkedListInBinaryTree{
    public static void main(String[] args){
        Solution solution = new LinkedListInBinaryTree().new Solution();
        //ListNode listNode6 = new ListNode(6,null);
        //ListNode listNode2 = new ListNode(2,listNode6);
        //ListNode listNode4 = new ListNode(4,listNode2);
        //ListNode head = new ListNode(1,listNode4);
        //
        //TreeNode treeNode1 = new TreeNode(1,null,null);
        //TreeNode treeNode3 = new TreeNode(3,null,null);
        //TreeNode treeNode8 = new TreeNode(8,treeNode1,treeNode3);
        //TreeNode treeNode6 = new TreeNode(6,null,null);
        //TreeNode treeNode2 = new TreeNode(2,treeNode6,treeNode8);
        //TreeNode treeNode4 = new TreeNode(4,treeNode2,null);
        //TreeNode treeNode1_1 = new TreeNode(1,null,null);
        //TreeNode treeNode1_2 = new TreeNode(2,treeNode1_1,null);
        //TreeNode treeNode1_4 = new TreeNode(4,null,treeNode1_2);
        //TreeNode root = new TreeNode(1,treeNode1_4,treeNode4);

        ListNode listNode2 = new ListNode(2,null);
        ListNode head = new ListNode(4,listNode2);

        TreeNode treeNode2 = new TreeNode(2,null,null);
        TreeNode treeNode1 = new TreeNode(1,treeNode2,null);
        TreeNode treeNode4 = new TreeNode(4,treeNode1,null);
        TreeNode treeNode2_4 = new TreeNode(4,null,null);
        TreeNode root = new TreeNode(4,treeNode4,treeNode2_4);

        System.out.println(solution.isSubPath(head, root));
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode head;
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    boolean dfs(ListNode current, TreeNode node){
        if(current == null){
            return true;
        }
        if(node == null){
            return false;
        }
        if(current.val == node.val){
            return dfs(current.next, node.left) || dfs(current.next, node.right);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}