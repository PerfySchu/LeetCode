//Given a sorted linked list, delete all duplicates such that each element appear only once. 
//
// Example 1: 
//
// 
//Input: 1->1->2
//Output: 1->2
// 
//
// Example 2: 
//
// 
//Input: 1->1->2->3->3
//Output: 1->2->3
// 
// Related Topics Linked List
package leetcode.editor.en;
public class RemoveDuplicatesFromSortedList{
    public static void main(String[] args){
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = new RemoveDuplicatesFromSortedList().new ListNode(1);
        head.next = new RemoveDuplicatesFromSortedList().new ListNode(2);
        head.next.next = new RemoveDuplicatesFromSortedList().new ListNode(2);
        head.next.next.next = new RemoveDuplicatesFromSortedList().new ListNode(3);
        head.next.next.next.next = new RemoveDuplicatesFromSortedList().new ListNode(3);
        ListNode res = solution.deleteDuplicates(head);
        System.out.println(res);
    }

    /**
     * 因为是有序链表，那么重复的元素必然在一起出现
     * 所以思路是遍历链表，从根节点开始，后面每个每个节点值跟当前值对比
     * 如果相同则指针直接后移一位
     *
     * 看了一些递归解法，其实可以不用开辟新的链表用来存放结果，
     * 直接判断head，然后后移指针，舍弃原链表中的重复节点即可
     */

    public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res = new ListNode(head.val);
        recursion(head.next, res);
        return res;
    }

    public void recursion(ListNode head, ListNode res){
        if(head == null){
            return;
        }
        if(head.val != res.val){
            res.next = new ListNode(head.val);
            recursion(head.next, res.next);
        }else{
            recursion(head.next, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
