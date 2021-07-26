//第82题
//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 
// 👍 662 👎 0

package leetcode.editor.cn;
public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args){
        RemoveDuplicatesFromSortedListIi sort = new RemoveDuplicatesFromSortedListIi();
        ListNode node5 = sort.new ListNode(5, null);
        ListNode node4 = sort.new ListNode(4, node5);
        ListNode node3 = sort.new ListNode(3, node4);
        ListNode node32 = sort.new ListNode(3, node3);
        ListNode node2 = sort.new ListNode(2, node32);
        ListNode head = sort.new ListNode(1, node2);

        Solution solution = sort.new Solution();
        System.out.println(solution.deleteDuplicates(head));
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //虚拟头结点
        ListNode vHead = new ListNode(0, head);
        //双指针
        ListNode left = vHead;
        ListNode right = vHead.next;
        while (right != null){
            int pre = right.val;
            //preNode 记录当次遍历的起点
            ListNode preNode = null;
            int count = 0;
            while(right != null && right.val == pre){
                count ++;
                preNode = right;
                right = right.next;
            }
            if(count == 1){
                //如果中途没有重复节点，直接将指针接上即可
                left.next = preNode;
                left = left.next;
            }else{
                //如果有重复节点，这将指正直接指向重复节点后一个节点
                left.next = right;
            }
        }

        return vHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
