//Given a linked list, remove the n-th node from the end of list and return its head. 
//
// Example: 
//
// 
//Given linked list: 1->2->3->4->5, and n = 2.
//
//After removing the second node from the end, the linked list becomes 1->2->3->5.
// 
//
// Note: 
//
// Given n will always be valid. 
//
// Follow up: 
//
// Could you do this in one pass? 
// Related Topics Linked List Two Pointers
package leetcode.editor.en;
public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args){
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node5 = new RemoveNthNodeFromEndOfList().new ListNode(5);
        ListNode node4 = new RemoveNthNodeFromEndOfList().new ListNode(4);
        ListNode node3 = new RemoveNthNodeFromEndOfList().new ListNode(3);
        ListNode node2 = new RemoveNthNodeFromEndOfList().new ListNode(2);
        ListNode node1 = new RemoveNthNodeFromEndOfList().new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(solution.removeNthFromEnd(node1, 2));
    }

    /**
     * 链表单次循环的解法还真是没想到
     * 参考了一下大神的双指针解法
     * 让第一个指针和第二个指针一前一后相距为 N
     * 那么当第一个指针指向链表末尾时
     * 第二个指针必然指向 length-N 的地方，即倒数第N+1个节点
     * 此时让 指针二所在位置的 next指向 next的next即可
     *
     * 确实是双指针妙用啊
     */

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode flagNode1 = head;
        ListNode flagNode2 = head;
        for (int i = 0; i < n; i++) {
            flagNode1 = flagNode1.next;
            if(flagNode1 ==  null){
                return head.next;
            }
        }
        while(flagNode1.next != null){
            flagNode1 = flagNode1.next;
            flagNode2 = flagNode2.next;
        }
        flagNode2.next = flagNode2.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
