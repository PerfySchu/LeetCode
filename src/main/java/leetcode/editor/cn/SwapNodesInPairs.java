//2021-10-18 23:15:43
//第24题
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 👍 1078 👎 0

package leetcode.editor.cn;
public class SwapNodesInPairs{
    public static void main(String[] args){
        Solution solution = new SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution2{
        public ListNode swapPairs(ListNode head){
            if(head == null || head.next == null){
                return head;
            }
            ListNode virtualNode = new ListNode();
            virtualNode.next = head;
            ListNode temp = virtualNode;
            while (temp != null && temp.next.next != null){
                ListNode nextNode = temp.next;
                ListNode nextNextNode = nextNode.next;
                temp.next = nextNextNode;
                nextNode.next = nextNextNode.next;
                nextNextNode.next = nextNode;
                temp =  nextNode;
            }
            return virtualNode.next;
        }
    }
}