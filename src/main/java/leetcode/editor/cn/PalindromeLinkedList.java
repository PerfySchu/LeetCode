//2022-01-26 17:44:10
//第234题
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1244 👎 0

package leetcode.editor.cn;

import java.util.Stack;

public class PalindromeLinkedList{
    public static void main(String[] args){
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode node1 = new PalindromeLinkedList().new ListNode(1);
        ListNode node2 = new PalindromeLinkedList().new ListNode(2, node1);
        ListNode node3 = new PalindromeLinkedList().new ListNode(2, node2);
        ListNode node4 = new PalindromeLinkedList().new ListNode(1, node3);
        solution.isPalindrome(node4);
    }

    public class ListNode {
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
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode root = head;
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        while(root != null){
            if (stack.pop() != root.val) {
                return false;
            }
            root = root.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}