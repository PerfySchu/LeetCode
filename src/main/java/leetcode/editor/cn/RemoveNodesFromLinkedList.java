//2024-01-03 09:21:35
//第2487题
//给你一个链表的头节点 head 。
//
// 移除每个右侧有一个更大数值的节点。
//
// 返回修改后链表的头节点 head 。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
//
//
//
//
// 提示：
//
//
// 给定列表中的节点数目在范围 [1, 10⁵] 内
// 1 <= Node.val <= 10⁵
//
//
// Related Topics 栈 递归 链表 单调栈 👍 51 👎 0

package leetcode.editor.cn;
public class RemoveNodesFromLinkedList{
    public static void main(String[] args){
        Solution solution = new RemoveNodesFromLinkedList().new Solution();
        //5,2,13,3,8
        ListNode node8 = new RemoveNodesFromLinkedList.ListNode(8, null);
        ListNode node3 = new RemoveNodesFromLinkedList.ListNode(3, node8);
        ListNode node13 = new RemoveNodesFromLinkedList.ListNode(13, null);
        ListNode node2 = new RemoveNodesFromLinkedList.ListNode(2, node13);
        ListNode node5 = new RemoveNodesFromLinkedList.ListNode(5, node2);
        System.out.println(solution.removeNodes(node5));
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
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNodes(head.next);
        if(head.next != null && head.val < head.next.val){
            return head.next;
        }else {
            return head;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}