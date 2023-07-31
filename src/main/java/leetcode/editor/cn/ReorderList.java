//2023-07-31 09:21:26
//第143题
//给定一个单链表 L 的头节点 head ，单链表 L 表示为：
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// 请将其重新排列后变为：
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例 1：
//
//
//
//
//输入：head = [1,2,3,4]
//输出：[1,4,2,3]
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5]
//输出：[1,5,2,4,3]
//
//
//
// 提示：
//
//
// 链表的长度范围为 [1, 5 * 10⁴]
// 1 <= node.val <= 1000
//
//
// Related Topics 栈 递归 链表 双指针 👍 1257 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ReorderList{
    public static void main(String[] args){
        Solution solution = new ReorderList().new Solution();
        ListNode node5 = new ReorderList().new ListNode(5);
        ListNode node4 = new ReorderList().new ListNode(4, node5);
        ListNode node3 = new ReorderList().new ListNode(3, node4);
        ListNode node2 = new ReorderList().new ListNode(2, node3);
        ListNode node1 = new ReorderList().new ListNode(1, node2);
        solution.reorderList(node1);
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
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        list.add(head);

        while (list.get(list.size()-1).next != null) {
            list.add(list.get(list.size()-1).next);
        }
        int half = list.size() / 2 + list.size()%2;
        for (int i = 0; i < half; i++) {
            list.get(i).next = list.get(list.size() - 1 - i);
            list.get(list.size() - 1 - i).next = i == half -1 ? null : list.get(i+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}